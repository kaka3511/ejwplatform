package com.huaao.ejwplatform.api.dto.msg;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("咨询评价接口请求参数")
public class DtoAppraiseMsgRequest extends DtoPublicRequest{
	@ApiDescription("咨询ID")
	@NotBlank(message="咨询ID不能为空")
	@ApiDemoData("03fc86e759c64b029563da4037989df7")
	private String msgId;
	
	@ApiDescription("处理速度")
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

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
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
