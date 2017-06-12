package com.huaao.ejwplatform.api.dto.msg;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoMsgSendRequest extends DtoPublicRequest{
	
	@ApiDescription("咨询标题")
	@NotBlank(message="标题不能为空")
	private String title;
	
	@ApiDescription("咨询内容")
	@NotBlank(message="内容不能为空")
	private String content;
	
	@ApiDescription("咨询人id")
	@NotBlank(message="用户ID不能为空")
	private String userId;	       
	
	@ApiDescription("留言类型。1居民咨询 2所长信箱 3我要找警")
	@NotNull(message="留言类型不能为空")
	private Integer type;
	
	@ApiDescription("回复人id")
	private String replyUserId;	  
	
	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}	
	

}
