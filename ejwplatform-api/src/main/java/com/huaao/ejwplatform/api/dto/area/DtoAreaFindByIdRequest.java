package com.huaao.ejwplatform.api.dto.area;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoAreaFindByIdRequest  extends DtoPublicRequest{

	@ApiDescription("区域ID")
	@ApiDemoData("4028876d5a652216015a6522ca630000")
	@NotEmpty(message="区域ID不能为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
