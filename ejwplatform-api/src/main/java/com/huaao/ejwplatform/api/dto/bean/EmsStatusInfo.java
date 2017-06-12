package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class EmsStatusInfo {
	
	@ApiDemoData("")
	@ApiDescription("发生时间")
    private String createTime;

	@ApiDemoData("")
	@ApiDescription("描述")
    private String description;
	
	private String action;
	


	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
//		StringBuffer desriptionBuffer = new StringBuffer();
//		desriptionBuffer.append(EmsUtils.getEmsStatusMessage(action,this.getProperDelivery()+this.getNotProperDelivery()));
//		this.setDescription(desriptionBuffer.toString());
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
