package com.huaao.ejwplatform.api.dto.bean.analysis;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class PieDept {

	@ApiDemoData("区域名称")
	@ApiDescription("区域名称")
	private String deptName;
	
	@ApiDemoData("18")
	private Integer count;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
