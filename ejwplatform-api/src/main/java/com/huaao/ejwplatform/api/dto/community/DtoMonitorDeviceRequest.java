package com.huaao.ejwplatform.api.dto.community;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;

public class DtoMonitorDeviceRequest extends DtoPublicRequest{
	
	private String monitorDeviceId ;

	public String getMonitorDeviceId() {
		return monitorDeviceId;
	}

	public void setMonitorDeviceId(String monitorDeviceId) {
		this.monitorDeviceId = monitorDeviceId;
	}
	
}
