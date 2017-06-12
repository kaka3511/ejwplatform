package com.huaao.ejwplatform.api.dto.bean;

import java.util.List;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class AlertInfo {
	
	@ApiDescription("")
	@ApiDemoData("")
	private String alertId;
	
	@ApiDescription("报警人ID")
	@ApiDemoData(DemoData.ID)
	private String alertUserId;  
	
	@ApiDescription("报警人姓名")
	@ApiDemoData("张三")
	private String alertUserName; // 
	
	@ApiDescription("报警人头像")
	@ApiDemoData(DemoData.IMAGE)
	private String alertUserImg;
	
	@ApiDescription("报警人真实姓名")
	@ApiDemoData(DemoData.NAME)
	private String alertUserRealname;
	
	@ApiDescription("报警时间")
	@ApiDemoData(DemoData.TIME)
	private String alertTime; // 
	
	@ApiDescription("手机号")
	@ApiDemoData(DemoData.CELL_PHONE)
	private String cellphone;
	
	@ApiDescription("地址")
	@ApiDemoData(DemoData.ADDRESS)
	private String address;
	
	@ApiDescription("描述")
	@ApiDemoData("警情描述")
	private String description;
	
	@ApiDescription("经纬度")
	@ApiDemoData(DemoData.LOCATION)
	private String location;// 
	
	@ApiDescription("警情图片 多个以逗号分隔")
	@ApiDemoData(DemoData.IMAGES)
	private String imgs;// 
	
	@ApiDescription("警情录音 多个以逗号分隔")
	@ApiDemoData(DemoData.VEDIOS)
	private String voices;// 
	
	@ApiDescription("录音时间 单位 秒,多个以逗号分隔")
	@ApiDemoData("120,210")
	private String voicesTime;
	
	@ApiDescription("警情视频 多个以逗号分隔")
	@ApiDemoData(DemoData.VEDIOS)
	private String videos; 
	
	@ApiDescription("视频时间 单位 秒,多个以逗号分隔")
	@ApiDemoData("120,210")
	private String videosTime;
 
	
	@ApiDemoData("1")
	@ApiDescription("1-一键报警 ,2-随手记 ,3-随手拍,4-警情补录")
	private Integer type; 
	
	
	@ApiDescription("警情处理记录")
	private List<AlertLog> logs = null;
	
	@ApiDescription("处理状态,0-未处理,1-已完成(已评价),2-已委派(选配),3-已协作(选配),4-已上报(选配),5-已删除,6-待评价（已解除）")
	@ApiDemoData("0")
	private Integer status; 
	
	@ApiDescription("1 有效警情 , 2 重复警情 , 3无效警情")
	@ApiDemoData("1")
	private Integer alertCategory; 
	
	@ApiDescription("警情处理备注")
	@ApiDemoData("备注")
	private String remark;
	
	@ApiDescription("更新时间")
	@ApiDemoData(DemoData.TIME)
	private String updateTime;
	
	@ApiDescription("是否保存 0 否，1 是")
	@ApiDemoData("0")
	private Integer saveFlag;
 
	@ApiDescription("被委派人")
	private UserItem curPolice;
	
	@ApiDescription("委派人")
	private UserItem delegatePolice;
	
	@ApiDescription("警情所属派出所ID")
	@ApiDemoData(DemoData.ID)
	private String alertDeptId;  
	
	@ApiDescription("报警类型分类 : 群众求助1 ,举报线索2 ,投诉监督3 ,治安事件4 ,交通事件5 ,抢险救援6 ,刑事案件7")
	@ApiDemoData("1")
	private Integer classify;
	
	@ApiDescription("所属类别")
	@ApiDemoData("alarm")
    private String category;

	public String getAlertDeptId() {
		return alertDeptId;
	}
	public void setAlertDeptId(String alertDeptId) {
		this.alertDeptId = alertDeptId;
	}
	public UserItem getDelegatePolice() {
		return delegatePolice;
	}
	public void setDelegatePolice(UserItem delegatePolice) {
		this.delegatePolice = delegatePolice;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getAlertUserRealname() {
		return alertUserRealname;
	}
	public void setAlertUserRealname(String alertUserRealname) {
		this.alertUserRealname = alertUserRealname;
	}
	public String getAlertUserImg() {
		return alertUserImg;
	}
	public void setAlertUserImg(String alertUserImg) {
		this.alertUserImg = alertUserImg;
	}
	public String getVoicesTime() {
		return voicesTime;
	}
	public void setVoicesTime(String voicesTime) {
		this.voicesTime = voicesTime;
	}
	public String getVideosTime() {
		return videosTime;
	}
	public void setVideosTime(String videosTime) {
		this.videosTime = videosTime;
	}
	public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		category="alarm";
		this.alertId = alertId;
	}
	public String getAlertUserId() {
		return alertUserId;
	}
	public void setAlertUserId(String alertUserId) {
		this.alertUserId = alertUserId;
	}
	public String getAlertUserName() {
		return alertUserName;
	}
	public void setAlertUserName(String alertUserName) {
		this.alertUserName = alertUserName;
	}
	public String getAlertTime() {
		return alertTime;
	}
	public void setAlertTime(String alertTime) {
		this.alertTime = alertTime;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getVoices() {
		return voices;
	}
	public void setVoices(String voices) {
		this.voices = voices;
	}
	public String getVideos() {
		return videos;
	}
	public void setVideos(String videos) {
		this.videos = videos;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<AlertLog> getLogs() {
		return logs;
	}
	public void setLogs(List<AlertLog> logs) {
		this.logs = logs;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAlertCategory() {
		return alertCategory;
	}
	public void setAlertCategory(Integer alertCategory) {
		this.alertCategory = alertCategory;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(Integer saveFlag) {
		this.saveFlag = saveFlag;
	}
	public UserItem getCurPolice() {
		return curPolice;
	}
	public void setCurPolice(UserItem curPolice) {
		this.curPolice = curPolice;
	}
	public Integer getClassify() {
		return classify;
	}
	public void setClassify(Integer classify) {
		this.classify = classify;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		
	}
}
