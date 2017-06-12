package com.huaao.ejwplatform.service.model;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class OnlinePolice{

	@ApiDescription("民警ID")
	@ApiDemoData("03fc86e759c64b029563da4037989df7")
	private String id;
	
	@ApiDescription("在线状态 1在线 0 不在线")
	@ApiDemoData("1")
	private Integer isOnline;
	
	@ApiDescription("民警姓名")
	@ApiDemoData("张三")
	private String realname;
	
	@ApiDescription("民警电话")
	@ApiDemoData("13090000001")
	private String phone;
	
	@ApiDescription("当前坐标")
	@ApiDemoData("114.502482,30.554842")
	private String position;
	
	@ApiDescription("距离, 单位:米")
	@ApiDemoData("114.50")
	private Double distance;
	
	@ApiDescription("职务名称")
	@ApiDemoData("民警")
	private String jobsName;
	
	@ApiDescription("头像地址")
	@ApiDemoData("images/2017-02-22/aaa.jpg")
	private String img;
	
	@ApiDescription("单位名称")
	@ApiDemoData("XX派出所")
	private String deptName;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setPhone(String cellphone) {
		this.phone = cellphone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance2) {
		this.distance = distance2;
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

}
