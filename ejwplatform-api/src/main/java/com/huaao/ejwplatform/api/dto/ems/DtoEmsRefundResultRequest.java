package com.huaao.ejwplatform.api.dto.ems;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoEmsRefundResultRequest extends DtoEmsRequest{

	@ApiDescription("EMS收银台交易订单号")
	@NotBlank
	private String orderNo;
	
	@ApiDescription("业务订单号")
	@NotBlank
	private String bizOrderNo;
	
	@ApiDescription("支付状态 01待付,02已付,03已退款，04退款失败")
	@NotBlank
	private String payResult;
	
	@ApiDescription("退款结果 T:成功 F 失败")
	@NotBlank
	private String refundResult;
	
	@ApiDescription("退款失败原因")
	@NotBlank
	private String faildReason;
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBizOrderNo() {
		return bizOrderNo;
	}

	public void setBizOrderNo(String bizOrderNo) {
		this.bizOrderNo = bizOrderNo;
	}

	public String getPayResult() {
		return payResult;
	}

	public void setPayResult(String payResult) {
		this.payResult = payResult;
	}

	public String getRefundResult() {
		return refundResult;
	}

	public void setRefundResult(String refundResult) {
		this.refundResult = refundResult;
	}

	public String getFaildReason() {
		return faildReason;
	}

	public void setFaildReason(String faildReason) {
		this.faildReason = faildReason;
	}

}
