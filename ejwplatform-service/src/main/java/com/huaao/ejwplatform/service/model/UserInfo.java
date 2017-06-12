package com.huaao.ejwplatform.service.model;


import com.huaao.ejwplatform.dao.SysDept;
import com.huaao.ejwplatform.dao.SysJobs;
import com.huaao.ejwplatform.dao.SysUser;

public class UserInfo extends SysUser{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2847136145060560949L;

	private SysDept dept;
    
    private SysJobs jobs;

	public SysDept getDept() {
		return dept;
	}

	public void setDept(SysDept dept) {
		this.dept = dept;
	}

	public SysJobs getJobs() {
		return jobs;
	}

	public void setJobs(SysJobs jobs) {
		this.jobs = jobs;
	}
    
    
}
