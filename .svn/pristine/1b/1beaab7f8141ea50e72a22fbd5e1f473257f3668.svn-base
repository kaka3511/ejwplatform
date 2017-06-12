package com.huaao.ejwplatform.api.dto.bean;

import java.sql.Timestamp;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class JWNoticeInfo {

	@ApiDemoData(DemoData.ID)
	@ApiDescription("")
	private String id;
	
	@ApiDemoData("这是一个标题")
	@ApiDescription("")
	private String title;

	@ApiDemoData("这是内容")
	@ApiDescription("")
	private String message;

	@ApiDemoData("1")
	@ApiDescription("type 会议通知（1）,警情(2),审核通知(3),自定义通知(4),咨询通知(5),APP端踢人通知（7）,用户信息修改（8）,视频呼叫和接通(10),视频拒绝和挂断（11）")
	private Integer type;

	@ApiDemoData(DemoData.ID)
	@ApiDescription("")
	private String msgId;

	@ApiDemoData(DemoData.TIME)
	@ApiDescription("")
	private String createTime;

	@ApiDemoData(DemoData.STMAP)
	@ApiDescription("")
	private Long createTimeStmap;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
		this.createTimeStmap = Timestamp.valueOf(createTime).getTime();
	}

	public Long getCreateTimeStmap() {
		return createTimeStmap;
	}
}
