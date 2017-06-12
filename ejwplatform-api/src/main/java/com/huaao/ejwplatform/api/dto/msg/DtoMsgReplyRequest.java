package com.huaao.ejwplatform.api.dto.msg;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;


public class DtoMsgReplyRequest extends DtoPublicRequest{
	
	@ApiDescription("消息ID")
	@NotBlank(message="消息ID不能为空")
	private String id;
	
	@ApiDescription("回复人ID")
	@NotBlank(message="回复人ID不能为空")
	private String replyUserId;

	@ApiDescription("回复内容")
	@NotBlank(message="回复内容不能为空")
	private String replyContent;
	
	@ApiDescription("是否全部可见")
	private Integer open;
	
	@ApiDescription("咨询服务类别classify。1，户政类2，交管类3，证明类4，出入境5，其他")
	private Integer classify;	
	
	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}
	
}
