package com.huaao.ejwplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.JwBusinessDept;
import com.huaao.ejwplatform.dao.JwBusinessDeptExample;
import com.huaao.ejwplatform.dao.JwBusinessDeptExample.Criteria;
import com.huaao.ejwplatform.mapper.JwBusinessDeptMapper;

@Service
public class BusinessDeptService {

	@Autowired
	private JwBusinessDeptMapper jwBusinessDeptMapper;
	
	
	/**
	 * 查询办理申请业务的派出所列表
	 * @param page
	 * @param orderby
	 * @param keyword
	 * @param type
	 * @return
	 */
	public List<JwBusinessDept> selectBusinessDeptList(Page page, String orderby, String keyword, Integer type){
		JwBusinessDeptExample exa = new JwBusinessDeptExample();
		Criteria criteria = exa.createCriteria();
		criteria.andTypeEqualTo(type);
		int total = jwBusinessDeptMapper.countByExample(exa);
		page.setTotalCount(total);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(orderby);
		return jwBusinessDeptMapper.selectByExample(exa);
	}
	
	/**
	 * 查询办理业务的权限
	 * @param userId  
	 * @param type
	 * @return
	 */
	public boolean checkJurisdictionByUserIdAndType(String userId, Integer type){
		JwBusinessDeptExample exa = new JwBusinessDeptExample();
		Criteria criteria = exa.createCriteria();
		criteria.andTypeEqualTo(type);
		criteria.andUserIdEqualTo(userId);
		int count = jwBusinessDeptMapper.countByExample(exa);
		if(count > 0){
			return true;
		}else{
			return false;
		}
	}
}
