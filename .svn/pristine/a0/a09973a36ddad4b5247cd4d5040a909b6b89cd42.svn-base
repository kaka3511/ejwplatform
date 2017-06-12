package com.huaao.ejwplatform.service.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDeptExample;
import com.huaao.ejwplatform.dao.SysDeptExample.Criteria;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.dao.SysUserExample;
import com.huaao.ejwplatform.mapper.SysDeptMapper;
import com.huaao.ejwplatform.mapper.SysUserMapper;

@Service
public class DeptService {

	@Autowired
	private SysDeptMapper sysDeptMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper; 
	
	public SysDeptWithBLOBs getDeptByUserId(String id){
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
 		return sysDeptMapper.selectByPrimaryKey(user.getDeptId());
	}
	
	public List<SysDeptWithBLOBs> getDeptSubDept(SysDeptWithBLOBs dept){
		SysDeptExample deptExample = new SysDeptExample();
		deptExample.createCriteria().andCodeLike(dept.getCode()+"%").andCodeNotEqualTo(dept.getCode()).andLevelEqualTo(dept.getLevel()+1);
		return sysDeptMapper.selectByExampleWithBLOBs(deptExample);
	}
	
	public List<SysDeptWithBLOBs> getAllDeptByDept(String deptId){
		SysDeptWithBLOBs SysDeptWithBLOBs = getDeptById(deptId);
		SysDeptExample deptExample = new SysDeptExample();
		deptExample.createCriteria().andCodeLike(SysDeptWithBLOBs.getCode()+"%");
		return sysDeptMapper.selectByExampleWithBLOBs(deptExample);
	}
	
	public SysDeptWithBLOBs getDeptById(String id){
		return sysDeptMapper.selectByPrimaryKey(id);
	}
	
	public SysDeptWithBLOBs getDeptByCode(String code) throws Exception{
		SysDeptExample deptExample = new SysDeptExample();
		deptExample.createCriteria().andCodeEqualTo(code);
		List<SysDeptWithBLOBs> list = sysDeptMapper.selectByExampleWithBLOBs(deptExample);
		if(list.size() == 0){
			throw SystemException.init("部门CODE数据错误");
		}
		return list.get(0);
	}
	
