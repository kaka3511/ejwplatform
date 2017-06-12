package com.huaao.ejwplatform.api.dto.ems;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoEmsGotRequest extends DtoPublicRequest{
	@ApiDescription("证明记录ID")
	@NotBlank
	private String recordId;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
}
