package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class UserItem {
	@ApiDemoData(DemoData.ID)
	@ApiDescription("用户ID")
	private String id ; //
	
	@ApiDemoData(DemoData.ID)
	@ApiDescription("")
	private String deptId;
	 
	
	@ApiDemoData(DemoData.ID)
	@ApiDescription("")
	private String areaId;
	 
	@ApiDemoData(DemoData.EMAIL)
	@ApiDescription("")
	private String email;
	
	@ApiDemoData(DemoData.ID)
	@ApiDescription("")
	private String jobsId;
	 
	@ApiDemoData(DemoData.CELL_PHONE)
	@ApiDescription("")
	private String cellphone;
	
	
	@ApiDemoData(DemoData.IMAGES)
	@ApiDescription("")
	private String idcardImage1 ;
	
	@ApiDemoData(DemoData.IMAGES)
	@ApiDescription("")
	private String idcardImage2 ;
	
	@ApiDemoData("")
	@ApiDescription("别名")
	private String aliasName;
	
	@ApiDemoData("张三")
	@ApiDescription("")
	private String userName;
	
	@ApiDemoData("43010519820812163X")
	@ApiDescription("身份证")
	private String idCard;
	
	@ApiDemoData("湖北武汉")
	@ApiDescription("户籍地")
	private String currAddress;
	
	@ApiDemoData(DemoData.IMAGE)
	@ApiDescription("用户图标")
	private String img;
	
	@ApiDemoData(DemoData.LOCATION)
	@ApiDescription("经纬度坐标")
	private String position;
	
	@ApiDemoData("1c16eea5-5cdf-3e7f-b197-9a112b66430d")
	@ApiDescription("")
	private String deviceId;
	
	@ApiDemoData("湖北省武汉市洪山区珞瑜东路1037号华中科技大学")
	@ApiDescription("当前居住地")
	private String liveNow;
	
	@ApiDemoData("297")
	@ApiDescription("")
	private String yuntuId;
	
	@ApiDemoData("MJ1111")
	@ApiDescription("")
	private String policemanCode;
	
	@ApiDemoData("52f6fc81f927b7f062a2a687bdd1e514")
	@ApiDescription("")
	private String getuiId;
	
	@ApiDemoData("0")
	@ApiDescription("")
	private Integer score;
 
	@ApiDemoData("1")
	@ApiDescription("0女,1男")
	private Integer sex;  
	
	@ApiDemoData("张三")
	@ApiDescription("")
	private String realname;
	
	@ApiDemoData("backUser")
	@ApiDescription("backUser,foreUser,superAdmin")
	private String type;

	@ApiDemoData("1")
	@ApiDescription("是否在线 0 不在线， 1 在线")
	private Integer isOnline;
	 
	@ApiDemoData(DemoData.ADDRESS)
	@ApiDescription("实名认证注册的地址")
	private String address;
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobsId() {
		return jobsId;
	}

	public void setJobsId(String jobsId) {
		this.jobsId = jobsId;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getIdcardImage1() {
		return idcardImage1;
	}

	public void setIdcardImage1(String idcardImage1) {
		this.idcardImage1 = idcardImage1;
	}

	public String getIdcardImage2() {
		return idcardImage2;
	}

	public void setIdcardImage2(String idcardImage2) {
		this.idcardImage2 = idcardImage2;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCurrAddress() {
		return currAddress;
	}

	public void setCurrAddress(String currAddress) {
		this.currAddress = currAddress;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLiveNow() {
		return liveNow;
	}

	public void setLiveNow(String liveNow) {
		this.liveNow = liveNow;
	}
 
	public String getYuntuId() {
		return yuntuId;
	}

	public void setYuntuId(String yuntuId) {
		this.yuntuId = yuntuId;
	}

	public String getPolicemanCode() {
		return policemanCode;
	}

	public void setPolicemanCode(String policemanCode) {
		this.policemanCode = policemanCode;
	}

	public String getGetuiId() {
		return getuiId;
	}

	public void setGetuiId(String getuiId) {
		this.getuiId = getuiId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setPhone(String phone){
		this.cellphone = phone;
	}
	public String getPhone(){
		return this.cellphone;
	}
	public String getIdcardImg1(){
		return this.idcardImage1;
	}
	public void setIdcardImg1(String idcardImg1) {
        this.idcardImage1 = idcardImg1 == null ? null : idcardImg1.trim();
    }

	public String getIdcardImg2(){
		return this.idcardImage2;
	}
    public void setIdcardImg2(String idcardImg2) {
        this.idcardImage2 = idcardImg2 == null ? null : idcardImg2.trim();
    }

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}
	
}
