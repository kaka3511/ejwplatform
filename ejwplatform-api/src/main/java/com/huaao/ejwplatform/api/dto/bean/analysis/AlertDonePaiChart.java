package com.huaao.ejwplatform.api.dto.bean.analysis;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class AlertDonePaiChart {
	
	@ApiDemoData("335")
	@ApiDescription("未解除")
	private Integer undo ; 
	
	@ApiDemoData("335")
	@ApiDescription("已解除")
	private Integer done ; 
	
	@ApiDemoData("335")
	@ApiDescription("处理中")
	private Integer doing ; 
	
	@ApiDemoData("335")
	@ApiDescription("已委派")
	private Integer delegate ; 
	
	@ApiDemoData("335")
	@ApiDescription("已委派IOS使用")
	private Integer delegater ; 
	
	@ApiDemoData("335")
	@ApiDescription("尚未评价")
	private Integer noAppraise ; 
	
	@ApiDemoData("335")
	@ApiDescription("好评")
	private Integer appraise1 ; 
	
	@ApiDemoData("335")
	@ApiDescription("中评")
	private Integer appraise2 ; 
	
	@ApiDemoData("335")
	@ApiDescription("差评")
	private Integer appraise3 ;

	@ApiDemoData("444")
	@ApiDescription("接收警情数")
	private Integer total;
	
	public Integer getDelegater() {
		return delegater;
	}

	public void setDelegater(Integer delegater) {
		this.delegater = delegater;
	}

	public Integer getUndo() {
		return undo;
	}

	public void setUndo(Integer undo) {
		this.undo = undo;
	}

	public Integer getDone() {
		return done;
	}

	public void setDone(Integer done) {
		this.done = done;
	}

	public Integer getDoing() {
		return doing;
	}

	public void setDoing(Integer doing) {
		this.doing = doing;
	}

	public Integer getDelegate() {
		return delegate;
	}

	public void setDelegate(Integer delegate) {
		this.delegate = delegate;
	}

	public Integer getNoAppraise() {
		return noAppraise;
	}

	public void setNoAppraise(Integer noAppraise) {
		this.noAppraise = noAppraise;
	}

	public Integer getAppraise1() {
		return appraise1;
	}

	public void setAppraise1(Integer appraise1) {
		this.appraise1 = appraise1;
	}

	public Integer getAppraise2() {
		return appraise2;
	}

	public void setAppraise2(Integer appraise2) {
		this.appraise2 = appraise2;
	}

	public Integer getAppraise3() {
		return appraise3;
	}

	public void setAppraise3(Integer appraise3) {
		this.appraise3 = appraise3;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	} 
 
	
 
}
