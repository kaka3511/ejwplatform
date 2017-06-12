package com.huaao.ejwplatform.api.dto.functionaldept;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoFunctionalDeptDeleteRequest extends DtoPublicRequest{

	@ApiDescription("职能部门ID")
	@ApiDemoData(DemoData.ID)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
