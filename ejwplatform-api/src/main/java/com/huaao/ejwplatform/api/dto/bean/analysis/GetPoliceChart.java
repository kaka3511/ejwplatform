package com.huaao.ejwplatform.api.dto.bean.analysis;

import java.util.List;

import com.huaao.ejwplatform.common.web.ApiDescription;

public class GetPoliceChart {
	@ApiDescription("")
	private GetPoliceCharBar bar;

	@ApiDescription("")
	private List<PieDept> pie;

	public GetPoliceCharBar getBar() {
		return bar;
	}

	public void setBar(GetPoliceCharBar bar) {
		this.bar = bar;
	}

	public List<PieDept> getPie() {
		return pie;
	}

	public void setPie(List<PieDept> pie) {
		this.pie = pie;
	}
}
