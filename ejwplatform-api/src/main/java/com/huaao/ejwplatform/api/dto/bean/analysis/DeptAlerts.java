package com.huaao.ejwplatform.api.dto.bean.analysis;

import java.util.List;

import com.huaao.ejwplatform.api.dto.bean.AlertItem;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DeptAlerts {
	
	@ApiDemoData("4028876d5a652216015a6522ca630000")
	@ApiDescription("部门ID")
    private String id;
	
	@ApiDemoData("当代社区警务室")
	@ApiDescription("部门名称,(警务室)")
    private String name;
	
	private List<AlertItem> alerts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AlertItem> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<AlertItem> alerts) {
		this.alerts = alerts;
	}
	
}
