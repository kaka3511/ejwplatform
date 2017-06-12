package com.huaao.ejwplatform.api.dto.ems;

import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.EmsUtils;

public class DtoEmsPayRequest extends DtoPublicRequest{

	@ApiDescription("无犯罪记录证明申请ID")
	@NotBlank
	private String id;
	
	@ApiDescription("收件人姓名")
	private String username;
	
	@ApiDescription("收件人手机号")
	private String phone;
	
	@ApiDescription("收件人地址ID")
	private String areaId;
	
	@ApiDescription("收件人详细地址")
	private String address;
	
	@ApiDescription("邮政编码")
	private String postcode;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
