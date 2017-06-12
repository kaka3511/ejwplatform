package com.huaao.ejwplatform.api.control.system;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.jobs.DtoDeptForJobsFindByDeptResponse;
import com.huaao.ejwplatform.api.dto.jobs.DtoJobsFindByDeptRequest;
import com.huaao.ejwplatform.api.dto.jobs.DtoJobsFindByDeptResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysJobs;
import com.huaao.ejwplatform.service.system.DeptService;
import com.huaao.ejwplatform.service.system.JobsService;

@ApiDescription("人员类型")
@Controller
@RequestMapping("api/jobs")
public class JobsController {
	private static final Logger LOG = LoggerFactory.getLogger(JobsController.class);

	@Autowired
	private JobsService jobsService;
	
	@Autowired
	private DeptService deptService;
	
	@ApiDescription("根据部门ID获取人员类型;负责人：hongli")
	@RequestMapping("findByDept")
	@ResponseBody
	public DtoPublicResponsePager<DtoJobsFindByDeptResponse> findByDept(@Valid DtoJobsFindByDeptRequest dtoRequest) {
		DtoPublicResponsePager<DtoJobsFindByDeptResponse> dtoResponse = new DtoPublicResponsePager<DtoJobsFindByDeptResponse>();
		try{
			Page page = ApiTool.convert(dtoRequest);
			String sortby = StringUtils.isBlank(dtoRequest.getSortby())?" name asc ":dtoRequest.getSortby();
			List<SysJobs> sysJobsList = jobsService.selectJobList(page, sortby ,dtoRequest.getDeptId());
			SysDeptWithBLOBs dept = deptService.getDeptById(dtoRequest.getDeptId());
			List<DtoJobsFindByDeptResponse> data = FuncTool.copyPropertiesListExt(sysJobsList, DtoJobsFindByDeptResponse.class);
			for(DtoJobsFindByDeptResponse d:data){
				DtoDeptForJobsFindByDeptResponse deptResp = new DtoDeptForJobsFindByDeptResponse();
				FuncTool.copyPropertiesExt(dept, deptResp);
				d.setDept(deptResp);
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
}
