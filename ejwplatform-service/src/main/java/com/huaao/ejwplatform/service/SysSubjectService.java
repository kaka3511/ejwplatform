package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.SysDept;
import com.huaao.ejwplatform.dao.SysSubject;
import com.huaao.ejwplatform.dao.SysSubjectExample;
import com.huaao.ejwplatform.dao.SysSubjectExample.Criteria;
import com.huaao.ejwplatform.mapper.SysSubjectMapper;
import com.huaao.ejwplatform.service.system.DeptService;


@ApiDescription("栏目分类")
@Service
@Transactional
public class SysSubjectService {
	
	@Autowired
	private SysSubjectMapper sysSubjectMapper;
	
	@Autowired
	private DeptService deptService;

	public List<SysSubject> list(Page page, String orderby, String uid) {
		SysDept sysDept = deptService.getPolicyDeptByUserId(uid);
		SysSubjectExample exa = new SysSubjectExample(); 
		exa.createCriteria().andDeptIdEqualTo(sysDept.getId())
			.andNameNotEqualTo("办事指南");
		int total = sysSubjectMapper.countByExample(exa);
		page.setTotalCount(total);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(orderby);
		List<SysSubject> results = sysSubjectMapper.selectByExample(exa);
		return results;
	}

	@Transactional
	public void add(SysSubject sysSubject) {
		sysSubject.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		Date dd = new Date();
		sysSubject.setCreateTime(dd);
		if("".equals(sysSubject.getDeptId())){
			sysSubject.setDeptId(null);
		}
		if("".equals(sysSubject.getParentId())){
			sysSubject.setParentId(null);
		}
		if(sysSubject.getIsComment() == null){
			sysSubject.setIsComment(0);
		}
		if(sysSubject.getIsAudit() == null){
			sysSubject.setIsAudit(0);
		}
		if(sysSubject.getIsUseable() == null){
			sysSubject.setIsUseable(0);
		}
		if(sysSubject.getRange() == null){
			sysSubject.setRange((byte)1);
		}
		SysDept sysDept = deptService.getPolicyDeptByUserId(sysSubject.getCreatorId());
		sysSubject.setDeptId(sysDept.getId());
		//level 2
		sysSubject.setIsLeaf(1);
		sysSubject.setLevel(2);
		//查询名称为办事指南的记录，倒序排列取取第一条，设定新增的类别的dept_id和parent_id
		SysSubjectExample example = new SysSubjectExample();
		example.createCriteria().andNameEqualTo("办事指南")
			.andDeptIdEqualTo(sysDept.getId());
		example.setOrderByClause(" update_time desc , create_time desc ");
		example.setLimit(1);
		List<SysSubject> sysSubjects = sysSubjectMapper.selectByExample(example);
		if(sysSubjects != null && sysSubjects.size() > 0){
			SysSubject ss = sysSubjects.get(0);
			sysSubject.setParentId(ss.getId());
		}else{
			//新增“办事指南”类别
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			SysSubject ss = new SysSubject();
			ss.setId(id);
			ss.setName("办事指南");
			ss.setSort(0);
			ss.setCreateTime(dd);
			ss.setIsLeaf(0);
			ss.setLevel(1);
			ss.setCreatorId(sysSubject.getCreatorId());
			ss.setUpdaterId(sysSubject.getCreatorId());
			ss.setDeptId(sysDept.getId());
			ss.setIsComment(1);
			ss.setIsAudit(0);
			ss.setIsUseable(1);
			ss.setUpdateTime(dd);
			ss.setRange((byte)1);
			sysSubjectMapper.insert(ss);
			sysSubject.setParentId(id);
		}
		sysSubjectMapper.insert(sysSubject);
	}
	
	@Transactional
	public void update(SysSubject sysSubject) {
		if(!StringUtils.isBlank(sysSubject.getId())){
			SysSubject ss = sysSubjectMapper.selectByPrimaryKey(sysSubject.getId());
			if(ss != null){
				Date dd = new Date();
				if("".equals(sysSubject.getDeptId())){
					sysSubject.setDeptId(null);
				}
				if("".equals(sysSubject.getParentId())){
					sysSubject.setParentId(null);
				}
				sysSubject.setUpdateTime(dd);
				SysDept sysDept = deptService.getDeptByUserId(sysSubject.getCreatorId());
				sysSubject.setDeptId(sysDept.getId());
				sysSubjectMapper.updateByPrimaryKeySelective(sysSubject);
			}
		}
	}
	
	public int countBySubjectName(SysSubject sysSubject){
		SysSubjectExample exa = new SysSubjectExample(); 
		Criteria criteria = exa.createCriteria();
		if(sysSubject.getName() != null){
			criteria.andNameEqualTo(sysSubject.getName());
		}
		if(sysSubject.getId() != null){
			criteria.andIdNotEqualTo(sysSubject.getId());
		}
		//用户所属派出所
		SysDept dept = deptService.getPolicyDeptByUserId(sysSubject.getCreatorId());
		criteria.andDeptIdEqualTo(dept.getId());
		List<SysSubject> sysSubjects = sysSubjectMapper.selectByExample(exa);
		return sysSubjects == null ? 0 :sysSubjects.size();
	}

	@Transactional
	public void delete(String id) {
		sysSubjectMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据部门查询办事指南下的事项.
	 * @param deptId
	 * @return
	 */
	public List<String> getSubjectIdsByDeptId(String deptId){
		SysSubjectExample example = new SysSubjectExample();
		example.createCriteria().andDeptIdEqualTo(deptId).andNameNotEqualTo("办事指南");
		List<SysSubject> subjects = sysSubjectMapper.selectByExample(example);
		List<String> subjectIds = new ArrayList<String>();
		for(SysSubject subject:subjects){
			subjectIds.add(subject.getId());
		}
		return subjectIds;
	}
}
