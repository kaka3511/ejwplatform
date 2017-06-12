package com.huaao.ejwplatform.api.dto.entity;


import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoEntityListRequest extends DtoPublicRequestPager{

	@ApiDescription("站点类型")
	private Integer type;
	 
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
