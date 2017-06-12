package com.huaao.ejwplatform.api.control.ems;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.area.DtoAreaFindByIdRequest;
import com.huaao.ejwplatform.api.dto.area.DtoAreaFindByParentRequest;
import com.huaao.ejwplatform.api.dto.area.DtoAreaFindByParentResponse;
import com.huaao.ejwplatform.api.dto.bean.EmsPayInfo;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsGotRequest;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsPayRequest;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsStatusRequest;
import com.huaao.ejwplatform.api.dto.ems.DtoEmsStatusResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.ErrorInfo;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.EmsUtils;
import com.huaao.ejwplatform.dao.JwCriminalRecord;
import com.huaao.ejwplatform.dao.JwEms;
import com.huaao.ejwplatform.dao.JwEmsArea;
import com.huaao.ejwplatform.dao.JwEmsExample;

import com.huaao.ejwplatform.dao.JwEmsInfo;
import com.huaao.ejwplatform.dao.JwEmsInfoExample;
import com.huaao.ejwplatform.dao.JwEmsPayResult;
import com.huaao.ejwplatform.dao.JwEmsPayResultExample;
import com.huaao.ejwplatform.dao.JwEmsStatus;
import com.huaao.ejwplatform.dao.JwEmsStatusExample;
import com.huaao.ejwplatform.dao.SysAreaExt;
import com.huaao.ejwplatform.mapper.JwCriminalRecordMapper;
import com.huaao.ejwplatform.mapper.JwEmsInfoMapper;
import com.huaao.ejwplatform.mapper.JwEmsMapper;
import com.huaao.ejwplatform.mapper.JwEmsPayResultMapper;
import com.huaao.ejwplatform.mapper.JwEmsStatusMapper;
import com.huaao.ejwplatform.service.ems.EmsService;

import io.netty.util.internal.StringUtil;

