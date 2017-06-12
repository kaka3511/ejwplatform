package com.huaao.ejwplatform.api.dto.subject;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("栏目类别请求参数")
public class DtoSysSubjectRequest extends DtoPublicRequest {

	@ApiDescription("栏目类别ID")
	@NotBlank(message="ID不能为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
