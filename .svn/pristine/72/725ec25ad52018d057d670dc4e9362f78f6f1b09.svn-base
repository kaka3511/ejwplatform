package com.huaao.ejwplatform.api.dto.analysis;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoGetAlertSummaryRequest extends DtoPublicRequest{

	@ApiDemoData("1")
	@ApiDescription("数据类型 1警情统计 2 警力统计 3处理分析")
	@NotBlank
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
