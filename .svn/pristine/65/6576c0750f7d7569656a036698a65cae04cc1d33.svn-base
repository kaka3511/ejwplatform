package com.huaao.ejwplatform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaao.ejwplatform.dao.JwLearnRecord;
import com.huaao.ejwplatform.dao.JwLearnRecordExample;
import com.huaao.ejwplatform.dao.JwLearnRecordExampleExt;
import com.huaao.ejwplatform.mapper.JwLearnRecordMapper;

@Service
public class JwLearnRecordService {
	private static final Logger LOG = LoggerFactory.getLogger(JwLearnRecordService.class);

	@Autowired
	private JwLearnRecordMapper jwLearnRecordMapper;

	@Transactional
	public void insert(JwLearnRecord record){
		JwLearnRecordExample example = new JwLearnRecordExample();
		example.createCriteria()
		.andContentIdEqualTo(record.getContentId())
		.andUidEqualTo(record.getUid());
		int num = jwLearnRecordMapper.countByExample(example);
		if(num == 0){
			jwLearnRecordMapper.insert(record);
		}else{
			LOG.debug("用户{}已阅读{},不再重复记录", record.getName(), record.getContentId());
		}
	}
	
	/**
	 * 查询是否已阅读
	 * @param deptIds
	 * @return
	 */
	public int selectReadByUidAndContentId(String uid, String contentId){
		JwLearnRecordExampleExt example = new JwLearnRecordExampleExt();
		example.createCriteria()
		.andContentIdEqualTo(contentId)
		.andUidEqualTo(uid);
		if(jwLearnRecordMapper.countByExample(example) > 0){
			return 1;
		}else{
			return 0;
		}
	}
}
