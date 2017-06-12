package com.huaao.ejwplatform.api.dto.auth;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class DtoLoginRequest {
	
	@NotBlank
	String phone;
	@NotBlank
	String password;
	String gtCode;
	String deviceID;
	String deviceToken;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGtCode() {
		return gtCode;
	}
	public void setGtCode(String gtCode) {
		this.gtCode = gtCode;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	
	
}
