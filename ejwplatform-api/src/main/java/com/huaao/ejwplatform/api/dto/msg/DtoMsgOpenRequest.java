package com.huaao.ejwplatform.api.dto.msg;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;


public class DtoMsgOpenRequest extends DtoPublicRequest{
	
	@ApiDescription("消息ID")
	@NotBlank(message="消息ID不能为空,多个ID以逗号分隔")
	private String id;
	
	@ApiDescription("是否公开，0不公开 1公开")
	@NotNull
	private Integer open;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}
	
}
