package com.huaao.ejwplatform.api.dto.bean;

import java.util.Date;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class MessageAppraiseInfo {

    @ApiDescription("消息ID")
    @ApiDemoData(DemoData.ID)
    private String msgId;

    @ApiDescription("创建人ID")
    @ApiDemoData(DemoData.ID)
    private String userId;

    @ApiDescription("创建人")
    @ApiDemoData(DemoData.NAME)
    private String userName;

    @ApiDescription("创建时间")
    @ApiDemoData(DemoData.STMAP)
    private Date createTime;

    @ApiDescription("处理速度")
    @ApiDemoData("5")
    private Integer turningSpeed;

    @ApiDescription("处理效率")
    @ApiDemoData("5")
    private Integer processingEfficiency;

    @ApiDescription("反馈结果")
    @ApiDemoData("5")
    private Integer feedbackResult;
    
    @ApiDescription("评价结果 好评、中评、差评")
    @ApiDemoData("好评")
    private String appraiseResult;
    
    
	public String getAppraiseResult() {
		return appraiseResult;
	}

	public void setAppraiseResult(String appraiseResult) {
		this.appraiseResult = appraiseResult;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
