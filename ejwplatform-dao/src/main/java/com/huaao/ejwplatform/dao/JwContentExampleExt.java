package com.huaao.ejwplatform.dao;

import java.util.List;

public class JwContentExampleExt extends JwContentExample{

    private String sysSubjectId;
    
    private Integer page;
    
    private Integer pageSize;
    
    private String keyword;

    private Integer status;
    
    private String type;

    private String deptCode;
    
    private List<String> deptCodes;

    private List<String> subjectIds;

	public String getSysSubjectId() {
		return sysSubjectId;
	}

	public void setSysSubjectId(String sysSubjectId) {
		this.sysSubjectId = sysSubjectId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public List<String> getDeptCodes() {
		return deptCodes;
	}

	public void setDeptCodes(List<String> deptCodes) {
		this.deptCodes = deptCodes;
	}

	public List<String> getSubjectIds() {
		return subjectIds;
	}

	public void setSubjectIds(List<String> subjectIds) {
		this.subjectIds = subjectIds;
	}
}