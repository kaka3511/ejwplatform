package com.huaao.ejwplatform.api.dto.functionaldept;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoFunctionalDeptUpdateRequest extends DtoFunctionalDeptCreateRequest{

	@ApiDescription("职能部门ID")
	@ApiDemoData(DemoData.ID)
	@NotBlank
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
