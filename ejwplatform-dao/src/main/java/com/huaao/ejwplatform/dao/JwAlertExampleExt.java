package com.huaao.ejwplatform.dao;

import java.util.Date;

public class JwAlertExampleExt extends BaseExample{

	private Integer status;
	
	private Integer type;
	
	private String userName;
	
	private Integer alertCategory;
	
	//like deptCode%
	private String deptCode;
	//= code 
	private String code;
	
	private Date startDate;
	
	private Date endDate;
	//0:所有
	private Integer all;
	
	private String deptId;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getAlertCategory() {
		return alertCategory;
	}

	public void setAlertCategory(Integer alertCategory) {
		this.alertCategory = alertCategory;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
}
