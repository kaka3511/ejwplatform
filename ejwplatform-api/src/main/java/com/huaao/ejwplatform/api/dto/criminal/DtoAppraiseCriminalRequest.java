package com.huaao.ejwplatform.api.dto.criminal;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("网上办事评价接口请求参数")
public class DtoAppraiseCriminalRequest extends DtoPublicRequest{
	@ApiDescription("犯罪记录ID")
	@NotBlank(message="犯罪记录ID不能为空")
	@ApiDemoData("03fc86e759c64b029563da4037989df7")
	private String criminalId;
	
	@ApiDescription("处理速度")
	@NotNull(message="处理速度不能为空")
	@ApiDemoData("5")
	private Integer turningSpeed;  
	
	@ApiDescription("处理效率")
	@NotNull(message="处理效率不能为空")
	@ApiDemoData("5")
	private Integer processingEfficiency;
	
	@ApiDescription("反馈结果")
	@NotNull(message="反馈结果不能为空")
	@ApiDemoData("5")
	private Integer feedbackResult;


	public String getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(String criminalId) {
		this.criminalId = criminalId;
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
