package com.huaao.ejwplatform.api.dto.bean;

import java.util.List;

public class MonitorGroupInfo {
	 
    private String id;

    private String name;
   
    private List<MonitorInfo> monitors;

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

	public List<MonitorInfo> getMonitors() {
		return monitors;
	}

	public void setMonitors(List<MonitorInfo> monitors) {
		this.monitors = monitors;
	}
    
}
