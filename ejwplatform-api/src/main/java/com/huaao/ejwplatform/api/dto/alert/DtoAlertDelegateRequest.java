package com.huaao.ejwplatform.api.dto.alert;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoAlertDelegateRequest extends DtoPublicRequest{
	
	@ApiDescription("警情ID,多个警情逗号分隔")
	@ApiDemoData(DemoData.ID_S)
	@NotBlank
	private String alertId;
	
	@ApiDescription("被委派人ID")
	@ApiDemoData(DemoData.ID)
	@NotBlank
	private String userId ;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	} 
	
	
}
