package com.huaao.ejwplatform.api.dto.bean.analysis;

import java.util.ArrayList;
import java.util.List;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class AlertDoneBarChar {

	@ApiDemoData("05-11;05-12")
	@ApiDescription("日期")
	private List<String> date = new ArrayList<>();
	
	@ApiDemoData("21;12")
	@ApiDescription("接收警情")
	private List<String> recevie = new ArrayList<>();
	
	@ApiDemoData("21;12")
	@ApiDescription("解除警情")
	private List<String> done = new ArrayList<>();
	
	@ApiDemoData("21;12")
	@ApiDescription("委派警情")
	private List<String> delegate = new ArrayList<>();

	@ApiDemoData("4.0;4.1")
	@ApiDescription("评价")
	private List<String> appraise = new ArrayList<>();
	
	@ApiDemoData("4.0")
	@ApiDescription("总评价")
	private String totalApprasie = null;
	
	
	public List<String> getDate() {
		return date;
	}

	public void setDate(List<String> date) {
		this.date = date;
	}

	public List<String> getRecevie() {
		return recevie;
	}

	public void setRecevie(List<String> recevie) {
		this.recevie = recevie;
	}

	public List<String> getDone() {
		return done;
	}

	public void setDone(List<String> done) {
		this.done = done;
	}

	public List<String> getDelegate() {
		return delegate;
	}

	public void setDelegate(List<String> delegate) {
		this.delegate = delegate;
	}

	public List<String> getAppraise() {
		return appraise;
	}

	public void setAppraise(List<String> appraise) {
		this.appraise = appraise;
	}

	public String getTotalApprasie() {
		return totalApprasie;
	}

	public void setTotalApprasie(String totalApprasie) {
		this.totalApprasie = totalApprasie;
	}
	
	
}
