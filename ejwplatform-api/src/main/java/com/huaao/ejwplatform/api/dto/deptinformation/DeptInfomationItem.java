package com.huaao.ejwplatform.api.dto.deptinformation;

import java.util.ArrayList;
import java.util.List;

public class DeptInfomationItem {
	private String description;
	private List<DeptInfomationItemData> data = new ArrayList<>();
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<DeptInfomationItemData> getData() {
		return data;
	}
	public void setData(List<DeptInfomationItemData> data) {
		this.data = data;
	}
	
	public void addData(String name, String num){
		data.add(new DeptInfomationItemData(name,num));
	}
}

