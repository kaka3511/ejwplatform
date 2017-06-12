package com.huaao.ejwplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.JwMonitor;
import com.huaao.ejwplatform.dao.JwMonitorDevice;
import com.huaao.ejwplatform.dao.JwMonitorExample;
import com.huaao.ejwplatform.dao.JwMonitorGroup;
import com.huaao.ejwplatform.dao.JwMonitorGroupExample;
import com.huaao.ejwplatform.mapper.JwMonitorDeviceMapper;
import com.huaao.ejwplatform.mapper.JwMonitorGroupMapper;
import com.huaao.ejwplatform.mapper.JwMonitorMapper;

@Service
public class CommunityService {

	@Autowired
	private JwMonitorMapper jwMonitorMapper;
	
	@Autowired
	private JwMonitorGroupMapper jwMonitorGroupMapper;
	
	@Autowired
	private JwMonitorDeviceMapper jwMonitorDeviceMapper;
	
	
 	public List<JwMonitor> queryMonitorByDeptId(Page p , String deptId) throws Exception{
 		JwMonitorExample example = new JwMonitorExample();
 		example.createCriteria().andDeptIdEqualTo(deptId);
 		example.setOrderByClause(" update_time desc ");
 		return jwMonitorMapper.selectByExample(example);
 	}
 	
 	public List<JwMonitorGroup> queryMonitorGroupByDeptId(Page p , String deptId) throws Exception{
 		JwMonitorGroupExample example = new JwMonitorGroupExample();
 		example.createCriteria().andDeptIdEqualTo(deptId);
 		example.setOrderByClause(" update_time desc ");
 		return jwMonitorGroupMapper.selectByExample(example);
 	}
	
 	
 	public JwMonitorDevice queryMonitorDeviceById(String deviceId){
 		return jwMonitorDeviceMapper.selectByPrimaryKey(deviceId);
 	}
}
