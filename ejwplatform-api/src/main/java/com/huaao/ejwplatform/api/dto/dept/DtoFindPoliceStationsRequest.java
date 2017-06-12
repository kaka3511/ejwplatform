package com.huaao.ejwplatform.api.dto.dept;

import javax.validation.constraints.NotNull;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoFindPoliceStationsRequest extends DtoPublicRequestPager {

	@ApiDescription("业务类型 ,1 无犯罪记录证明")
	@ApiDemoData("1")
	@NotNull(message="业务类型不能为空")
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
