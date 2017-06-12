package com.huaao.ejwplatform.api.dto.deptinformation;

import java.util.ArrayList;
import java.util.List;

public class DeptInstitution {
	private String description;
	private List<DeptInstitutionItem> data = new ArrayList<>();
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<DeptInstitutionItem> getData() {
		return data;
	}
	public void setData(List<DeptInstitutionItem> data) {
		this.data = data;
	}
	
	
}
