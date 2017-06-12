package com.huaao.ejwplatform.api.dto.deptinformation;

public class DeptHotData{
	private String keyword;
	private String description;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DeptHotData(String keyword, String description){
		this.setKeyword(keyword);
		this.setDescription(description);
	}
	public DeptHotData(){
		
	}
}