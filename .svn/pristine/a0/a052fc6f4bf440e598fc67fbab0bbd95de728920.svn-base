package com.huaao.ejwplatform.api.dto.analysis;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("辖区警力分布接口请求参数")
public class DtoGetPoliceChartRequest extends DtoPublicRequest {

	@ApiDescription("起始日期")
	@ApiDemoData("2017-01-01")
	@NotBlank(message="起始日期不能为空")
	private String startTime;
	
	@ApiDescription("截止日期")
	@ApiDemoData("2017-01-16")
	@NotBlank(message="截止日期不能为空")
	private String endTime;

	@ApiDescription("小区ID，为空显示辖区内所有")
	@ApiDemoData("8a2b2a045a943267015a9477fb1f0010")
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
