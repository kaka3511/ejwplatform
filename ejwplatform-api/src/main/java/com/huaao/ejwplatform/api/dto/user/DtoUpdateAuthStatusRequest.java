package com.huaao.ejwplatform.api.dto.user;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;

public class DtoUpdateAuthStatusRequest extends DtoPublicRequest{

	@NotBlank
	private String auth;
	
	private String authMsg;
	
	@NotBlank
	private String id;
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getAuthMsg() {
		return authMsg;
	}
	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
