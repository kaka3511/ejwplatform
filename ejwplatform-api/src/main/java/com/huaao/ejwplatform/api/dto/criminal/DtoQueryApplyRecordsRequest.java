package com.huaao.ejwplatform.api.dto.criminal;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoQueryApplyRecordsRequest extends DtoPublicRequest{

	@ApiDescription("网上办事ID")
	@ApiDemoData(DemoData.ID)
	@NotBlank(message="网上办事ID必须输入")
	private String criminalId;

	public String getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(String criminalId) {
		this.criminalId = criminalId;
	}
}
