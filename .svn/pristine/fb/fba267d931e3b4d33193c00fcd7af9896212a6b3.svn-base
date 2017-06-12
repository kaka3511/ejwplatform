package com.huaao.ejwplatform.api.dto.dept;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoDeptFindByIdRequest extends DtoPublicRequest{

	@ApiDemoData("8a2b2a045a943267015a9454e6080006")
	@ApiDescription("部门ID")
	@NotEmpty(message="部门ID不能为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
