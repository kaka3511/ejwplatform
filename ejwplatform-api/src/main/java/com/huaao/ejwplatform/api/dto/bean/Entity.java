package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class Entity{

	@ApiDescription("站点id")
	@ApiDemoData("")
	private String id;

	@ApiDemoData("")
	@ApiDescription("站点类型")
    private Integer type;

	@ApiDemoData("")
	@ApiDescription("站点名称")
    private String entityName;

	@ApiDemoData("")
	@ApiDescription("地址")
    private String address;

	@ApiDemoData("")
	@ApiDescription("经纬度")
    private String location;

	@ApiDemoData("")
	@ApiDescription("高得经纬度")
    private String gdLocation;
	
	@ApiDemoData("")
	@ApiDescription("联系电话")
    private String telphone;

	@ApiDemoData("")
	@ApiDescription("责任民警")
    private String liabPolicy;

	@ApiDemoData("")
	@ApiDescription("责任民警电话")
	private String liabPolicyPhone;

	@ApiDemoData("")
	@ApiDescription("站点图片")
    private String imgs;

	@ApiDemoData("")
	@ApiDescription("站点描述")
    private String description;

	@ApiDemoData("")
	@ApiDescription("所属单位ID")
    private String deptId;

	@ApiDemoData("")
	@ApiDescription("所属单位名称")
    private String deptName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getLiabPolicy() {
		return liabPolicy;
	}
	public void setLiabPolicy(String liabPolicy) {
		this.liabPolicy = liabPolicy;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getLiabPolicyPhone() {
		return liabPolicyPhone;
	}
	public void setLiabPolicyPhone(String liabPolicyPhone) {
		this.liabPolicyPhone = liabPolicyPhone;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getGdLocation() {
		return gdLocation;
	}
	public void setGdLocation(String gdLocation) {
		this.gdLocation = gdLocation;
	}
	
	
}
