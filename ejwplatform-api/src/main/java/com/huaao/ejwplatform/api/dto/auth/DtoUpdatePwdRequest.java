package com.huaao.ejwplatform.api.dto.auth;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoUpdatePwdRequest {

	@NotEmpty
	private String phone;
	@ApiDescription("新密码")
	@NotEmpty
	private String rawPassword;
	@ApiDescription("旧密码")
	@NotEmpty
	private String password;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRawPassword() {
		return rawPassword;
	}
	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
