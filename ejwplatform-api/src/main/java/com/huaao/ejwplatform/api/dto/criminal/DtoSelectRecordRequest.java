package com.huaao.ejwplatform.api.dto.criminal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoSelectRecordRequest extends DtoPublicRequest{
	@ApiDescription("记录id")
	@ApiDemoData(DemoData.ID)
	@NotBlank
	private String criminalIds ;
	
	@ApiDescription(" 1 自取 2 EMS")
	@ApiDemoData("1")
	@NotNull
	private Integer recieveType;

	public String getCriminalIds() {
		return criminalIds;
	}

	public void setCriminalIds(String criminalIds) {
		this.criminalIds = criminalIds;
	}

	public Integer getRecieveType() {
		return recieveType;
	}

	public void setRecieveType(Integer recieveType) {
		this.recieveType = recieveType;
	}
 
	
	
}
