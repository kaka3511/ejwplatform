package com.huaao.ejwplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.JwNotice;
import com.huaao.ejwplatform.dao.JwNoticeExample;
import com.huaao.ejwplatform.mapper.JwNoticeMapper;

@Service
public class NoticeService {

	@Autowired
	private JwNoticeMapper mapper;
	
	public List<JwNotice> queryNotice(Page p,String uid){
		JwNoticeExample example = new JwNoticeExample();
		example.createCriteria().andUserIdEqualTo(uid);
		example.setOffset(p.getOffset());
		example.setLimit(p.getPageSize());
		example.setOrderByClause("create_time desc");
		return mapper.selectByExample(example);
	}
}
