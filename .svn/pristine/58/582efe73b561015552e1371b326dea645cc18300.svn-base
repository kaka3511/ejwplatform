package com.huaao.ejwplatform.api.dto.functionaldept;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoFunctionalDeptCreateRequest extends DtoPublicRequest{
	
	@ApiDescription("职能部门名称")
	@ApiDemoData("光谷消防大队")
	@NotBlank
	private String name;
	
	@ApiDescription("电话")
	@ApiDemoData("027-88254125")
	@NotBlank
	private String phone;
	
	@ApiDescription("职能部门备注")
	@ApiDemoData("备注")
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
