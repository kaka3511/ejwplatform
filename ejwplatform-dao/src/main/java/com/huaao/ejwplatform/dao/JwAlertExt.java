package com.huaao.ejwplatform.dao;

public class JwAlertExt extends JwAlert{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String deptCode;
	
	private String deptName;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}