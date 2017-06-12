package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.JwFunctionalDept;
import com.huaao.ejwplatform.dao.JwFunctionalDeptExample;
import com.huaao.ejwplatform.dao.JwFunctionalDeptExample.Criteria;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDeptExample;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.dao.SysUserExample;
import com.huaao.ejwplatform.mapper.JwFunctionalDeptMapper;
import com.huaao.ejwplatform.mapper.SysDeptMapper;
import com.huaao.ejwplatform.mapper.SysUserMapper;

@Service
public class FunctionalDeptService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwFunctionalDeptMapper jwFunctionalDeptMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysDeptMapper sysDeptMapper;
	@Autowired
	private UserService userService;
	

	public void createFunctionalDept(String uid,JwFunctionalDept jwFunctionalDept)  throws Exception{
		if(checkExistedName(uid, jwFunctionalDept, null))		
				throw SystemException.init("职能部门名称不能重复！");
		String id = FuncTool.createUUID();
		jwFunctionalDept.setId(id);
		jwFunctionalDept.setCreateTime(new Date());
		jwFunctionalDept.setCreateId(uid);
		FuncTool.fillUpdater(jwFunctionalDept, uid);
		jwFunctionalDeptMapper.insertSelective(jwFunctionalDept);
	}
	//不加权限，查询所有
	public List<JwFunctionalDept> queryFunctionalDeptListAll(Page p)  throws Exception{
		List<JwFunctionalDept> listJwFunctionalDept = new ArrayList<JwFunctionalDept>();
		JwFunctionalDeptExample jwFunctionalDeptExample = new JwFunctionalDeptExample();		
		jwFunctionalDeptExample.createCriteria();
		jwFunctionalDeptExample.setOrderByClause(" CONVERT(name USING gbk )");
		int total = jwFunctionalDeptMapper.countByExample(jwFunctionalDeptExample);
		p.setTotalCount(total);
		jwFunctionalDeptExample.setOffset(p.getOffset());
		jwFunctionalDeptExample.setLimit(p.getPageSize());
				
		listJwFunctionalDept = jwFunctionalDeptMapper.selectByExample(jwFunctionalDeptExample);
		return listJwFunctionalDept;
	}
	
	public List<JwFunctionalDept> queryFunctionalDeptListWithAuthority(String uid,String id,String keyword,Page p)  throws Exception{
		List<String> createIds = new ArrayList<String>();		
		SysUserExample sysUserExample = new SysUserExample();
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(uid);
		String deptId = sysUser.getDeptId();
		SysDeptWithBLOBs sysDept = sysDeptMapper.selectByPrimaryKey(deptId);
		Integer level = sysDept.getLevel();
		//暂时只考虑到派出所和居民级别查询   
		//level只可能4、5、6 
		if(level.equals(6)){
			deptId = sysDept.getParentId();
		}
		sysUserExample.createCriteria().andDeptIdEqualTo(deptId);
		List<SysUser> listSysUsers = sysUserMapper.selectByExample(sysUserExample);
		for(SysUser item:listSysUsers)
			createIds.add(item.getId());
		
		List<JwFunctionalDept> listJwFunctionalDept = new ArrayList<JwFunctionalDept>();
		JwFunctionalDeptExample jwFunctionalDeptExample = new JwFunctionalDeptExample();
		Criteria criteria1 = jwFunctionalDeptExample.createCriteria();
		Criteria criteria2 = jwFunctionalDeptExample.createCriteria();
		Criteria criteria3 = jwFunctionalDeptExample.createCriteria();
		criteria1.andCreateIdIn(createIds);
		criteria2.andCreateIdIn(createIds);
		criteria3.andCreateIdIn(createIds);
		if(!StringUtils.isEmpty(id)){
			criteria1.andIdEqualTo(id);
			criteria2.andIdEqualTo(id);
			criteria3.andIdEqualTo(id);
		}
		if(!StringUtils.isEmpty(keyword)){
			criteria1.andNameLike("%"+keyword+"%");
			criteria2.andPhoneLike("%"+keyword+"%");
			criteria3.andRemarkLike("%"+keyword+"%");
		}
		
		jwFunctionalDeptExample.or(criteria1);
		jwFunctionalDeptExample.or(criteria2);
		jwFunctionalDeptExample.or(criteria3);
		int total = jwFunctionalDeptMapper.countByExample(jwFunctionalDeptExample);
		p.setTotalCount(total);
		jwFunctionalDeptExample.setOrderByClause(" CONVERT(name USING gbk )");
		jwFunctionalDeptExample.setOffset(p.getOffset());
		jwFunctionalDeptExample.setLimit(p.getPageSize());
				
		listJwFunctionalDept = jwFunctionalDeptMapper.selectByExample(jwFunctionalDeptExample);
		return listJwFunctionalDept;
	}
	
	public void updateFunctionalDept(String uid,JwFunctionalDept jwFunctionalDept)  throws Exception{	
		if(checkExistedName(uid, jwFunctionalDept, jwFunctionalDeptMapper.selectByPrimaryKey(jwFunctionalDept.getId()).getName()))
			throw SystemException.init("职能部门名称不能重复！");
		JwFunctionalDeptExample jwFunctionalDeptExample = new JwFunctionalDeptExample();
		FuncTool.fillUpdater(jwFunctionalDept, uid);	
		Criteria criteria = jwFunctionalDeptExample.createCriteria();
		criteria.andIdEqualTo(jwFunctionalDept.getId());
		jwFunctionalDeptMapper.updateByExampleSelective(jwFunctionalDept, jwFunctionalDeptExample);
	}
	
	public void deleteFunctionalDept(String id)  throws Exception{		
		jwFunctionalDeptMapper.deleteByPrimaryKey(id);		
	}
	
	
	public boolean checkExistedName(String uid, JwFunctionalDept jwFunctionalDept, String oldName){
		String name = jwFunctionalDept.getName();
		//没改原先的名称，不用继续查询
		if(org.apache.commons.lang.StringUtils.equals(oldName, name))
			return false;
		JwFunctionalDeptExample example1 = new JwFunctionalDeptExample();
		example1.createCriteria().andNameEqualTo(name);
		//所有名称符合的JwFunctionalDept
		List<JwFunctionalDept> jwFunctionalDepts = jwFunctionalDeptMapper.selectByExample(example1);	
		if(jwFunctionalDepts.size() == 0)
			return false;
		List<String> userIds = new ArrayList<String>();
		for(JwFunctionalDept item:jwFunctionalDepts)
			userIds.add(item.getCreateId());		
		SysUserExample example2 = new SysUserExample();
		example2.createCriteria().andIdIn(userIds);
		//所有符合上述条件的SysUser
		List<SysUser> sysUsers = sysUserMapper.selectByExample(example2);	
		if(sysUsers.size() == 0)
			return false;
		List<String> deptIds = new ArrayList<String>();
		for(SysUser item:sysUsers)
			deptIds.add(item.getDeptId());
		SysDeptExample example3 = new SysDeptExample();
		example3.createCriteria().andIdIn(deptIds);
		//所有上述SysUser所在的SysDept
		List<SysDeptWithBLOBs> depts = sysDeptMapper.selectByExampleWithBLOBs(example3);
		if(depts.size() == 0)
			return false;
		
		for(SysDeptWithBLOBs item:depts){
			if(org.apache.commons.lang.StringUtils.equals(item.getId(), userService.queryUser(uid).getDeptId()))
				return true;
		}
		return false;
	}
	
	
	
	
}
