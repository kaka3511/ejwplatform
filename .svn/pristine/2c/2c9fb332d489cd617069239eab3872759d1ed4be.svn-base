package com.huaao.ejwplatform.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.huaao.ejwplatform.service.AlertService;

/**
 * 
* @Title: AlertTask.java
* @Package com.huaao.ejwplatform.api.task
* @Description: 警情批量评价Task
* @author hongli  
* @date 2017年4月21日 上午9:50:57
 */
@Controller
public class AlertTask {
	private static final Logger LOG = LoggerFactory.getLogger(AlertTask.class);

	@Autowired
	private AlertService alertService;
	
	@Scheduled(cron = "0 1 0 * * ?")    
	public void taskCycle(){
		try {
			LOG.info("AlertTask.taskCycle");
			alertService.appraiseStatusBatch();
		} catch (Exception e) {
			LOG.error("alert batch appraise error.", e);
		}
	}
}
