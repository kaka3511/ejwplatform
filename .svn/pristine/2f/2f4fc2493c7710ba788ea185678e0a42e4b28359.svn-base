package com.huaao.ejwplatform.api.dto.criminal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoAcceptCriminalRequest extends DtoPublicRequest{

	@ApiDescription("受理记录id，多个逗号分隔")
	@ApiDemoData(DemoData.ID_S)
	@NotBlank
	private String criminalIds ;

	@ApiDescription("受理意见")
	@ApiDemoData("受理意见")
	private String authDesc;
	
	@ApiDescription(" 1 已受理 2 拒绝")
	@ApiDemoData("1")
	@NotNull
	private Integer authStatus;
	
	public String getCriminalIds() {
		return criminalIds;
	}

	public void setCriminalIds(String criminalIds) {
		this.criminalIds = criminalIds;
	}


	public String getAuthDesc() {
		return authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}
	
	
	
}