	public List<SysDeptWithBLOBs> queryDeptByIds(List<String> deptIds){
		if(deptIds == null || deptIds.size() == 0){
			return new ArrayList<>();
		}
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andIdIn(deptIds);
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 分页查询部门列表
	 * @param page
	 * @param sortby
	 * @param SysDeptWithBLOBs  
	 * @return
	 */
	public List<SysDeptWithBLOBs> selectDeptList(Page page, String sortby,SysDeptWithBLOBs dept){
		SysDeptExample exa = new SysDeptExample();
		Criteria criteria = exa.createCriteria();
		if(dept.getParentId() != null){
			criteria.andParentIdEqualTo(dept.getParentId());
		}
		if(dept.getAreaId() != null){
			criteria.andAreaIdEqualTo(dept.getAreaId());
		}
		if(!org.springframework.util.StringUtils.isEmpty(dept.getType())  ){
			criteria.andTypeIn(Arrays.asList(dept.getType().split(",")));
		}
		int total = sysDeptMapper.countByExample(exa);
		page.setTotalCount(total);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(sortby);
		return sysDeptMapper.selectByExampleWithBLOBs(exa);
	}
	
	/**
	 * 根据用户所在派出所，分页查询部门列表
	 * @param page
	 * @param sortby
	 * @param SysDeptWithBLOBs  
	 * @return
	 */
	public List<SysDeptWithBLOBs> findByUserPoliceStation(Page page, String sortby,SysDeptWithBLOBs dept){
		SysDeptExample exa = new SysDeptExample();
		exa.createCriteria().andCodeLike(dept.getCode()+"%")
			.andCodeNotEqualTo(dept.getCode())
			.andLevelEqualTo(6)
			.andTypeEqualTo(dept.getType());
		int total = sysDeptMapper.countByExample(exa);
		page.setTotalCount(total);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(sortby);
		return sysDeptMapper.selectByExampleWithBLOBs(exa);
	}
	
	/**
	 * 返回某个部门能够查看管理的人员ID列表
	 * @param uid
	 * @return
	 */
	public List<String> queryManageUserIds(String deptId){
		List<String> list = new ArrayList<>();
		String code = this.sysDeptMapper.selectByPrimaryKey(deptId).getCode();
		if(code == null){
			list.add("1");
			return list;
		}
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andCodeLike(code+"%");
		List<SysDeptWithBLOBs> listDept = sysDeptMapper.selectByExampleWithBLOBs(example);
		List<String> deptIds = new ArrayList<>();
		deptIds.add(deptId);
		for(SysDeptWithBLOBs item : listDept){
			deptIds.add(item.getId());
		}
		SysUserExample userExample = new SysUserExample();
		userExample.createCriteria().andDeptIdIn(deptIds);
		List<SysUser> listUser = this.sysUserMapper.selectByExample(userExample);
		for(SysUser item : listUser){
			list.add(item.getId());
		}
		return list;
	}
	
	/**
	 * 返回警务室能够查看管理的人员ID列表
	 * @param uid
	 * @return
	 */
	public List<String> queryManageUserIdsByPoliceSubStation(String deptId){
		List<String> list = new ArrayList<>();
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andLinkDeptIdEqualTo(deptId);
		List<SysDeptWithBLOBs> listDept = sysDeptMapper.selectByExampleWithBLOBs(example);
		List<String> deptIds = new ArrayList<>();
		deptIds.add(deptId);
		for(SysDeptWithBLOBs item : listDept){
			deptIds.add(item.getId());
		}
		SysUserExample userExample = new SysUserExample();
		userExample.createCriteria().andDeptIdIn(deptIds);
		List<SysUser> listUser = this.sysUserMapper.selectByExample(userExample);
		for(SysUser item : listUser){
			list.add(item.getId());
		}
		return list;
	}
	
	/**
	 * 返回某个部门能够查看管理的人员ID列表(根据部门ID，精确匹配)
	 * @param uid
	 * @return
	 */
	public List<String> queryManageUserIdsByDeptId(String deptId){
		List<String> list = new ArrayList<>();
		if(deptId == null){
			list.add("1");
			return list;
		}
		SysUserExample userExample = new SysUserExample();
		userExample.createCriteria().andDeptIdEqualTo(deptId);
		List<SysUser> listUser = this.sysUserMapper.selectByExample(userExample);
		for(SysUser item : listUser){
			list.add(item.getId());
		}
		return list;
	}
	
	/**
	 * 根据用户id获取所在派出所
	 * @param uid
	 * @return
	 */
	public SysDeptWithBLOBs getPolicyDeptByUserId(String uid){
		SysUser user = sysUserMapper.selectByPrimaryKey(uid);
		SysDeptWithBLOBs dept = sysDeptMapper.selectByPrimaryKey(user.getDeptId());
		if(dept==null) return null;
		String deptCode = dept.getCode();
		//当前认为派出所level=5
		if(StringUtils.isBlank(deptCode)||deptCode.length()<15) return null;
		SysDeptExample sde = new SysDeptExample();
		sde.createCriteria().andCodeEqualTo(deptCode.substring(0, 15));
		List<SysDeptWithBLOBs> list = sysDeptMapper.selectByExampleWithBLOBs(sde);
		if(CollectionUtils.isEmpty(list)) return null;
		return list.get(0);
	}
	
	public List<SysDeptWithBLOBs> getDelegateDept(SysDeptWithBLOBs dept){
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andCodeLike(dept.getCode()+"%").andTypeNotEqualTo("小区").andCodeNotEqualTo(dept.getCode());
		example.setOrderByClause(" CONVERT(name USING gbk ) ");
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}

	/**
	 * 查询警务室或者物业下的所有小区
	 * @param linkDeptId
	 * @return
	 */
	public List<SysDeptWithBLOBs> getDeptByLinkDeptId(String linkDeptId) {
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andLinkDeptIdEqualTo(linkDeptId);
		example.setOrderByClause(" name ");
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 登录服务人员同级及下级所有单位类型为公安的单位
	 * @param page
	 * @param sortby
	 * @param uid
	 * @param type 1 警务室   2派出所和警务室
	 * @return
	 */
	public List<SysDeptWithBLOBs> getPoliceOffice(Page page, String sortby, String uid, Integer type) {
		if(page == null){
			page = new Page(1,2000);
			
		}
		if(type == null){
			type = 1;
		}
		SysDeptWithBLOBs dept = getDeptByUserId(uid);
		String code = null;
		if(dept.getCode().length() < 15){
			code = dept.getCode();
		}else{
			code = dept.getCode().substring(0, 15);
		}
		SysDeptExample example = new SysDeptExample();
		SysDeptExample.Criteria criteria = example.createCriteria();
		criteria.andCodeLike(code+"%")
			.andTypeEqualTo("公安");
		if(type == 1){
			criteria.andLevelEqualTo(6);
		}else{
			if(dept.getLevel().intValue() == 6){
				criteria.andLevelEqualTo(6);
			}
		}
		int total = sysDeptMapper.countByExample(example);
		page.setTotalCount(total);
		example.setOffset(page.getOffset());
		example.setLimit(page.getPageSize());
		example.setOrderByClause(sortby);
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 获取当前系统中所有的派出所.
	 * @return
	 */
	public List<SysDeptWithBLOBs> getAllPoliceStation() {
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andTypeEqualTo("公安").andLevelEqualTo(5);
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 获取当前系统中所有的分局.
	 * @return
	 */
	public List<SysDeptWithBLOBs> getPublicSecurityBureau() {
		List<Integer> levels = new ArrayList<>();
		levels.add(4);//分局
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andTypeEqualTo("公安").andLevelIn(levels);
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 获取系统中所有的派出所.
	 * @return
	 */
	public List<SysDeptWithBLOBs> getAllPoliceSubStation(String parentId) {
		List<Integer> levels = new ArrayList<>();
		//派出所
		levels.add(5);
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andTypeEqualTo("公安").andLevelIn(levels).andParentIdEqualTo(parentId);
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 获取当前系统中所有的警务室和派出所.
	 * @return
	 */
	public List<SysDeptWithBLOBs> getPoliceStationAndRoom() {
		List<Integer> levels = new ArrayList<>();
		levels.add(5);//警务室
		levels.add(6);//派出所
		SysDeptExample example = new SysDeptExample();
		example.createCriteria().andTypeEqualTo("公安").andLevelIn(levels);
		return sysDeptMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 根据分局用户的id查询分局下的第一个派出所（按派出所名称排列）
	 * @param id 分局用户的id
	 * @return
	 */
	public SysDeptWithBLOBs getFirstPoliceStationByUserid(String id) {
		SysDeptWithBLOBs substation = getDeptByUserId(id);
		if (substation.getLevel() != 4) {
			return null;
		}
		SysDeptExample deptExample = new SysDeptExample();
		deptExample.createCriteria()
			.andParentIdEqualTo(substation.getId())
			.andTypeEqualTo("公安");
		deptExample.setOrderByClause("name");
		deptExample.setLimit(1);
		List<SysDeptWithBLOBs> depts = sysDeptMapper.selectByExampleWithBLOBs(deptExample);
		if (depts != null && !depts.isEmpty()) {
			return depts.get(0);
		}
		return null;
	}
}
