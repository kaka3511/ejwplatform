package com.huaao.ejwplatform.api.dto.analysis;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoDeptAlertInfoRequest extends DtoPublicRequest{

	@ApiDescription("开始时间")
	@ApiDemoData(DemoData.TIME)
	@NotBlank
	private String startTime;
	
	@ApiDescription("结束时间")
	@ApiDemoData(DemoData.TIME)
	@NotBlank
	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
