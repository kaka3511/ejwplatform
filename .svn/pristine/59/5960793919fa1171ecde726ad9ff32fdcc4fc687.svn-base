package com.huaao.ejwplatform.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.SysArea;
import com.huaao.ejwplatform.dao.SysAreaExample;
import com.huaao.ejwplatform.dao.SysAreaExt;
import com.huaao.ejwplatform.mapper.SysAreaMapper;

@Service
public class AreaService {

	@Autowired
	private SysAreaMapper areaMapper;
	
	public SysArea querySysAreaById(String areaId){
		return areaMapper.selectByPrimaryKey(areaId);
	}

	/**
	 * 获取区域列表，如果没有parentId，获取根区域，否则根据parentid获取子列表
	 * @param parentId
	 * @return
	 */
	public List<SysAreaExt> selectAreaList(Page page, String sortby, String parentId) {
		if(StringUtils.isEmpty(parentId)){
			SysAreaExample deptExample = new SysAreaExample();
			deptExample.createCriteria().andLevelEqualTo(1);
			int total = areaMapper.countByExample(deptExample);
			page.setTotalCount(total);
			deptExample.setOffset(page.getOffset());
			deptExample.setLimit(page.getPageSize());
			deptExample.setOrderByClause(sortby);
			return areaMapper.selectByExampleExt(deptExample);
		}else{
			SysAreaExample deptExample = new SysAreaExample();
			deptExample.createCriteria().andParentIdEqualTo(parentId);
			int total = areaMapper.countByExample(deptExample);
			page.setTotalCount(total);
			deptExample.setOffset(page.getOffset());
			deptExample.setLimit(page.getPageSize());
			deptExample.setOrderByClause(sortby);
			return areaMapper.selectByExampleExt(deptExample);
		}
	}
	
	/**
	 * 根据ID查询区域信息
	 * @param areaId
	 * @return
	 */
	public SysAreaExt selectByPrimaryKeyExt(String areaId){
		return areaMapper.selectByPrimaryKeyExt(areaId);
	}
	

	/**
	 * 根据ID查询区域信息
	 * @param areaId
	 * @return
	 */
	public SysArea selectByPrimaryKey(String areaId){
		return areaMapper.selectByPrimaryKey(areaId);
	}

	public String getStandardAreaName(String areaId) {
		// TODO Auto-generated method stub
		SysAreaExt area = selectByPrimaryKeyExt(areaId);
		if(area.getLevel() > 4){
			return getStandardAreaName(area.getParentId());
		}
		if(area.getLevel() > 2){
			return getStandardAreaName(area.getParentId()) + "|" +area.getName();
		}
		if(area.getLevel() == 2){
			return area.getName();
		}
		return "";
	}

	public String getPostCode(String areaId) {
		// TODO Auto-generated method stub
		SysArea area = selectByPrimaryKey(areaId);
		if(area.getLevel() > 4){
			return getPostCode(area.getParentId());
		}else{
			return area.getCode();
		}
	}
	
	public String getFullAreaName(String areaId) {
		SysArea area = areaMapper.selectByPrimaryKeyExt(areaId);
		if(area == null){
			return null;
		}
		if(area.getLevel() > 2){
			return getFullAreaName(area.getParentId())+area.getName();
		}else{
			return area.getName();
		}
	}
}
