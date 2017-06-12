package com.huaao.ejwplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.JwEntity;
import com.huaao.ejwplatform.dao.JwEntityExample;
import com.huaao.ejwplatform.dao.JwEntityExt;
import com.huaao.ejwplatform.mapper.JwEntityMapper;


@Service
public class EntityService {

	@Autowired
	private JwEntityMapper jwEntityMapper; 
	
	public List<JwEntityExt> list(JwEntity je, Page page, String orderby,List<String> deptIds) {
		JwEntityExample exa = new JwEntityExample();
		if(deptIds != null && deptIds.size() > 0){
			exa.createCriteria().andDeptIdIn(deptIds);
		}
		exa.setOrderByClause(orderby);
		return jwEntityMapper.selectByExampleExt(exa);
	}

	public JwEntityExt queryById(String id) {
		return jwEntityMapper.selectByPrimaryKeyExt(id);
	}

}
