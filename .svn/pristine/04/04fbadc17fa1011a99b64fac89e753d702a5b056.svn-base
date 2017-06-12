package com.huaao.ejwplatform.api.dto.dept;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoDeptFindByAreaRequest  extends DtoPublicRequestPager{

	@ApiDescription("区域ID")
	@ApiDemoData("4028876d5a652216015a6522ca630000")
	@NotEmpty(message="区域ID不能为空")
	private String areaId;

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}
