package com.huaao.ejwplatform.api.dto.auth;

import org.hibernate.validator.constraints.NotBlank;

public class DtoHasPhoneRequest {

	@NotBlank
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
