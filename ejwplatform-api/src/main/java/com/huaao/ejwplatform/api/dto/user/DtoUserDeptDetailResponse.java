package com.huaao.ejwplatform.api.dto.user;

import com.huaao.ejwplatform.common.web.ApiDemoData;

public class DtoUserDeptDetailResponse {
	@ApiDemoData("4028876d5a652216015a6522ca630000")
	private String id;
	
	@ApiDemoData("张三")
	private String realname;

	@ApiDemoData("社区民警")
	private String jobsName;
	
	@ApiDemoData("/img/xxx.png")
	private String img;
	
	@ApiDemoData("027-85000000")
	private String phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getJobsName() {
		return jobsName;
	}

	public void setJobsName(String jobsName) {
		this.jobsName = jobsName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
