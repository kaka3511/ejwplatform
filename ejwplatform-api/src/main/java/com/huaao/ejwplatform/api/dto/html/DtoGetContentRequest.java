package com.huaao.ejwplatform.api.dto.html;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoGetContentRequest {
	
	@ApiDescription("内容ID")
	@ApiDemoData("004507ae57734964b7187a996f117e42")
	@NotEmpty(message="内容ID不能为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
