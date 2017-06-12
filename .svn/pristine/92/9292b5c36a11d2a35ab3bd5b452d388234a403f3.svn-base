package com.huaao.ejwplatform.api.dto.user;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoQueryAuthingUserRequest extends DtoPublicRequest{

	@ApiDescription("用户id,逗号分隔")
	@NotBlank
	private String userIds ;

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
 
}
