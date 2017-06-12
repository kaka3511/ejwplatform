package com.huaao.ejwplatform.api.dto.criminal;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoUserInfoForQueryCriminalResponse {

	@ApiDemoData(DemoData.CELL_PHONE)
	@ApiDescription("代办人手机号码")
	private String phone;
	
	@ApiDemoData("43010519820812163X")
	@ApiDescription("代办人身份证ID")
	private String idCard;
	
	@ApiDemoData("张三")
	@ApiDescription("代办人姓名")
	private String realname;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
}
