package com.huaao.ejwplatform.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.dao.SysApplyRecord;
import com.huaao.ejwplatform.dao.SysApplyRecordExt;
import com.huaao.ejwplatform.mapper.SysApplyRecordMapper;

@Service
public class ApplyRecordService {

	@Autowired
	private SysApplyRecordMapper sysApplyRecordMapper;
	
	/**
	 * 新增申请记录
	 * @param type
	 * @param userId
	 * @param recordId
	 * @param status
	 * @param desc
	 * @param dt
	 */
	public void add(int type, String userId,String recordId,  int status, String desc, String remark, Date dt){
		SysApplyRecord record = new SysApplyRecord();
		record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		record.setCreateTime(dt);
		record.setRecordId(recordId);
		record.setStatus(status);
		record.setType(type);
		record.setUserId(userId);
		record.setDesc(desc);
		record.setRemark(remark);
		sysApplyRecordMapper.insert(record);
	}
	
	/**
	 * 查询处理记录
	 * @param recordId
	 * @return
	 */
	public List<SysApplyRecordExt> selectByRecordId(String recordId){
		return sysApplyRecordMapper.selectByRecordId(recordId);
	}
}
