package com.huaao.ejwplatform.api.dto.analysis;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoGetAlertProcessChartRequest extends DtoPublicRequest{
	@NotBlank
	private String startTime;
	
	@NotBlank
	private String endTime;
	
	@ApiDescription("小区ID，为空显示辖区内所有")
	private String deptId;

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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
