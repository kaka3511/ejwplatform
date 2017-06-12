package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class VerifyInfo {

	@ApiDemoData(DemoData.CELL_PHONE)
	@ApiDescription("")
	private String phone;
	
	private String cardImg1;//图片1
	    
	private String cardImg2;//图片2
 
	private String cardcode;//身份证
	
	
	@ApiDemoData("MJ1111")
	@ApiDescription("")
	private String policemanCode;
	 
	
	@ApiDemoData("张三")
	@ApiDescription("")
	private String realname;
	
	private String address;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
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
