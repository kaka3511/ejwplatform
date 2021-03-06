package com.huaao.ejwplatform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.dao.JwAlert;
import com.huaao.ejwplatform.dao.JwCriminalRecord;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysMessageExampleExt;
import com.huaao.ejwplatform.service.system.DeptService;

@Service
public class ToDoService {
	@Autowired
	private AlertService alertService;

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private DeptService deptService;

	@Autowired
	private CriminalService criminalService;

	public Integer queryToDoListNum(String uid) throws Exception{
		Integer count = 0;
		try {
			// 警情
			Page p = new Page(1, 1000);
			JwAlert jwAlert = new JwAlert();
			jwAlert.setStatus(0);
			Integer alertSum = alertService.queryAlertListCount(jwAlert, p, null, uid, null);
			SysMessageExampleExt msg = new SysMessageExampleExt();
			SysDeptWithBLOBs dept = deptService.getDeptByUserId(uid);
			// 咨询服务
			msg.setStatus(2);
			msg.setType(1);
			msg.setIsRead(0);
			String deptCode = dept.getCode().length() > 15 ? dept.getCode().substring(0, 15) : dept.getCode();
			msg.setDeptCode(deptCode);
			Integer messagexxSum = messageService.countMessage(msg);
			// 所长信箱
			msg.setType(2);
			Integer messageSum = messageService.countMessage(msg);
			// 实名认证
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("deptCode", dept.getCode());
			Integer auditCount = userService.queryUserAuditCount(map);
			// 网上办事
			Page pages = new Page(1, 1000);
			Integer criminaNum = 0;
			List<JwCriminalRecord> listJcr = criminalService.selectCriminalList(pages, "create_time desc", null, null, "0", uid, null);
			if(listJcr != null){
				criminaNum = listJcr.size();
			}
			count = alertSum + messagexxSum + messageSum + auditCount + criminaNum;
		} catch (Exception e) {
			throw e;
		}
		return count;
	}
}
