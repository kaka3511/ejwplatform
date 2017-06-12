package com.huaao.ejwplatform.api.dto.content;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoLearnRequest extends DtoPublicRequest{

	@ApiDescription("栏目内容ID")
	@ApiDemoData("004507ae57734964b7187a996f117e42")
	@NotBlank(message="ID不能为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
