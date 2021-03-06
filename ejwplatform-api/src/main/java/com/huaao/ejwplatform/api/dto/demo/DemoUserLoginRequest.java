package com.huaao.ejwplatform.api.dto.demo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DemoUserLoginRequest extends DtoPublicRequest{
	@ApiDescription("登录账号")
	@NotBlank
	private String account;
	
	@ApiDescription("登录账号")
	@Pattern(regexp = "^[a-zA-Z_]*$",message="需全部为字母")
	private String password;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
