package com.huaao.ejwplatform.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.SysJobs;
import com.huaao.ejwplatform.dao.SysJobsExample;
import com.huaao.ejwplatform.mapper.SysJobsMapper;

@Service
public class JobsService {

	@Autowired
	private SysJobsMapper sysJobsMapper;
	
	/**
	 * 根据部门ID获取人员类型
	 * @param deptId
	 * @return
	 */
	public List<SysJobs> selectJobList(Page page,String sortby, String deptId) {
		SysJobsExample example = new SysJobsExample();
		example.createCriteria().andDeptIdEqualTo(deptId);
		int total = sysJobsMapper.countByExample(example);
		page.setTotalCount(total);
		example.setOffset(page.getOffset());
		example.setLimit(page.getPageSize());
		example.setOrderByClause(sortby);
		return sysJobsMapper.selectByExample(example);
	}
	
	/**
	 * 根据job ID查询
	 * @param id
	 * @return
	 */
	public SysJobs selectJobById(String id){
		return sysJobsMapper.selectByPrimaryKey(id);
	}
}
