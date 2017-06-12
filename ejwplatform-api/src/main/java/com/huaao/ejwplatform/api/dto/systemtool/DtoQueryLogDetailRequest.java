package com.huaao.ejwplatform.api.dto.systemtool;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;

public class DtoQueryLogDetailRequest extends DtoPublicRequest{

	@NotBlank
	private String reqId;

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
}
