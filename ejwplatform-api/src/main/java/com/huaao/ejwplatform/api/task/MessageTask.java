package com.huaao.ejwplatform.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.huaao.ejwplatform.service.MessageService;

/**
 * 
* @Title: MessageTask.java
* @Package com.huaao.ejwplatform.api.task
* @Description: 咨询服务批量评价Task
* @author hongli  
* @date 2017年5月12日 上午9:59:32
 */
@Controller
public class MessageTask {
	private static final Logger LOG = LoggerFactory.getLogger(MessageTask.class);

	@Autowired
	private MessageService messageService;
	
	@Scheduled(cron = "0 1 0 * * ?")    
	public void taskCycle(){
		try {
			LOG.info("MessageTask.taskCycle");
			messageService.appraiseStatusBatch();
		} catch (Exception e) {
			LOG.error("message batch appraise error.", e);
		}
	}
}
