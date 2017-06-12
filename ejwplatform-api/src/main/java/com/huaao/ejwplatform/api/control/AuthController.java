package com.huaao.ejwplatform.api.control;

import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.ems.DtoEmsMailNumRequest;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsMailStatusRequest;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsPayResultRequest;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsRefundResultRequest;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsRequest;
import com.alibaba.druid.support.json.JSONUtils;
import com.huaao.ejwplatform.api.dto.auth.DtoFindPwdRequest;
import com.huaao.ejwplatform.api.dto.auth.DtoHasPhoneRequest;
import com.huaao.ejwplatform.api.dto.auth.DtoLoginRequest;
import com.huaao.ejwplatform.api.dto.auth.DtoRegisterRequest;
import com.huaao.ejwplatform.api.dto.auth.DtoSendSmsCodeRequest;
import com.huaao.ejwplatform.api.dto.bean.RegUser;
import com.huaao.ejwplatform.api.dto.bean.VerifyInfo;
import com.huaao.ejwplatform.api.dto.deptinformation.DtoDeptInfomationImportRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.ErrorInfo;
import com.huaao.ejwplatform.common.sms.SmsUtil;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.util.RandomUtil;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.EmsUtils;
import com.huaao.ejwplatform.dao.JwEms;
import com.huaao.ejwplatform.dao.JwEmsExample;
import com.huaao.ejwplatform.dao.JwEmsPayResult;
import com.huaao.ejwplatform.dao.JwEmsPayResultExample;
import com.huaao.ejwplatform.dao.SysAuditRecordWithBLOBs;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.mapper.JwEmsMapper;
import com.huaao.ejwplatform.mapper.JwEmsPayResultMapper;
import com.huaao.ejwplatform.service.CriminalService;
import com.huaao.ejwplatform.service.JwDeptInformationService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.ems.EmsService;
import com.huaao.ejwplatform.service.model.SmsEnum;
import com.huaao.ejwplatform.service.sms.SmsService;

