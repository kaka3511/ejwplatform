package com.huaao.ejwplatform.api.dto.ems;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoEmsStatusRequest extends DtoPublicRequest{

	@ApiDemoData("")
	@ApiDescription("物流运单号")
	@NotBlank(message="物流运单号不能为空")
	private String mailNum ;

	@ApiDemoData("")
	@ApiDescription("申请单号，如无犯罪记录证明申请记录ID")
	@NotBlank(message="申请单号不能为空")
	private String recordId;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getMailNum() {
		return mailNum;
	}

	public void setMailNum(String mailNum) {
		this.mailNum = mailNum;
	}
}
