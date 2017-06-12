package com.huaao.ejwplatform.api.dto.criminal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoHasRecordRequest extends DtoPublicRequest{
	@ApiDescription("记录id，多个逗号分隔")
	@ApiDemoData(DemoData.ID_S)
	@NotBlank
	private String criminalIds ;
	
	@ApiDescription(" 是否有犯罪记录 1 没有 ， 2 有")
	@ApiDemoData("1")
	@NotNull
	private Integer hasRecord;

	public String getCriminalIds() {
		return criminalIds;
	}

	public void setCriminalIds(String criminalIds) {
		this.criminalIds = criminalIds;
	}

	public Integer getHasRecord() {
		return hasRecord;
	}

	public void setHasRecord(Integer hasRecord) {
		this.hasRecord = hasRecord;
	}
	
	
}
