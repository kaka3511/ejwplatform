package com.huaao.ejwplatform.api.dto.demo;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DemoUserDeleteRequest extends DtoPublicRequest{
	
	@ApiDescription("用户ID")
	private String userId = null;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