@ApiDescription("邮政EMS接口")
@Controller
@RequestMapping("/api/ems")
public class EmsController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmsService emsService;
	
	@Autowired
	private JwEmsInfoMapper emsInfoMapper;
	
	@Value("${emsPayAmount}")
	private String emsPayAmount;
	
	@Autowired
	private JwCriminalRecordMapper recordMapper;
	
	@Autowired
	private JwEmsPayResultMapper emsPayMapper;
	
	@Autowired
	private JwEmsMapper jwEmsMapper;
	
	@Autowired
	private JwEmsStatusMapper statusMapper;
	
	/**
	 * 测试EMS下单
	 * @param DtoEmsOrderRequest
	 * @return
	 */
	@ApiDescription("测试EMS订单接入;负责人：jinsu")
	@RequestMapping(value="emsOrder", method=RequestMethod.GET)
	@ResponseBody
	public DtoPublicResponseObj<Map> emsOrder(@Valid DtoEmsGotRequest dtoRequest){
		DtoPublicResponseObj<Map> resp = new DtoPublicResponseObj<Map>();
		JwEmsPayResultExample example = new JwEmsPayResultExample();
		example.createCriteria().andRecordIdEqualTo(dtoRequest.getRecordId()).andPayResultEqualTo("02");
		List<JwEmsPayResult> list = emsPayMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			resp.setCode(Constants.API_CODE_SERVER_ERROR);
			resp.setMsg(Constants.API_MSG_SERVER_ERROR);
		}else{
			ErrorInfo info = emsService.pushEmsOrder(dtoRequest.getRecordId(), list.get(0).getBizOrderNo());
			JwEmsExample exam = new JwEmsExample();
			exam.createCriteria().andTxLogisticIdEqualTo(list.get(0).getBizOrderNo());
			exam.setOrderByClause("create_time desc");
			List<JwEms> emsList = jwEmsMapper.selectByExample(exam);
			Map<String, String> map = new HashMap<String, String>();
			map.put("mailnum", emsList.get(0).getMailNum());
			resp.setData(map);
		}
		return resp;
	}
	
	/**
	 * 跳转EMS收银台支付订单
	 * @param DtoEmsRequest
	 * @return
	 */
	@ApiDescription("跳转EMS收银台支付订单;负责人：jinsu")
	@RequestMapping(value="emsPay", method=RequestMethod.GET)
	public String emsPay(@Valid DtoEmsPayRequest dtoRequest, Model model){
		model.addAttribute("recordId", dtoRequest.getId());
		model.addAttribute("token", dtoRequest.getToken());

		JwEmsInfo info = new JwEmsInfo();
		info.setRecordId(dtoRequest.getId());
		boolean update = false;
		
		if(!StringUtils.isEmpty(dtoRequest.getAreaId())){
			info.setAreaId(dtoRequest.getAreaId());
			update = true;
		}
		if(!StringUtils.isEmpty(dtoRequest.getPhone())){
			info.setPhone(dtoRequest.getPhone());
			update = true;
		}
		if(!StringUtils.isEmpty(dtoRequest.getPostcode())){
			info.setPostcode(dtoRequest.getPostcode());
			update = true;
		}
		if(!StringUtils.isEmpty(dtoRequest.getUsername())){
			info.setUsername(dtoRequest.getUsername());
			update = true;
		}
		if(!StringUtils.isEmpty(dtoRequest.getAddress())){
			info.setAddress(dtoRequest.getAddress());
			update = true;
		}
		if(update){
			JwEmsInfoExample example = new JwEmsInfoExample();
			example.createCriteria().andRecordIdEqualTo(dtoRequest.getId());
			int num = emsInfoMapper.countByExample(example);
			if(num == 0){
				emsInfoMapper.insertSelective(info);
			}else{
				emsInfoMapper.updateByPrimaryKeySelective(info);
			}
		}
		return "/emsPay.jsp";
	}
	
	/**
	 * 跳转EMS收银台支付订单
	 * @param DtoEmsRequest
	 * @return
	 */
	@ApiDescription("跳转EMS收银台支付订单;负责人：jinsu")
	@RequestMapping(value="emsPay", method=RequestMethod.POST)
	@ResponseBody
	public DtoPublicResponseObj<EmsPayInfo> emsPay(@Valid DtoEmsPayRequest dtoRequest){
		DtoPublicResponseObj<EmsPayInfo> resp = new DtoPublicResponseObj<EmsPayInfo>();
		String id = dtoRequest.getId();
		JwCriminalRecord record = recordMapper.selectByPrimaryKey(id);
		//validate pay info
		JwEmsPayResultExample example = new JwEmsPayResultExample();
		example.createCriteria().andRecordIdEqualTo(id).andPayResultNotEqualTo("01");
		List<JwEmsPayResult> list = emsPayMapper.selectByExample(example);
		//validate area info
		JwEmsInfoExample exam = new JwEmsInfoExample();
		exam.createCriteria().andRecordIdEqualTo(id);
		List<JwEmsInfo> infoList = emsInfoMapper.selectByExample(exam);
		//
		if(record.getRecieveType() != 2){
			resp.setCode(Constants.API_CODE_EMS_STATE_ERROR);
			resp.setMsg(Constants.API_MSG_EMS_STATE_ERROR);
		}else if(list != null && list.size() > 0){
			resp.setCode(Constants.API_CODE_EMS_HAS_PAY);
			resp.setMsg(Constants.API_MSG_EMS_HAS_PAY);
		}else if(infoList == null || infoList.size() == 0){
			resp.setCode(Constants.API_CODE_EMS_NO_ADDRESS);
			resp.setMsg(Constants.API_MSG_EMS_NO_ADDRESS);
		}else if(infoList != null && infoList.size() > 0 && !(StringUtils.isNumeric(infoList.get(0).getAreaId()))){
			resp.setCode(Constants.API_CODE_EMS_NO_ADDRESS);
			resp.setMsg(Constants.API_MSG_EMS_NO_ADDRESS);
		}else{
			EmsPayInfo info = new EmsPayInfo();
			info.setBizOrderNo(emsService.genEmsOrderNo(id, record.getDeptId()));
			info.setOrderName("微警务EMS订单"+id);
			info.setBizType("01");
			info.setAppKey(EmsUtils.EMS_PAY_APP_KEY);
			info.setCharset("UTF-8");
			info.setCurrency("156");
			info.setPayAmount(emsPayAmount);
			info.setPayType("01");
			info.setPayWay("02");
			info.setSign(EmsUtils.generatorPaySign(JSONUtil.jsonEncode(info)));
			resp.setData(info);
		}
		return resp;
	}
 
	@ApiDescription("查询EMS运送状态;负责人：hongli")
	@RequestMapping("queryEmsStatus")
	@ResponseBody
	public DtoPublicResponseList<DtoEmsStatusResponse> queryEmsStatus(@Valid DtoEmsStatusRequest dtoRequest){
		DtoPublicResponseList<DtoEmsStatusResponse> dtoResponse = new DtoPublicResponseList<>();
		try{
			JwEmsStatusExample exam = new JwEmsStatusExample();
			exam.createCriteria().andMailNumEqualTo(dtoRequest.getMailNum()).andEffectEqualTo(1);
			exam.setOrderByClause("procdate desc, proctime desc");
			List<JwEmsStatus> list = statusMapper.selectByExample(exam);
			//String content = EmsUtils.trackMail(dtoRequest.getMailNum());
			List<DtoEmsStatusResponse> emsStatusInfoList = new ArrayList<DtoEmsStatusResponse>();
			for(JwEmsStatus state: list){
				DtoEmsStatusResponse resp = new DtoEmsStatusResponse();
				Date createDate = DateTool.parseDateFromPattern(state.getProcdate()+state.getProctime());
				resp.setCreateTime(createDate.getTime());
				resp.setDescription(state.getDescription());
				emsStatusInfoList.add(resp);
			}
//			Map<String, Object> map = JSONUtil.decodeJsonToMap(content);
//			if(map != null){
//				for(Map<String, Object> trace: (List<Map<String, Object>>)map.get("traces")){
//					DtoEmsStatusResponse resp = new DtoEmsStatusResponse();
//					resp.setCreateTime(DateTool.parseDateTime((String) trace.get("acceptTime")));
//					resp.setDescription(trace.get("acceptAddress")+" "+trace.get("remark"));
//					emsStatusInfoList.add(resp);
//				}
//			}
			dtoResponse.setData(emsStatusInfoList);
		} catch (Exception e) {
			e.printStackTrace();
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("查询EMS运送状态失败");
			log.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("获取EMS区域列表接口;负责人：jinsu;获取区域列表，如果没有parentId，获取根区域，否则根据parentid获取子列表")
	@RequestMapping("findChildrenByParent")
	@ResponseBody
	public DtoPublicResponsePager<JwEmsArea> findChildrenByParent(@Valid DtoAreaFindByParentRequest dtoRequest) {
		DtoPublicResponsePager<JwEmsArea> dtoResponse = new DtoPublicResponsePager<JwEmsArea>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			List<JwEmsArea> areas = emsService.selectAreaList(page, sortby, dtoRequest.getParentId());
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(areas);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			log.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("获取EMS区域信息接口;负责人：jinsu;根据ID获取区域信息")
	@RequestMapping("findAreaById")
	@ResponseBody
	public DtoPublicResponseObj<JwEmsArea> findAreaById(@Valid DtoAreaFindByIdRequest dtoRequest) {
		DtoPublicResponseObj<JwEmsArea> dtoResponse = new DtoPublicResponseObj<JwEmsArea>();
		try{
			JwEmsArea area = emsService.getAreaInfo(dtoRequest.getId());
			dtoResponse.setData(area);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			log.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
}
