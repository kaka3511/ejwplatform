package com.huaao.ejwplatform.api.dto.alert;


import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("警情移交接口请求参数")
public class DtoHandoverAlertRequest extends DtoPublicRequest{
	@ApiDescription("警情ID,多个警情逗号分隔")
	@ApiDemoData(DemoData.ID_S)
	@NotBlank(message="警情ID不能为空")
	private String alertId;
	
	@ApiDescription("部门ID")
	@NotBlank(message="部门ID不能为空")
	@ApiDemoData("03fc86e759c64b029563da4037989df7")
	private String deptId;
	
	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
