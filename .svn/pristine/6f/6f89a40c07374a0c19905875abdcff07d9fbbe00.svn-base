package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.dto.subject.DtoCreateSysSubjectRequest;
import com.huaao.ejwplatform.api.dto.subject.DtoDeleteSysSubjectRequest;
import com.huaao.ejwplatform.api.dto.subject.DtoQuerySysSubjectResponse;
import com.huaao.ejwplatform.api.dto.subject.DtoQuerySysSubjectsRequest;
import com.huaao.ejwplatform.api.dto.subject.DtoUpdateSysSubjectRequest;
import com.huaao.ejwplatform.api.model.ContentInfoTypeEnum;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.SysSubject;
import com.huaao.ejwplatform.service.JwContentService;
import com.huaao.ejwplatform.service.SysSubjectService;

@ApiDescription("办事指南类别")
@Controller
@RequestMapping("api/sysSubject")
public class SysSubjectController{

	private static final Logger LOG = LoggerFactory.getLogger(SysSubjectController.class);

	@Autowired
	private SysSubjectService sysSubjectService;
	
	@Autowired
	private JwContentService jwContentService;
	
	@ApiDescription("办事指南栏目类别列表;负责人：hongli")
	@RequestMapping("querySysSubjectList")
	@ResponseBody
	public DtoPublicResponsePager<DtoQuerySysSubjectResponse> querySysSubjectList(@Valid DtoQuerySysSubjectsRequest dtoRequest) {
		DtoPublicResponsePager<DtoQuerySysSubjectResponse> dtoResponse = new DtoPublicResponsePager<DtoQuerySysSubjectResponse>();
		try {
			Page page = ApiTool.convert(dtoRequest);
			 String orderby = StringUtils.isBlank(dtoRequest.getSortby())?" create_time desc":dtoRequest.getSortby();
			 List<SysSubject> subjects = sysSubjectService.list(page, orderby, dtoRequest.getUid());
			 List<DtoQuerySysSubjectResponse> DtoQuerySysSubjectResponseList = new ArrayList<DtoQuerySysSubjectResponse>();
			 for(SysSubject sysSubject:subjects){
				 DtoQuerySysSubjectResponse dtoQuerySysSubjectResponse = new DtoQuerySysSubjectResponse();
				 BeanUtils.copyProperties(sysSubject, dtoQuerySysSubjectResponse);
				 Integer publishedCount = jwContentService.list(sysSubject.getId(), page, null, null, 3,  ContentInfoTypeEnum.BAN_SHI_ZHI_NAN.getCode().toString(), dtoRequest.getUid()).size();
				 Integer unPublishedCount = jwContentService.list(sysSubject.getId(), page, null, null, 6,  ContentInfoTypeEnum.BAN_SHI_ZHI_NAN.getCode().toString(), dtoRequest.getUid()).size();	 
				 dtoQuerySysSubjectResponse.setPublishedCount(publishedCount);
				 dtoQuerySysSubjectResponse.setUnPublishedCount(unPublishedCount);
				 DtoQuerySysSubjectResponseList.add(dtoQuerySysSubjectResponse);
			 }
			 dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			 dtoResponse.setData(DtoQuerySysSubjectResponseList);
			 ApiTool.fillPagerData(page, dtoResponse); 
		} catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("查询失败");
			LOG.error(dtoResponse.getMsg()+" "+e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("新增办事指南类别;负责人：hongli")
	@RequestMapping("addSysSubject")
	@ResponseBody
	public DtoPublicResponse addSysSubject(@Valid DtoCreateSysSubjectRequest dtoCreateSysSubjectRequest) {
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			SysSubject sysSubject = new SysSubject();
			BeanUtils.copyProperties(dtoCreateSysSubjectRequest, sysSubject);
			sysSubject.setCreatorId(dtoCreateSysSubjectRequest.getUid());
			if(sysSubjectService.countBySubjectName(sysSubject) >0){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg(Constants.API_MSG_SUBJECT_ALREADY_EXISTS);
				return dtoResponse;
			}
			sysSubjectService.add(sysSubject);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("新增办事指南类别失败");
			LOG.error(dtoResponse.getMsg()+" "+e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("更新办事指南类别;负责人：hongli")
	@RequestMapping("updateSysSubject")
	@ResponseBody
	public DtoPublicResponse updateSysSubject(@Valid DtoUpdateSysSubjectRequest dtoUpdateSysSubjectRequest) {
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			if(StringUtils.isBlank(dtoUpdateSysSubjectRequest.getId())){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg(Constants.formErrorMsg);
				return dtoResponse;
			}
			SysSubject sysSubject = new SysSubject();
			sysSubject.setCreatorId(dtoUpdateSysSubjectRequest.getUid());
			BeanUtils.copyProperties(dtoUpdateSysSubjectRequest, sysSubject);
			if(sysSubjectService.countBySubjectName(sysSubject) >0){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg(Constants.API_MSG_SUBJECT_ALREADY_EXISTS);
				return dtoResponse;
			}
			sysSubjectService.update(sysSubject);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("更新办事指南类别失败");
			LOG.error(dtoResponse.getMsg()+" "+e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("删除办事指南类别;负责人：hongli")
	@RequestMapping("deleteSysSubject")
	@ResponseBody
	public DtoPublicResponse deleteSysSubject(@Valid DtoDeleteSysSubjectRequest dtoDeleteSysSubjectRequest) {
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			if(StringUtils.isBlank(dtoDeleteSysSubjectRequest.getId())){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg(Constants.formErrorMsg);
				return dtoResponse;
			}
			int contentNum = jwContentService.countContentBySubjectId(dtoDeleteSysSubjectRequest.getId());
			if(contentNum >0){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg(Constants.API_MSG_SUBJECT_HAS_CONTENT);
				return dtoResponse;
			}else{
				sysSubjectService.delete(dtoDeleteSysSubjectRequest.getId());
			}
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("删除办事指南类别失败");
			LOG.error(dtoResponse.getMsg()+" "+e.getMessage(), e);
		}
		return dtoResponse;
	}
}
