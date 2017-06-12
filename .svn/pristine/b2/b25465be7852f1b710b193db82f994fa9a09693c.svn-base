package com.huaao.ejwplatform.api.dto.criminal;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoQueryCriminalDetailRequest extends DtoPublicRequest{

	@ApiDescription("犯罪证明ID")
	@ApiDemoData(DemoData.ID)
	@NotBlank(message="证明ID不能为空")
    private String criminalId;

	public String getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(String criminalId) {
		this.criminalId = criminalId;
	}
}
