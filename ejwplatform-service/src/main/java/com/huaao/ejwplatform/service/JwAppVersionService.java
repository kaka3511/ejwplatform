package com.huaao.ejwplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.dao.JwAppVersion;
import com.huaao.ejwplatform.dao.JwAppVersionExample;
import com.huaao.ejwplatform.mapper.JwAppVersionMapper;

@Service
public class JwAppVersionService {

	@Autowired
	private JwAppVersionMapper jwAppVersionMapper;
	
	
	public JwAppVersion queryLatestVersoin(){
		JwAppVersionExample exam = new JwAppVersionExample();
		exam.setOrderByClause("time desc");
		exam.setLimit(1);
		return  jwAppVersionMapper.queryLatestVersoin(exam);
	}
}
