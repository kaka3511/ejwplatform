package com.huaao.ejwplatform.api.dto.user;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;

public class DtoAuthRequest extends DtoPublicRequest{

	@NotBlank
	private String type = null;
	
	private String deptId = null;
	
	private String cardcode = null;
	
	@NotBlank
	private String cardImg1 = null;
	
	@NotBlank
	private String cardImg2 = null;
	

	private String jobsId = null;
	

	private String policemanCode=null;
	
	@NotBlank
	private String realname = null;
	
	private String address;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public String getCardImg1() {
		return cardImg1;
	}

	public void setCardImg1(String cardImg1) {
		this.cardImg1 = cardImg1;
	}

	public String getCardImg2() {
		return cardImg2;
	}

	public void setCardImg2(String cardImg2) {
		this.cardImg2 = cardImg2;
	}

	public String getJobsId() {
		return jobsId;
	}

	public void setJobsId(String jobsId) {
		this.jobsId = jobsId;
	}

	public String getPolicemanCode() {
		return policemanCode;
	}

	public void setPolicemanCode(String policemanCode) {
		this.policemanCode = policemanCode;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
