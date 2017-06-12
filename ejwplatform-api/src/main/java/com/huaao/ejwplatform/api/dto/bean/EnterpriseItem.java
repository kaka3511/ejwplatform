package com.huaao.ejwplatform.api.dto.bean;

import java.util.List;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class EnterpriseItem {
	@ApiDescription("企业机构-0")
	@ApiDemoData("")
	private DeptInformationInfoHelper enterprise0;
	
	@ApiDescription("企业机构-11")
	@ApiDemoData("")
	private EnterpriseItemHelper enterprise11;
	
	@ApiDescription("企业机构-22")
	@ApiDemoData("")
	private EnterpriseItemHelper enterprise22;
	
	@ApiDescription("企业机构-33")
	@ApiDemoData("")
	private EnterpriseItemHelper enterprise33;

	public DeptInformationInfoHelper getEnterprise0() {
		return enterprise0;
	}

	public void setEnterprise0(DeptInformationInfoHelper enterprise0) {
		this.enterprise0 = enterprise0;
	}

	public EnterpriseItemHelper getEnterprise11() {
		return enterprise11;
	}

	public void setEnterprise11(EnterpriseItemHelper enterprise11) {
		this.enterprise11 = enterprise11;
	}

	public EnterpriseItemHelper getEnterprise22() {
		return enterprise22;
	}

	public void setEnterprise22(EnterpriseItemHelper enterprise22) {
		this.enterprise22 = enterprise22;
	}

	public EnterpriseItemHelper getEnterprise33() {
		return enterprise33;
	}

	public void setEnterprise33(EnterpriseItemHelper enterprise33) {
		this.enterprise33 = enterprise33;
	}
	
	
}
