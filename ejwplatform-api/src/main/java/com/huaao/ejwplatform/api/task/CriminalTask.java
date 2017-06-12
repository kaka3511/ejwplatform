package com.huaao.ejwplatform.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.huaao.ejwplatform.service.CriminalService;

/**
 * 
* @Title: CriminalTask.java
* @Package com.huaao.ejwplatform.api.task
* @Description: 无犯罪记录证明状态更新定时任务
* @author hongli  
* @date 2017年3月31日 下午2:25:31
 */
@Controller
public class CriminalTask {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CriminalService criminalService;
	
	@Scheduled(cron = "0 1 0 * * ?")    
	public void taskCycle(){
		try {
			log.info("CriminalTask.taskCycle");
			criminalService.updateCriminalAuthStatus();
		} catch (Exception e) {
			log.error("无犯罪记录证明状态更新定时任务执行出错" + e.getMessage(), e);
		}
	}
	
	@Scheduled(cron = "0 1 0 * * ?")    
	public void appraiseStatusBatch(){
		try {        
			log.info("CriminalTask.appraiseStatusBatch");
			criminalService.appraiseStatusBatch();
		} catch (Exception e) {
			log.error("无犯罪记录证明状态更新定时任务执行出错" + e.getMessage(), e);
		}
	}
}
