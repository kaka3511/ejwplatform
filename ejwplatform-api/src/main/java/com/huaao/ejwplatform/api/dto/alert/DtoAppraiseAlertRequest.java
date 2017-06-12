package com.huaao.ejwplatform.api.dto.alert;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("警情评价接口请求参数")
public class DtoAppraiseAlertRequest extends DtoPublicRequest{
	@ApiDescription("警情ID")
	@NotBlank(message="警情ID不能为空")
	@ApiDemoData("03fc86e759c64b029563da4037989df7")
	private String alertId;
	
	@ApiDescription("接警速度")
	@NotNull(message="接警速度不能为空")
	@ApiDemoData("5")
	@Range(min=1, max=5)
	private Integer turningSpeed;  
	
	@ApiDescription("处理效率")
	@NotNull(message="处理效率不能为空")
	@ApiDemoData("5")
	@Range(min=1, max=5)
	private Integer processingEfficiency;
	
	@ApiDescription("反馈结果")
	@NotNull(message="反馈结果不能为空")
	@ApiDemoData("5")
	@Range(min=1, max=5)
	private Integer feedbackResult;

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public Integer getTurningSpeed() {
		return turningSpeed;
	}

	public void setTurningSpeed(Integer turningSpeed) {
		this.turningSpeed = turningSpeed;
	}

	public Integer getProcessingEfficiency() {
		return processingEfficiency;
	}

	public void setProcessingEfficiency(Integer processingEfficiency) {
		this.processingEfficiency = processingEfficiency;
	}

	public Integer getFeedbackResult() {
		return feedbackResult;
	}

	public void setFeedbackResult(Integer feedbackResult) {
		this.feedbackResult = feedbackResult;
	}
}
