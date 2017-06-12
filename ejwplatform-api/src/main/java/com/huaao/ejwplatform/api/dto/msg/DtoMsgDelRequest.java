package com.huaao.ejwplatform.api.dto.msg;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;


public class DtoMsgDelRequest extends DtoPublicRequest{
	
	@ApiDescription("消息ID")
	@NotBlank
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
