package com.huaao.ejwplatform.api.dto.ems;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoEmsMailNumRequest {
	@ApiDescription("物流订单号ID")
	@NotBlank
	private String txLogisticID;
	
	@ApiDescription("物流运单号")
	@NotBlank
	private String mailNum;
	
	private String desc;
	
	private String status;

	public String getTxLogisticID() {
		return txLogisticID;
	}

	public void setTxLogisticID(String txLogisticID) {
		this.txLogisticID = txLogisticID;
	}

	public String getMailNum() {
		return mailNum;
	}

	public void setMailNum(String mailNum) {
		this.mailNum = mailNum;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
