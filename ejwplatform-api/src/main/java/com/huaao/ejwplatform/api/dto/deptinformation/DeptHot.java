package com.huaao.ejwplatform.api.dto.deptinformation;

import java.util.ArrayList;
import java.util.List;

public class DeptHot {
	private String description; 
	private List<DeptHotData> keywords = new ArrayList<>();
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<DeptHotData> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<DeptHotData> keywords) {
		this.keywords = keywords;
	}
	
	public void setKeywords(String keyword,String description){
		this.keywords.add(new DeptHotData(keyword,description));
	}
}

