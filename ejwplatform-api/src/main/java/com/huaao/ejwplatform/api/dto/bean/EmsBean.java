package com.huaao.ejwplatform.api.dto.bean;

import java.util.Date;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

/**
 * 对应jw_ems表
 *
 */
public class EmsBean {
 
	@ApiDemoData("")
	@ApiDescription("物流订单号-对应recordID")
    private String txLogisticId;

	@ApiDemoData("")
	@ApiDescription("物流运单号")
    private String mailNum;

	@ApiDemoData("")
	@ApiDescription("揽投状态，1成功 其他失败")
    private Integer status;

	@ApiDemoData("")
	@ApiDescription("揽投失败原因描述")
    private String desc;

	@ApiDemoData("")
	@ApiDescription("创建时间")
    private Date createTime;

	public String getTxLogisticId() {
		return txLogisticId;
	}

	public void setTxLogisticId(String txLogisticId) {
		this.txLogisticId = txLogisticId;
	}

	public String getMailNum() {
		return mailNum;
	}

	public void setMailNum(String mailNum) {
		this.mailNum = mailNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
