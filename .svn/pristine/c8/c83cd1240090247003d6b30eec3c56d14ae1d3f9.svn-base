package com.huaao.ejwplatform.api.control.system;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.area.DtoAreaFindByIdRequest;
import com.huaao.ejwplatform.api.dto.area.DtoAreaFindByParentRequest;
import com.huaao.ejwplatform.api.dto.area.DtoAreaFindByParentResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.SysAreaExt;
import com.huaao.ejwplatform.service.system.AreaService;

@Controller
@RequestMapping("api/area")
public class AreaController {
	private static final Logger LOG = LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;
	

	@ApiDescription("获取区域列表接口;负责人：hongli;获取区域列表，如果没有parentId，获取根区域，否则根据parentid获取子列表")
	@RequestMapping("findByParent")
	@ResponseBody
	public DtoPublicResponsePager<DtoAreaFindByParentResponse> findByParent(@Valid DtoAreaFindByParentRequest dtoRequest) {
		DtoPublicResponsePager<DtoAreaFindByParentResponse> dtoResponse = new DtoPublicResponsePager<DtoAreaFindByParentResponse>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			List<SysAreaExt> sysAreas = areaService.selectAreaList(page, sortby, dtoRequest.getParentId());
			List<DtoAreaFindByParentResponse> datas = new ArrayList<DtoAreaFindByParentResponse>();
			copyProptiesList(sysAreas, datas);
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(datas);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setMsg("操作成功");
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("操作失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	/**
	 * 递归复制
	 * @param sysArea
	 * @param resp
	 */
	private void copyProperties(SysAreaExt sysArea, DtoAreaFindByParentResponse resp){
		FuncTool.copyPropertiesExt(sysArea, resp);
		if(sysArea.getParent() != null){
			DtoAreaFindByParentResponse respParent = new DtoAreaFindByParentResponse();
			resp.setParent(respParent);
			copyProperties(sysArea.getParent(), respParent);
		}
	}
	
	private List<DtoAreaFindByParentResponse> copyProptiesList(List<SysAreaExt> sysAreas, List<DtoAreaFindByParentResponse> resps) {
		for(SysAreaExt sysArea:sysAreas){
			DtoAreaFindByParentResponse resp = new DtoAreaFindByParentResponse();
			copyProperties(sysArea, resp);
			resps.add(resp);
		}
		return resps;
	}

	@ApiDescription("获取区域信息接口;负责人：hongli;根据ID获取区域信息")
	@RequestMapping("findById")
	@ResponseBody
	public DtoPublicResponseObj<DtoAreaFindByParentResponse> findById(@Valid DtoAreaFindByIdRequest dtoRequest) {
		DtoPublicResponseObj<DtoAreaFindByParentResponse> dtoResponse = new DtoPublicResponseObj<DtoAreaFindByParentResponse>();
		try{
			SysAreaExt sysAreas = areaService.selectByPrimaryKeyExt(dtoRequest.getId());
			DtoAreaFindByParentResponse data = new DtoAreaFindByParentResponse();
			copyProperties(sysAreas, data);
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
}
