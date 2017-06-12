package com.huaao.ejwplatform.api.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.huaao.ejwplatform.service.JwContentService;

/**
 * 
* @Title: JwContentTask.java
* @Package com.huaao.ejwplatform.api.task
* @Description: 每天凌晨更新置顶到期时间小于当前日期00:00:00的记录
* @date 2017年3月21日 下午4:17:54
 */
@Controller
public class JwContentTask {
	
	@Autowired
	private JwContentService jwContentService;

	@Scheduled(cron = "0 1 0 * * ?")    
	 public void taskCycle(){
		jwContentService.updateUpTopInfo();
	 }
}