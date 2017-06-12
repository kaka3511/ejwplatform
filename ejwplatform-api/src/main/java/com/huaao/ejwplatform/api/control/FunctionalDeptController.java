package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.FunctionalDeptInfo;
import com.huaao.ejwplatform.api.dto.bean.UserItem;
import com.huaao.ejwplatform.api.dto.functionaldept.DtoFunctionalDeptCreateRequest;
import com.huaao.ejwplatform.api.dto.functionaldept.DtoFunctionalDeptDeleteRequest;
import com.huaao.ejwplatform.api.dto.functionaldept.DtoFunctionalDeptQueryRequest;
import com.huaao.ejwplatform.api.dto.functionaldept.DtoFunctionalDeptUpdateRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwFunctionalDept;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.service.FunctionalDeptService;
import com.huaao.ejwplatform.service.UserService;

@ApiDescription("职能部门")
@Controller
@RequestMapping("api/functionaldept")
public class FunctionalDeptController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FunctionalDeptService functionalDeptService;
	@Autowired
	private UserService userService;
	
	@ApiDescription("职能部门新增;负责人：fuwei")
	@RequestMapping("create")
	@ResponseBody
	public DtoPublicResponse create(@Valid DtoFunctionalDeptCreateRequest dtoRequest) throws Exception{
		JwFunctionalDept jwFunctionalDept = FuncTool.copyPropertiesClass(dtoRequest, JwFunctionalDept.class);
		functionalDeptService.createFunctionalDept(dtoRequest.getUid(), jwFunctionalDept);
		return DtoPublicResponse.init();
	}
	
	@ApiDescription("职能部门查询;负责人：fuwei")
	@RequestMapping("query")
	@ResponseBody
	public DtoPublicResponsePager<FunctionalDeptInfo> query(@Valid DtoFunctionalDeptQueryRequest dtoRequest) throws Exception{
		DtoPublicResponsePager<FunctionalDeptInfo> dtoResponse = new DtoPublicResponsePager<FunctionalDeptInfo>();
		Page p = ApiTool.convert(dtoRequest);	
		List<JwFunctionalDept> listFunctionalDept = 
				functionalDeptService.queryFunctionalDeptListWithAuthority(dtoRequest.getUid(), dtoRequest.getId(), dtoRequest.getKeyword(), p);
		List<FunctionalDeptInfo> functionalDeptInfos = FuncTool.copyPropertiesList(listFunctionalDept, FunctionalDeptInfo.class);
		Map<String,SysUser> userIds = new HashMap<String,SysUser>();
		Map<String,JwFunctionalDept> funcDepts = new HashMap<String,JwFunctionalDept>();
		for(JwFunctionalDept item : listFunctionalDept){
			userIds.put(item.getCreateId(), null);
			userIds.put(item.getUpdaterId(), null);
			funcDepts.put(item.getId(), item);
		}
		List<SysUser> listUser = new ArrayList<SysUser>();
		if(userIds.size() > 0){
			listUser = userService.queryUserList(userIds.keySet().toArray(new String[userIds.size()]));		
		}
		for(SysUser item : listUser){
			userIds.put(item.getId(), item);
		}
		for(FunctionalDeptInfo item : functionalDeptInfos){
			JwFunctionalDept fdept = funcDepts.get(item.getId());
			item.setCreator(FuncTool.copyPropertiesClass(userIds.get(fdept.getCreateId()), UserItem.class));
			item.setUpdater(FuncTool.copyPropertiesClass(userIds.get(fdept.getUpdaterId()), UserItem.class));
		}
		ApiTool.fillPagerData(p, dtoResponse);
		dtoResponse.setData(functionalDeptInfos);
		return dtoResponse;
	}
	
	@ApiDescription("职能部门修改;负责人：fuwei")
	@RequestMapping("update")
	@ResponseBody
	public DtoPublicResponse update(@Valid DtoFunctionalDeptUpdateRequest dtoRequest) throws Exception{
		JwFunctionalDept jwFunctionalDept = new JwFunctionalDept();
		jwFunctionalDept = FuncTool.copyPropertiesClass(dtoRequest, JwFunctionalDept.class);		
		functionalDeptService.updateFunctionalDept(dtoRequest.getUid(),jwFunctionalDept);
		return DtoPublicResponse.init();
	}
	
	@ApiDescription("职能部门删除;负责人：fuwei")
	@RequestMapping("delete")
	@ResponseBody
	public DtoPublicResponse delete(@Valid DtoFunctionalDeptDeleteRequest dtoRequest) throws Exception{
		functionalDeptService.deleteFunctionalDept(dtoRequest.getId());
		return DtoPublicResponse.init();
	}
	
	
}
