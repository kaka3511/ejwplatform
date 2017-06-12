package com.huaao.ejwplatform.api.dto.jobs;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoJobsFindByDeptRequest extends DtoPublicRequestPager{

	@ApiDescription("部门ID")
	@ApiDemoData("4028876d5a652216015a6522ca630000")
	@NotEmpty(message="部门ID不能为空")
	private String deptId;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
