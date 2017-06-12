package com.huaao.ejwplatform.api.dto.bean.analysis;

import java.util.List;

public class GetAlertChart {

	private GetAlertChartBar bar;

	private List<PieDept> pie;
	
	
	public GetAlertChartBar getBar() {
		return bar;
	}

	public void setBar(GetAlertChartBar bar) {
		this.bar = bar;
	}

	public List<PieDept> getPie() {
		return pie;
	}

	public void setPie(List<PieDept> pie) {
		this.pie = pie;
	}
	
	
}
