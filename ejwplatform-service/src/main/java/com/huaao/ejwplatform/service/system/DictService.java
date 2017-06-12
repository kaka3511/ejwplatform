package com.huaao.ejwplatform.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.SysDict;
import com.huaao.ejwplatform.dao.SysDictExample;
import com.huaao.ejwplatform.mapper.SysDictMapper;

@Service
public class DictService {

	@Autowired
	private SysDictMapper sysDictMapper;

	/**
	 * 分页查询区域列表
	 * @param page
	 * @param sortby
	 * @param deptType  parentid
	 * @return
	 */
	public List<SysDict> selectDistList(Page page, String sortby, String parentId) {
		SysDictExample example = new SysDictExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		int total = sysDictMapper.countByExample(example);
		page.setTotalCount(total);
		example.setOffset(page.getOffset());
		example.setLimit(page.getPageSize());
		example.setOrderByClause(sortby);
		return sysDictMapper.selectByExample(example);
	}

	public List<SysDict> findByParent(String parentId) {
		List<SysDict> list = sysDictMapper.findByParent(parentId);
		return list;
	}
	
	public SysDict findByCode(String code){
		SysDictExample example = new SysDictExample();
		example.createCriteria().andCodeEqualTo(code);
		List<SysDict> list = sysDictMapper.selectByExample(example);
		if(list.size() == 0){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	public List<SysDict>  findByParentCode(String parentCode) {
		SysDict sd = findByCode(parentCode);
		if(sd == null){
			return new ArrayList<>();
		}
		return findByParent(sd.getId());
	}
}
