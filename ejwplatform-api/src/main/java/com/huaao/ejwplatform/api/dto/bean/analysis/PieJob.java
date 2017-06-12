package com.huaao.ejwplatform.api.dto.bean.analysis;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class PieJob {
	
	@ApiDemoData("警力类型")
	@ApiDescription("警力类型")
	private String jobName;
	
	@ApiDemoData("18")
	private Integer count;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