@ApiDescription("用户认证")
@Controller
@RequestMapping("api/auth")
public class AuthController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${uploadPath}")
	private String uploadPath;
	
	@Autowired
	private JwDeptInformationService deptInformationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SmsService smsService;
	
	@Autowired
	private EmsService emsService;
	
	@Autowired
	private JwEmsPayResultMapper emsPayMapper;
	
	@Autowired
	private JwEmsMapper jwEmsMapper;
	
	@Autowired
	private CriminalService criminalService;
	
	@ApiDescription("用户注册;负责人：shilei")
	@RequestMapping("register")
	@ResponseBody
	public DtoPublicResponseObj<RegUser> register(@Valid DtoRegisterRequest dto) throws Exception{
		DtoPublicResponseObj<RegUser> resp = new DtoPublicResponseObj<RegUser>();
 		try {
			if(userService.queryUserByPhone(dto.getPhone())!=null){
				resp.setCode(Constants.API_CODE_FAIL);
				resp.setMsg("手机号已存在");
				return resp;
			}
			if(!smsService.checkSmsCode(dto.getPhone(), dto.getCode(), SmsEnum.REGISTER.getDesc())){
				resp.setCode(Constants.API_CODE_FAIL);
				resp.setMsg("验证码不正确");
				return resp;
			}
			
			SysUser user = new SysUser();
			user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			user.setPhone(dto.getPhone());
			user.setPassword(dto.getPassword());
			user.setIsUseable(1);
			user.setUserName(dto.getPhone());
			user.setType("foreUser");
			user.setRealname(dto.getPhone());
			user.setAuth("noAuth");
			user.setDeviceId(dto.getDeviceID());
			user = userService.addUser(user);
			
			RegUser regu = new RegUser();
			regu.setId(user.getId());
			regu.setPhone(user.getPhone());
			regu.setRealname(user.getRealname());
			regu.setUsername(user.getUserName());
			regu.setType(user.getType());
			
			resp.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			throw e;
		}
		return resp;
	}
	
	@ApiDescription("手机号是否存在;负责人：shilei")
	@RequestMapping("hasphone")
	@ResponseBody
	public DtoPublicResponseObj<Boolean> hasPhone(@Valid DtoHasPhoneRequest dto){
		DtoPublicResponseObj<Boolean> resp = new DtoPublicResponseObj<Boolean>();
		try {
			SysUser user = userService.queryUserByPhone(dto.getPhone());
			resp.setData(user==null?false:true);
			resp.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("查询失败");
			log.error("check phone fail", e);
		}
		return resp;
	}
	
	@ApiDescription("找回密码;负责人：shilei")
	@RequestMapping("findPwd")
	@ResponseBody
	public DtoPublicResponseObj<String> findPwd(@Valid DtoFindPwdRequest dto){
		DtoPublicResponseObj<String> resp = new DtoPublicResponseObj<String>();
		try{
			SysUser user = userService.queryUserByPhone(dto.getPhone());
			if(user == null){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("手机号不存在");
				return resp;
			}
			if(!smsService.checkSmsCode(dto.getPhone(), dto.getCode(), SmsEnum.FINDPWD.getDesc())){
				resp.setCode(Constants.API_CODE_FAIL);
				resp.setMsg("验证码不正确");
				return resp;
			}
			user.setPassword(dto.getPassword());
			userService.updatePassword(user);
			resp.setCode(Constants.API_CODE_SUCCESS);
		}catch(Exception e){
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("密码更新失败");
		}
		return resp;
	}
	
	@ApiDescription("用户登录;负责人：shilei")
	@RequestMapping("login")
	@ResponseBody
	public DtoPublicResponseObj<Map<String, Object>> login(@Valid DtoLoginRequest dto, HttpServletRequest request ){
		
		String ua = request.getHeader("User-Agent");
		log.info("User-Agent : {}", ua);
		
		String deviceType = "web";
		if(StringUtils.isBlank(ua)){
			deviceType = "pc";
		}else if(ua.indexOf("iOS")>-1){
			deviceType = "ios";
		}else if(ua.indexOf("okhttp")>-1){
			deviceType = "android";
		}
		
		DtoPublicResponseObj<Map<String, Object>> resp = new DtoPublicResponseObj<Map<String, Object>>();
		try {
			SysUser user = userService.queryUserByPhone(dto.getPhone());
			if(user == null){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("手机号未注册");
				return resp;
			}
			if(!userService.checkPassword(user, dto.getPassword())){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("用户名或密码不正确");
				return resp;
			}
			String gtCode = null;
			if (StringUtils.isNotBlank(dto.getGtCode())){
				gtCode = dto.getGtCode();
			}
			user.setGtCode(gtCode);
			user.setDeviceId(dto.getDeviceID());
			user.setDeviceToken(dto.getDeviceToken());
			user.setDeviceType(deviceType);
			
			Map<String, Object> data = userService.loginUpdate(user);
			
			resp.setData(data);

		} catch (Exception e) {
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("登录验证失败");
			log.error("", e);
		}
		return resp;
	}
	
	@ApiDescription("web用户登录;负责人：shilei")
	@RequestMapping("weblogin")
	@ResponseBody
	public DtoPublicResponseObj<Map<String, Object>> weblogin(@Valid DtoLoginRequest dto, HttpServletRequest request ){
		
		String ua = request.getHeader("User-Agent");
		log.info("User-Agent : {}", ua);
		
		DtoPublicResponseObj<Map<String, Object>> resp = new DtoPublicResponseObj<Map<String, Object>>();
		try {
			SysUser user = userService.queryUserByPhone(dto.getPhone());
			if(user == null){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("手机号未注册");
				return resp;
			}
			if(!userService.checkPassword(user, dto.getPassword())){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("用户名或密码不正确");
				return resp;
			}
			if((user.getIsWebLogin()!=null&&user.getIsWebLogin().intValue()==0)||!"authed".equals(user.getAuth())){
				resp.setCode(Constants.API_CODE_PERMISSION_DENIED);//500
				resp.setMsg(Constants.API_MSG_PERMISSION_DENIED);
				return resp;
			}
			
			Map<String, Object> data = userService.login(user.getId(), false, true, false, false, false, false, true);
			
			resp.setData(data);
			
		} catch (Exception e) {
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("登录验证失败");
			log.error("", e);
		}
		return resp;
	}
	
	@ApiDescription("退出登录;负责人：shilei")
	@RequestMapping("loginOut")
	@ResponseBody
	public DtoPublicResponseObj<String> loginOut(@Valid DtoPublicRequest dto){
		DtoPublicResponseObj<String> resp = new DtoPublicResponseObj<String>();
		try {
			userService.loginOut(dto.getToken());
		} catch (Exception e) {
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("退出失败");
			log.error("", e);
		}
		return resp;
	}
	

	@ApiDescription("发送验证码;负责人：shilei")
	@RequestMapping("sendSmsCode")
	@ResponseBody
	public DtoPublicResponse sendSmsCode(@Valid DtoSendSmsCodeRequest dto){
		DtoPublicResponse resp = new DtoPublicResponse();
		try {
			SysUser user = userService.queryUserByPhone(dto.getPhone());
			if(SmsEnum.REGISTER.getDesc().equals(dto.getType())&&user!=null){
				resp.setCode(Constants.API_CODE_PHONE_DUPLICATE);
				resp.setMsg(Constants.API_MSG_PHONE_DUPLICATE);
				return resp;
			}else if(SmsEnum.FINDPWD.getDesc().equals(dto.getType())&&user==null){
				resp.setCode(Constants.API_CODE_PHONE_NOTEXSITS);
				resp.setMsg(Constants.API_MSG_PHONE_NOTEXISTS);
				return resp;
			}
			String num = RandomUtil.getNum(6);
			String msg = SmsUtil.send(dto.getPhone(),num);
			
			log.info("sms send code return : {}", msg);
			
			Map<String ,Object> resmap = JSONUtil.decodeJsonToMap(msg);
			if(resmap!=null&&"000000".equals(resmap.get("statusCode"))){
				smsService.cashSmsCode(dto.getPhone(), num, dto.getType());
			}else{
				resp.setCode(Constants.API_CODE_SERVER_ERROR);
				resp.setMsg("验证码发送失败");
				return resp;
			}
		} catch (Exception e) {
			log.error("",e);
			resp.setCode(Constants.API_CODE_SERVER_ERROR);
			resp.setMsg(Constants.API_MSG_SERVER_ERROR);
		}
		return resp;
		
	}
	
	
	/**
	 * EMS上门取件状态反馈接口
	 * @param DtoEmsMailNumRequest
	 * @return
	 */
	@ApiDescription("接收EMS上门取件状态;负责人：jinsu")
	@RequestMapping("receiveMailNum")
	@ResponseBody
	public DtoPublicResponse receiveMailNum(@Valid DtoEmsMailNumRequest dtoRequest){
		DtoPublicResponse resp = new DtoPublicResponse();
		ErrorInfo info = emsService.saveEmsMailNum(dtoRequest.getTxLogisticID(), dtoRequest.getStatus(), dtoRequest.getMailNum(), dtoRequest.getDesc());
		if(info == null){
			resp.setCode(Constants.API_CODE_SUCCESS);
		}else{
			resp.setCode(info.getErrorCode());
			resp.setMsg(info.getErrorMsg());
		}
		return resp;
	
	}
	
	/**
	 * EMS物流状态反馈接口
	 * @param DtoEmsMailStatusRequest
	 * @return
	 */
	@ApiDescription("EMS物流状态反馈接口;负责人：jinsu")
	@RequestMapping("receiveMailStatus")
	@ResponseBody
	public String receiveMailStatus( @RequestBody String params, @RequestHeader HttpHeaders headers){
		//List list = (List) params.get("listexpressmail");
		log.info("receive ems status req "+params);
		Map<String, Object> map = JSONUtil.decodeJsonToMap(URLDecoder.decode(params));
		
		List<Object> list = (List<Object>) map.get("listexpressmail");
		String result = emsService.saveEmsMailStatus(list);
		Map<String, Object> resp = new HashMap<String, Object>();
		
		String authenticate = headers.getFirst("authenticate");
		String version = headers.getFirst("version");
//		if(StringUtils.isEmpty(authenticate) || !authenticate.equals("WJW80000007942136") || StringUtils.isEmpty(version) || !version.equals("1.0.7")){
//			log.error("Invalid headers "+JSONUtil.jsonEncode(headers));
//			resp.put("code", Constants.API_CODE_PERMISSION_DENIED);//500
//			resp.put("msg", Constants.API_MSG_PARAMS_INVALID);
//		}else 
		if(StringUtils.isEmpty(result)){
			resp.put("success", 1);
			resp.put("failmailnums", "");
			resp.put("remark", "");
		}else{
			resp.put("success", 0);
			resp.put("failmailnums", result);
			resp.put("remark", "");
		}
		Map<String, Object> rsp = new HashMap<String, Object>();
		rsp.put("response", resp);
		return JSONUtils.toJSONString(rsp);
	
	}
	
	public boolean isSignValid(DtoEmsRequest req){
		String serverSign = EmsUtils.generatorPaySign(JSONUtil.jsonEncode(req));
		//System.out.println(serverSign);
		return serverSign.equals(req.getSign());
	}
	
	/**
	 * EMS支付结果异步回调
	 * @param DtoEmsPayResultRequest
	 * @return
	 */
	@ApiDescription("EMS支付结果异步回调接口;负责人：jinsu")
	@RequestMapping("emsPayResult")
	@ResponseBody
	public String emsPayResult(@Valid DtoEmsPayResultRequest dtoRequest){
		log.info("receive ems pay request req "+JSONUtil.jsonEncode(dtoRequest));
		if(handleEmsPayResult(dtoRequest)){
			return "success";
		}
		return "failed";
	}
	
	public boolean handleEmsPayResult(DtoEmsPayResultRequest req){
		if(!isSignValid(req)){
			return false;
		}
		JwEmsPayResultExample example = new JwEmsPayResultExample();
		example.createCriteria().andBizOrderNoEqualTo(req.getBizOrderNo());
		List<JwEmsPayResult> list = emsPayMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			log.error("no exist ems pay result record. skip callback!");
			return false;
		}else{
			JwEmsPayResult pay = list.get(0);
			if(pay.getPayResult().equals("02")){
				log.info("ems pay result duplicat callback skip it!");
				return true;
			}
			FuncTool.copyProperties(req, pay);
			emsPayMapper.updateByPrimaryKeySelective(pay);
			if(pay.getPayResult().equals("02")){
				emsService.pushEmsOrder(pay.getRecordId(), req.getBizOrderNo());
				criminalService.addSelectReceive(pay.getRecordId());
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * EMS支付结果同步回调
	 * @param DtoEmsPayResultRequest
	 * @return
	 */
	@ApiDescription("EMS支付结果同步回调接口;负责人：jinsu")
	@RequestMapping("emsPayCallback")
	public String emsPayCallback(@Valid DtoEmsPayResultRequest dtoRequest, Model model){
		log.info("receive ems pay request req "+JSONUtil.jsonEncode(dtoRequest));
		model.addAttribute("payResult", "01");
		if(handleEmsPayResult(dtoRequest)){
			model.addAttribute("payResult", dtoRequest.getPayResult());
			JwEmsExample example = new JwEmsExample();
			example.createCriteria().andTxLogisticIdEqualTo(dtoRequest.getBizOrderNo());
			example.setOrderByClause("create_time desc");
			List<JwEms> list = jwEmsMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				model.addAttribute("mailNum", list.get(0).getMailNum());
			}
		}
		return "/emsPayResult.jsp";
	}
	
	/**
	 * EMS退款结果回调
	 * @param DtoEmsRefundResultRequest
	 * @return
	 */
	@ApiDescription("EMS退款结果回调接口;负责人：jinsu")
	@RequestMapping("emsRefundResult")
	@ResponseBody
	public String emsRefundResult(@Valid DtoEmsRefundResultRequest dtoRequest){
		//if(dtoRequest.isSignValid()){
			JwEmsPayResultExample example = new JwEmsPayResultExample();
			example.createCriteria().andBizOrderNoEqualTo(dtoRequest.getBizOrderNo());
	        List<JwEmsPayResult> result = emsPayMapper.selectByExample(example);
			if(result != null && result.size() > 0){
				JwEmsPayResult pay = result.get(0);
				FuncTool.copyProperties(dtoRequest, pay);
				emsPayMapper.updateByPrimaryKey(pay);
			}
		//}else{
		//	log.error("untrust data "+JSONUtil.jsonEncode(dtoRequest));
		//}
		return "success";
	}
	
	@ApiDescription("微信息数据导入;负责人：yuhai")
	@RequestMapping("importDeptInfo")
	@ResponseBody
	public DtoPublicResponse importLifeData(@Valid DtoDeptInfomationImportRequest dtoRequest) {
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			String filepath = uploadPath+dtoRequest.getFilepath();
			File f = new File(filepath);
			if(!f.exists()){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg("文件不存在");
				log.error("微信息数据导入失败，"+filepath+"文件不存在");
				return dtoResponse;
			}
	        
			Map<String , Object> result = deptInformationService.importDeptInformationData(filepath, dtoRequest.getDeptId());
			dtoResponse.setCode((Integer)result.get("code"));
			dtoResponse.setMsg((String)result.get("msg"));
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("微信息数据导入失败");
			log.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
}
