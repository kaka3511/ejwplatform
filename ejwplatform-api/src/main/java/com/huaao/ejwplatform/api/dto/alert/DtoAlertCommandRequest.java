package com.huaao.ejwplatform.api.dto.alert;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("警情指挥调度接口请求参数")
public class DtoAlertCommandRequest extends DtoPublicRequest{

	@ApiDescription("警情ID,只支持单个")
	@ApiDemoData(DemoData.ID)
	@NotBlank
	private String alertId;

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
}
