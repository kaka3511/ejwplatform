package com.huaao.ejwplatform.api.dto.auth;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoSendSmsCodeRequest {

	@NotBlank
	private String phone;
	
	@NotBlank
	@ApiDescription("type 目前有两种 注册，找回密码 分别对应的 为 register , findPwd")
	private String type;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
