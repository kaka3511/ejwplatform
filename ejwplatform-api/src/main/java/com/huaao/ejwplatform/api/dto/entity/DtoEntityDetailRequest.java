package com.huaao.ejwplatform.api.dto.entity;

import javax.validation.constraints.NotNull;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoEntityDetailRequest extends DtoPublicRequest{

	@ApiDescription("站点主键id")
	@NotNull(message="id不能为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
