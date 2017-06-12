package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.auth.DtoUpdatePwdRequest;
import com.huaao.ejwplatform.api.dto.bean.AreaInfo;
import com.huaao.ejwplatform.api.dto.bean.DeptInfo;
import com.huaao.ejwplatform.api.dto.bean.UserInfo;
import com.huaao.ejwplatform.api.dto.bean.UserShortInfo;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.dto.user.DtoAuthRequest;
import com.huaao.ejwplatform.api.dto.user.DtoPoliceContactRequest;
import com.huaao.ejwplatform.api.dto.user.DtoUpdateAuthStatusRequest;
import com.huaao.ejwplatform.api.dto.user.DtoUpdateUserInfoRequest;
import com.huaao.ejwplatform.api.dto.user.DtoUserQueryRequest;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.SysArea;
import com.huaao.ejwplatform.dao.SysAuditRecordWithBLOBs;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysJobs;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.dao.SysUserAudit;
import com.huaao.ejwplatform.dao.UserDto;
import com.huaao.ejwplatform.service.AuditRecordService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.model.CommonDict;
import com.huaao.ejwplatform.service.sms.SmsService;
import com.huaao.ejwplatform.service.system.AreaService;
import com.huaao.ejwplatform.service.system.DeptService;

@ApiDescription("用户信息")
@Controller
@RequestMapping("/api/user")
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private SmsService smsService;
	@Autowired
	private AuditRecordService auditRecordService;
	/**
	 * 用户列表查询
	 * @param dtoRequest
	 * @return
	 */
	@ApiDescription("查询用户列表;负责人：lihao")
	@RequestMapping("queryUserList")
	@ResponseBody
	public DtoPublicResponsePager<UserInfo> queryUserList(@Valid DtoUserQueryRequest dtoRequest)  throws Exception {
		DtoPublicResponsePager<UserInfo> dtoResponse = new DtoPublicResponsePager<UserInfo>();
		//实名认证，只能派出所以上级别可以看到 
		if(dtoRequest.getAuth()!=null && 
				(dtoRequest.getAuth().contains("authing") || dtoRequest.getAuth().contains("authed,authFail")  )){
			SysUser user = userService.getUserById(dtoRequest.getUid());
			String code = deptService.getDeptById(user.getDeptId()).getCode();
			if(code == null || code.length() > 16){
				return dtoResponse;
			}
		}
		
		Page p = null;
		List<SysUser> list = null;
		if(!StringUtils.isEmpty(dtoRequest.getUserIds()) ){
			list = userService.queryUserList(dtoRequest.getUserIds().split(","));
			
		}else{
			p = ApiTool.convert(dtoRequest);
			SysUser sysUser = FuncTool.copyPropertiesClass(dtoRequest, SysUser.class);
			sysUser.setId(dtoRequest.getUid());
			list = userService.queryUserList(sysUser, p,dtoRequest.getKeyword());
		}
		List<UserInfo> lus = FuncTool.copyPropertiesList(list, UserInfo.class);
		
		List<String> jobIds = new ArrayList<>();
		List<String> deptIds = new ArrayList<>();
		List<String> userIds = new ArrayList<>();
		for(SysUser item : list){
			if(!StringUtils.isEmpty(item.getJobsId())){
				jobIds.add(item.getJobsId());
			}
			if(!StringUtils.isEmpty(item.getDeptId())){
				deptIds.add(item.getDeptId());
			}
			if(dtoRequest.getAuth()!=null && "authing".equals(dtoRequest.getAuth())){
				userIds.add(item.getId());
			}
		}
		
		List<SysJobs> listJobs = userService.queryJobsByIds(jobIds);
		Map<String,String> map = new HashMap<>();
		for(SysJobs item : listJobs){
			map.put(item.getId(), item.getName());
		}
		
		List<SysDeptWithBLOBs> listDepts = deptService.queryDeptByIds(deptIds);
		Map<String,DeptInfo> mapDept = new HashMap<>();
		for(SysDeptWithBLOBs item : listDepts){
			mapDept.put(item.getId(), FuncTool.copyPropertiesClass(item, DeptInfo.class) );
		}
		
		List<SysAuditRecordWithBLOBs> listAr = auditRecordService.queryByApplyIds(userIds);
		Map<String,SysAuditRecordWithBLOBs> mapRecord = new HashMap<>();
		for(SysAuditRecordWithBLOBs item : listAr){
			if(!mapRecord.containsKey(item.getApplyId())){
				mapRecord.put(item.getApplyId(), item);
			}
		}
		
		for(UserInfo item : lus){
			item.setJobsName(map.get(item.getJobsId()));
			item.setDeptInfo(mapDept.get(item.getDeptId()));
			if(item.getDeptInfo() != null && !StringUtils.isEmpty(item.getDeptId())  ){
				SysArea sysArea = areaService.querySysAreaById(item.getDeptInfo().getAreaId());
				item.setAreaInfo(FuncTool.copyPropertiesClass(sysArea, AreaInfo.class));
			}
			if(!StringUtils.isEmpty(item.getAuthtorId())){
				item.setAuthInfo(FuncTool.copyPropertiesClass(userService.queryUser(item.getAuthtorId()), UserShortInfo.class ));
			}
			
			if(mapRecord.containsKey(item.getId())){
				item.setRealname(mapRecord.get(item.getId()).getRealname());
			}
		}
		
		dtoResponse.setData(lus);
		ApiTool.fillPagerData(p, dtoResponse);
		return dtoResponse;
	}
	
	@ApiDescription("更新用户信息;负责人：lihao")
	@RequestMapping("updateUserInfo")
	@ResponseBody
	public DtoPublicResponse updateUserInfo(@Valid DtoUpdateUserInfoRequest dtoRequest){
		try {
			userService.updateUserInfo(dtoRequest.getUid(),FuncTool.copyPropertiesClass(dtoRequest, SysUser.class));
			return DtoPublicResponse.init();
		} catch (Exception e) {
			return DtoPublicResponse.fail("处理失败 "+e.getMessage());
		}
	}
	
	@ApiDescription("实名认证审核;负责人：lihao")
	@RequestMapping("updateAuthStatus")
	@ResponseBody
	public DtoPublicResponse updateAuthStatus(@Valid DtoUpdateAuthStatusRequest  dtoRequest)  throws Exception {
		String authUserId = dtoRequest.getId();
		String uid = dtoRequest.getUid();
		if(StringUtils.isEmpty(authUserId)){
			return DtoPublicResponse.fail("申请人ID不能为空!");
		}
		if(StringUtils.isEmpty(uid)){
			return DtoPublicResponse.fail("审核人ID不能为空!");
		}
		if(uid.equals(authUserId)){
			return DtoPublicResponse.fail("不能审核自己提交的实名认证申请!");
		}
		try {
			userService.updateAuthStatus(dtoRequest.getUid(),dtoRequest.getAuth(),dtoRequest.getAuthMsg(),dtoRequest.getId());
			return DtoPublicResponse.init();
		} catch (Exception e) {
			return DtoPublicResponse.fail(e.getMessage());
		}
	}

	@ApiDescription("更新密码;负责人：shilei")
	@RequestMapping("updatePwd")
	@ResponseBody
	public DtoPublicResponseObj<String> updatePwd(@Valid DtoUpdatePwdRequest dto){
		DtoPublicResponseObj<String> resp = new DtoPublicResponseObj<String>();
		try{
			SysUser user = userService.queryUserByPhone(dto.getPhone());
			if(user == null){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("手机号不存在");
				return resp;
			}
			if(!userService.checkPassword(user, dto.getPassword())){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("您输入的原密码不正确");
				return resp;
			}
			String id = user.getId();
			user = new SysUser();
			user.setId(id);
			user.setPassword(dto.getRawPassword());
			userService.updatePassword(user);
		}catch(Exception e){
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("密码更新失败");
		}
		return resp;
	}
	
	@ApiDescription("实名认证提交;负责人：lihao ")
	@RequestMapping("auth")
	@ResponseBody
	public DtoPublicResponse auth(@Valid DtoAuthRequest  dtoRequest, HttpServletRequest  httpRequest){
		try {
			SysUser old = userService.queryUser(dtoRequest.getUid());
			if("authing".equals(old.getAuth())){
				return DtoPublicResponse.fail("资料审核中");
			}
			SysUserAudit sysUser = new SysUserAudit();
			BeanUtils.copyProperties(old, sysUser);
			sysUser.setType(dtoRequest.getType());
			if(StringUtils.isEmpty(dtoRequest.getDeptId()) ){
				sysUser.setDeptId(httpRequest.getParameter("dept.id"));
			}else{
				sysUser.setDeptId(dtoRequest.getDeptId());
			}
			if(StringUtils.isEmpty(dtoRequest.getJobsId()) ){
				sysUser.setJobsId(httpRequest.getParameter("jobs.id"));
			}else{
				sysUser.setJobsId(dtoRequest.getJobsId());
			}
			sysUser.setIdCard(dtoRequest.getCardcode());
			sysUser.setIdcardImg1(dtoRequest.getCardImg1());
			sysUser.setIdcardImg2(dtoRequest.getCardImg2());
			sysUser.setPolicemanCode(dtoRequest.getPolicemanCode());
			sysUser.setRealname(dtoRequest.getRealname());
//			sysUser.setAuth("authing");
//			sysUser.setAuthMsg("认证中");
//			sysUser.setAuthingTime(new Date());
			sysUser.setAddress(dtoRequest.getAddress());
			userService.auth(sysUser, old);
			return DtoPublicResponse.init();
		} catch (Exception e) {
			return DtoPublicResponse.fail(e.getMessage());
		}
	}
	
	@ApiDescription("民警热线;负责人：lihao ;查找小区关联警务室，已实名认证的民警;"
			+ "1.纯居民登录进入民警热线应该看到的是警务室级别的人员;"
			+ "2.社区民警身份的居民进入民警热线应该看到的是警务室级别的人员;"
			+ "3.派出所级别身份的居民进入民警热线应该看到的是派出所级别的人员;")
	@RequestMapping("policeContact")
	@ResponseBody
	public DtoPublicResponsePager<UserShortInfo> policeContact (@Valid DtoPoliceContactRequest dtoRequest)  throws Exception {
		DtoPublicResponsePager<UserShortInfo> response = new DtoPublicResponsePager<>();
		SysUser sysUser = userService.getUserById(dtoRequest.getUid());
		
		if(StringUtils.isEmpty(sysUser.getDeptId()) ){
			response.setFail("该用户无所属部门");
			return response;
		}

		SysDeptWithBLOBs dept = deptService.getDeptById(sysUser.getDeptId());
		if(StringUtils.isEmpty(dept.getLinkDeptId()) && CommonDict.USER_TYPE_BACK_USER.equals(sysUser.getType())){
			dept.setLinkDeptId(sysUser.getDeptId());
		}
		if(!StringUtils.isEmpty(dept.getLinkDeptId())){
			Page p = ApiTool.convert(dtoRequest);
			List<SysUser> list = userService.queryPoliceByDeptId(dept.getLinkDeptId(),p);
			List<UserShortInfo> data = FuncTool.copyPropertiesList(list, UserShortInfo.class);
			
			List<String> jobIds = new ArrayList<>();
			List<String> deptIds = new ArrayList<>();
			for(SysUser item : list){
				if(!StringUtils.isEmpty(item.getJobsId())){
					jobIds.add(item.getJobsId());
				}
				if(!StringUtils.isEmpty(item.getDeptId())){
					deptIds.add(item.getDeptId());
				}
			}
			
			List<SysJobs> listJobs = userService.queryJobsByIds(jobIds);
			Map<String,String> map = new HashMap<>();
			for(SysJobs item : listJobs){
				map.put(item.getId(), item.getName());
			}
			
			List<SysDeptWithBLOBs> listDepts = deptService.queryDeptByIds(deptIds);
			Map<String,DeptInfo> mapDept = new HashMap<>();
			for(SysDeptWithBLOBs item : listDepts){
				mapDept.put(item.getId(), FuncTool.copyPropertiesClass(item, DeptInfo.class) );
			}
			
			for(UserShortInfo item : data){
				item.setJobsName(map.get(item.getJobsId()));
				if(mapDept.get(item.getDeptId()) != null && !StringUtils.isEmpty(item.getDeptId())  ){
					item.setDeptName(mapDept.get(item.getDeptId()).getName());
					item.setAreaId(mapDept.get(item.getDeptId()).getAreaId());
					SysArea sysArea = areaService.querySysAreaById(mapDept.get(item.getDeptId()).getAreaId());
					if(sysArea != null){
						item.setAreaName(sysArea.getName());
					}
				}
			}
			
			response.setData(data);
		}else{
			response.setFail("该用户无关联警务室");
		}
		return response;
	}
	
	@ApiDescription("根据token获取用户认证信息;负责人：shilei")
	@RequestMapping("queryUserAuditByToken")
	@ResponseBody
	public DtoPublicResponseObj<Map<String, Object>> queryAuthInfoByToken(DtoPublicRequest req){
		DtoPublicResponseObj<Map<String, Object>> resp = new DtoPublicResponseObj<Map<String, Object>>();
		try {
			Map<String, Object> data = userService.getUserAuditById(req.getUid());
			resp.setData(data);
			resp.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			log.error("queryUserAuditByToken fail",e);
			resp.setCode(Constants.API_CODE_FAIL);
			resp.setMsg(Constants.API_MSG_SERVER_ERROR);
		}
		return resp;
	}
	
	@ApiDescription("查询申请人信息;负责人：shilei")
	@RequestMapping("queryUserAuitList")
	@ResponseBody
	public DtoPublicResponsePager<UserDto> queryUserAuitList(@Valid DtoUserQueryRequest req){
		DtoPublicResponsePager<UserDto> resp = new DtoPublicResponsePager<UserDto>();
		try {
			SysDeptWithBLOBs dept = deptService.getDeptByUserId(req.getUid());
			if(dept==null){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("找不到用户归属");
				return resp;
			}
			Page page = new Page(req.getPage(),req.getPageSize());
			page.setSortby(org.apache.commons.lang.StringUtils.isBlank(req.getSortby())?"authing_time desc":req.getSortby());
			List<UserDto> list = userService.queryUserAuditList(dept.getCode(), req.getKeyword(), page);
			resp.setData(list);
			resp.setPage(page.getPageNum());
			resp.setPageSize(page.getPageSize());
			resp.setRecords(page.getTotalCount());
		} catch (Exception e) {
			log.error("" ,e);
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setFail("查询申请信息失败");
		}
		return resp;
	}
	
}
