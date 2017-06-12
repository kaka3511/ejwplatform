package com.huaao.ejwplatform.api.dto.deptinformation;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DeptInformationQueryRequest extends DtoPublicRequestPager{

	@ApiDescription("职能部门ID")
	@ApiDemoData(DemoData.ID)
	private String deptId;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	
	
	
}
