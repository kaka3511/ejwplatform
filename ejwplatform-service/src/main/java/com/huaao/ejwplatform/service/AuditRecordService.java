package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.dao.SysAuditRecordExample;
import com.huaao.ejwplatform.dao.SysAuditRecordWithBLOBs;
import com.huaao.ejwplatform.dao.SysJobsExample;
import com.huaao.ejwplatform.mapper.SysAuditRecordMapper;

@Service
public class AuditRecordService {

	@Autowired
	private SysAuditRecordMapper sysAuditRecordMapper;
	
	
	public List<SysAuditRecordWithBLOBs> queryByApplyIds(List<String> ids){
		if(ids == null || ids.size() == 0){
			return new ArrayList<>();
		}
		SysAuditRecordExample example = new SysAuditRecordExample();
		example.createCriteria().andApplyIdIn(ids);
		example.setOrderByClause(" audit_time desc");
		return sysAuditRecordMapper.selectByExampleWithBLOBs(example);
	}
}
