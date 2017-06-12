package com.huaao.ejwplatform.api.control.system;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.dept.DtoAreaForDeptFindByIdResponse;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindByAreaRequest;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindByIdRequest;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindByIdResponse;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindByParentRequest;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindPoliceDetailResponse;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindPoliceStationResponse;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptListTypesResponse;
import com.huaao.ejwplatform.api.dto.dept.DtoFindPoliceOfficeRequest;
import com.huaao.ejwplatform.api.dto.dept.DtoFindPoliceStationsRequest;
import com.huaao.ejwplatform.api.dto.dept.DtoFindPoliceStationsResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.dto.user.DtoUserDeptDetailResponse;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.JwBusinessDept;
import com.huaao.ejwplatform.dao.SysArea;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDict;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.service.BusinessDeptService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.system.AreaService;
import com.huaao.ejwplatform.service.system.DeptService;
import com.huaao.ejwplatform.service.system.DictService;

@ApiDescription("部门信息")
@Controller
@RequestMapping("api/dept")
public class DeptController {
	private static final Logger LOG = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private DeptService deptService;

	@Autowired
	private AreaService areaService;
	
	@Autowired
	private BusinessDeptService businessDeptService;

	@Autowired
	private UserService userService;
	
	
	@Value("${dict.depttype}")
	private String deptType;

