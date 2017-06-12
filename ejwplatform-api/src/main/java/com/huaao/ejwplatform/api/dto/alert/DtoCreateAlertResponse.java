package com.huaao.ejwplatform.api.dto.alert;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoCreateAlertResponse extends DtoPublicResponse{

	@ApiDescription("警情ID")
	@ApiDemoData("03fc86e759c64b029563da4037989df7")
	private String alertId;

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	} 
	
	
}
