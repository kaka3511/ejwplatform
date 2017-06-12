package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class EnterpriseItemHelper {
	@ApiDescription("企业机构-1")
	@ApiDemoData("")
	private DeptInformationInfoHelper enterprise1;
	
	@ApiDescription("企业机构-2")
	@ApiDemoData("")
	private DeptInformationInfoHelper enterprise2;

	public DeptInformationInfoHelper getEnterprise1() {
		return enterprise1;
	}

	public void setEnterprise1(DeptInformationInfoHelper enterprise1) {
		this.enterprise1 = enterprise1;
	}

	public DeptInformationInfoHelper getEnterprise2() {
		return enterprise2;
	}

	public void setEnterprise2(DeptInformationInfoHelper enterprise2) {
		this.enterprise2 = enterprise2;
	}
}