	@ApiDescription("获取部门类型;负责人：hongli")
	@RequestMapping("listTypes")
	@ResponseBody
	public DtoPublicResponsePager<DtoDeptListTypesResponse> listTypes(@Valid DtoPublicRequestPager dtoRequest) {
		DtoPublicResponsePager<DtoDeptListTypesResponse> dtoResponse = new DtoPublicResponsePager<>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			List<SysDict> sysDicts = dictService.selectDistList(page, sortby, deptType);
			ApiTool.fillPagerData(page, dtoResponse);
			List<DtoDeptListTypesResponse> data = FuncTool.copyPropertiesList(sysDicts, DtoDeptListTypesResponse.class);
			dtoResponse.setData(data);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("根据ID获取部门信息;负责人：hongli")
	@RequestMapping("findById")
	@ResponseBody
	public DtoPublicResponseObj<DtoDeptFindByIdResponse> findById(@Valid DtoDeptFindByIdRequest dtoRequest) {
		DtoPublicResponseObj<DtoDeptFindByIdResponse> dtoResponse = new DtoPublicResponseObj<>();
		try{
			DtoDeptFindByIdResponse data = new DtoDeptFindByIdResponse();
			SysDeptWithBLOBs sysDept = deptService.getDeptById(dtoRequest.getId());
			FuncTool.copyPropertiesExt(sysDept, data);
			SysArea area = areaService.selectByPrimaryKey(sysDept.getAreaId());
			DtoAreaForDeptFindByIdResponse areaResp = new DtoAreaForDeptFindByIdResponse();
			FuncTool.copyPropertiesExt(area, areaResp);
			data.setArea(areaResp);
			dtoResponse.setData(data);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("根据父部门获取部门信息;负责人：hongli")
	@RequestMapping("findByParent")
	@ResponseBody
	public DtoPublicResponsePager<DtoDeptFindByIdResponse> findByParent(@Valid DtoDeptFindByParentRequest dtoRequest) {
		DtoPublicResponsePager<DtoDeptFindByIdResponse> dtoResponse = new DtoPublicResponsePager<>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			SysDeptWithBLOBs sd = new SysDeptWithBLOBs();
			sd.setParentId(dtoRequest.getParentId());
			sd.setType(dtoRequest.getType());
			List<SysDeptWithBLOBs> SysDeptWithBLOBs = deptService.selectDeptList(page, sortby, sd);
			List<DtoDeptFindByIdResponse> data = FuncTool.copyPropertiesListExt(SysDeptWithBLOBs, DtoDeptFindByIdResponse.class);
			for(DtoDeptFindByIdResponse dept:data){
				SysArea area = areaService.selectByPrimaryKey(dept.getAreaId());
				DtoAreaForDeptFindByIdResponse areaResp = new DtoAreaForDeptFindByIdResponse();
				FuncTool.copyPropertiesExt(area, areaResp);
				dept.setArea(areaResp);
			}
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(data);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("查询当前用户所在派出所的所有小区信息;负责人：hongli")
	@RequestMapping("findByUserPoliceStation")
	@ResponseBody
	public DtoPublicResponsePager<DtoDeptFindByIdResponse> findByUserPoliceStation(@Valid DtoPublicRequestPager dtoRequest) {
		DtoPublicResponsePager<DtoDeptFindByIdResponse> dtoResponse = new DtoPublicResponsePager<>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			SysDeptWithBLOBs dept = deptService.getDeptByUserId(dtoRequest.getUid());
			String code = null;
			if(dept.getCode().length() < 15){
				code = dept.getCode();
			}else{
				code = dept.getCode().substring(0, 15);
			}
			SysDeptWithBLOBs sd = new SysDeptWithBLOBs();
			sd.setCode(code);
			sd.setType("小区");
			List<SysDeptWithBLOBs> SysDeptWithBLOBs = deptService.findByUserPoliceStation(page, sortby, sd);
			List<DtoDeptFindByIdResponse> data = FuncTool.copyPropertiesListExt(SysDeptWithBLOBs, DtoDeptFindByIdResponse.class);
			for(DtoDeptFindByIdResponse deptResp:data){
				SysArea area = areaService.selectByPrimaryKey(deptResp.getAreaId());
				DtoAreaForDeptFindByIdResponse areaResp = new DtoAreaForDeptFindByIdResponse();
				FuncTool.copyPropertiesExt(area, areaResp);
				deptResp.setArea(areaResp);
			}
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(data);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	

	@ApiDescription("根据区域ID获取部门列表;负责人：hongli")
	@RequestMapping("findByArea")
	@ResponseBody
	public DtoPublicResponsePager<DtoDeptFindByIdResponse> findByArea(@Valid DtoDeptFindByAreaRequest dtoRequest) {
		DtoPublicResponsePager<DtoDeptFindByIdResponse> dtoResponse = new DtoPublicResponsePager<>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			SysDeptWithBLOBs sd = new SysDeptWithBLOBs();
			sd.setAreaId(dtoRequest.getAreaId());
			List<SysDeptWithBLOBs> sysDept = deptService.selectDeptList(page, sortby, sd);
			List<DtoDeptFindByIdResponse> data = FuncTool.copyPropertiesListExt(sysDept, DtoDeptFindByIdResponse.class);
			for(DtoDeptFindByIdResponse dept:data){
				SysArea area = areaService.selectByPrimaryKey(dept.getAreaId());
				DtoAreaForDeptFindByIdResponse areaResp = new DtoAreaForDeptFindByIdResponse();
				FuncTool.copyPropertiesExt(area, areaResp);
				dept.setArea(areaResp);
			}
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(data);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("查询有审核无犯罪记录证明的派出所列表;负责人：hongli")
	@RequestMapping("findPoliceStations")
	@ResponseBody
	public DtoPublicResponsePager<DtoFindPoliceStationsResponse> findPoliceStations(@Valid DtoFindPoliceStationsRequest dtoRequest) {
		DtoPublicResponsePager<DtoFindPoliceStationsResponse> dtoResponse = new DtoPublicResponsePager<>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" dept_id asc ":dtoRequest.getSortby();
			List<JwBusinessDept> businessDepts = businessDeptService.selectBusinessDeptList(page, sortby, dtoRequest.getKeyword(), dtoRequest.getType());
			List<String> deptIds = new ArrayList();
			for(JwBusinessDept businessDept:businessDepts){
				deptIds.add(businessDept.getDeptId());
			}
			List<SysDeptWithBLOBs> depts = deptService.queryDeptByIds(deptIds);
			List<DtoFindPoliceStationsResponse> data = FuncTool.copyPropertiesListExt(depts, DtoFindPoliceStationsResponse.class);
			dtoResponse.setData(data);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("当前用户同级及下级所有单位类型为公安的单位 ;负责人：hongli")
	@RequestMapping("findPoliceOffice")
	@ResponseBody
	public DtoPublicResponsePager<DtoDeptFindByIdResponse> findPoliceOffice(@Valid DtoFindPoliceOfficeRequest dtoRequest) {
		DtoPublicResponsePager<DtoDeptFindByIdResponse> dtoResponse = new DtoPublicResponsePager<>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			List<SysDeptWithBLOBs> sysDept = deptService.getPoliceOffice(page, sortby, dtoRequest.getUid(), dtoRequest.getType());
			List<DtoDeptFindByIdResponse> data = FuncTool.copyPropertiesListExt(sysDept, DtoDeptFindByIdResponse.class);
			for(DtoDeptFindByIdResponse dept:data){
				SysArea area = areaService.selectByPrimaryKey(dept.getAreaId());
				DtoAreaForDeptFindByIdResponse areaResp = new DtoAreaForDeptFindByIdResponse();
				FuncTool.copyPropertiesExt(area, areaResp);
				dept.setArea(areaResp);
			}
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(data);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@SuppressWarnings("unchecked")
	@ApiDescription("查询分局及其下属派出所 ;负责人：hongli")
	@RequestMapping("findPublicSecurityBureau")
	@ResponseBody
	public DtoPublicResponseList<DtoDeptFindPoliceStationResponse> findPublicSecurityBureau(@Valid DtoPublicRequest dtoRequest) throws Exception{
		DtoPublicResponseList<DtoDeptFindPoliceStationResponse> dtoResponse = new DtoPublicResponseList<>();
		List<SysDeptWithBLOBs> sysDept = deptService.getPublicSecurityBureau();
		List<DtoDeptFindPoliceStationResponse> data = FuncTool.copyPropertiesListExt(sysDept, DtoDeptFindPoliceStationResponse.class);
		for (DtoDeptFindPoliceStationResponse deptResp:data) {
			List<SysDeptWithBLOBs> depts = deptService.getAllPoliceSubStation(deptResp.getId());
			List<DtoDeptFindPoliceStationResponse> subDepts = FuncTool.copyPropertiesListExt(depts, DtoDeptFindPoliceStationResponse.class);
			deptResp.setSubDepts(subDepts);
		}
		dtoResponse.setData(data);
		dtoResponse.setCode(Constants.API_CODE_SUCCESS);
		dtoResponse.setMsg("操作成功");
		return dtoResponse;
	}
	
	@SuppressWarnings("unchecked")
	@ApiDescription("查询派出所和警务室列表;负责人：hongli")
	@RequestMapping("findPoliceStationAndRoom")
	@ResponseBody
	public DtoPublicResponseList<DtoDeptFindByIdResponse> findPoliceStationAndRoom(@Valid DtoPublicRequest dtoRequest) throws Exception{
		DtoPublicResponseList<DtoDeptFindByIdResponse> dtoResponse = new DtoPublicResponseList<>();
		List<SysDeptWithBLOBs> sysDeptList = deptService.getPoliceStationAndRoom();
		List<DtoDeptFindByIdResponse> data = FuncTool.copyPropertiesListExt(sysDeptList, DtoDeptFindByIdResponse.class);
		dtoResponse.setData(data);
		dtoResponse.setCode(Constants.API_CODE_SUCCESS);
		dtoResponse.setMsg("操作成功");
		return dtoResponse;
	}
	
	@SuppressWarnings("unchecked")
	@ApiDescription("查询派出所或警务室详情;负责人：hongli")
	@RequestMapping("findPoliceStationAndRoomDetail")
	@ResponseBody
	public DtoPublicResponseObj<DtoDeptFindPoliceDetailResponse> findPoliceStationAndRoomDetail(@Valid DtoDeptFindByIdRequest dtoRequest) throws Exception{
		DtoPublicResponseObj<DtoDeptFindPoliceDetailResponse> dtoResponse = new DtoPublicResponseObj<>();
		SysDeptWithBLOBs sysDept = deptService.getDeptById(dtoRequest.getId());
		if (sysDept == null) {
			throw SystemException.init("部门ID不正确"); 
		}
		DtoDeptFindPoliceDetailResponse deptResp = FuncTool.copyPropertiesClass(sysDept, DtoDeptFindPoliceDetailResponse.class);
		List<SysUser> userList = userService.getPoliceUserList(sysDept.getId());
		if (userList != null && !userList.isEmpty()) {
			List<DtoUserDeptDetailResponse> users = FuncTool.copyPropertiesListExt(userList, DtoUserDeptDetailResponse.class);
			deptResp.setUsers(users);
		}
		dtoResponse.setData(deptResp);
		dtoResponse.setCode(Constants.API_CODE_SUCCESS);
		dtoResponse.setMsg("操作成功");
		return dtoResponse;
	}
}
	
