package com.huaao.ejwplatform.api.dto.banner;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoGetBannerListRequest extends DtoPublicRequest {

	@ApiDemoData("1")
	@ApiDescription("类型 0：web 1：app （必填）")
	@NotBlank(message="类型不能为空")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
