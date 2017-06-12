package com.huaao.ejwplatform.api.dto.ems;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoEmsPayResultRequest extends DtoEmsRequest{

	@ApiDescription("业务订单号")
	@NotBlank
	private String bizOrderNo;

	@ApiDescription("支付平台 P，微信支付 Q，电子扫码支付")
	@NotBlank
	private String payPlatform;
	
	@ApiDescription("支付接口 01.PC网页在线跳转支付 02 手机端wap支付")
	@NotBlank
	private String payWay;
	
	@ApiDescription("交易金额 以分为单位")
	@NotBlank
	private String payAmount;
	
	@ApiDescription("支付状态 01待付,02已付")
	@NotBlank
	private String payResult;
	
	@ApiDescription("请求方保留用域，用户自定义。回调用户前台地址时，会原样返回。")
	private String reqReserved;
	
	@ApiDescription("交易传输时间")
	@NotBlank
	private String payTime;
	
	@ApiDescription("付款人的支付账号（银行卡号或支付宝账号）")
	private String userPayAccount;
	
	@ApiDescription("订单发起时间")
	@NotBlank
	private String orderTime;
	
	public String getBizOrderNo() {
		return bizOrderNo;
	}

	public void setBizOrderNo(String bizOrderNo) {
		this.bizOrderNo = bizOrderNo;
	}

	public String getPayPlatform() {
		return payPlatform;
	}

	public void setPayPlatform(String payPlatform) {
		this.payPlatform = payPlatform;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayResult() {
		return payResult;
	}

	public void setPayResult(String payResult) {
		this.payResult = payResult;
	}

	public String getReqReserved() {
		return reqReserved;
	}

	public void setReqReserved(String reqReserved) {
		this.reqReserved = reqReserved;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getUserPayAccount() {
		return userPayAccount;
	}

	public void setUserPayAccount(String userPayAccount) {
		this.userPayAccount = userPayAccount;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

}
