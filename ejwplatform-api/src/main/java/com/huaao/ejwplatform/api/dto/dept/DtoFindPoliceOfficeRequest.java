package com.huaao.ejwplatform.api.dto.dept;


import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoFindPoliceOfficeRequest extends DtoPublicRequestPager{

	@ApiDescription("类型 ,1 不包含派出所   2包含派出所    默认值1")
	@ApiDemoData("1")
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
