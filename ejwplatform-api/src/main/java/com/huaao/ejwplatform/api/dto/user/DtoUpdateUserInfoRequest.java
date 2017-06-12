package com.huaao.ejwplatform.api.dto.user;

import javax.validation.constraints.NotNull;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;

public class DtoUpdateUserInfoRequest extends DtoPublicRequest{

	@NotNull
	private String id;

    private String deptId;

    private String email;

    private String jobsId;

    private String realname;

    private String userName;

    private String idCard;

    private String type;

    private String salt;

    private String curraddress;

    private String img;

    private String position;

    private String deviceid;

    private String liveNow;

    private String rlycode;

    private String ytcode;

    private String policemancode;

    private String gtCode;

    private Integer score;

    private Integer sex;

    private String idcardImg1;

    private String idcardImg2;

    private String auth;

    private Integer status;
    
    private String deviceToken;

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

	 
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCurraddress() {
		return curraddress;
	}

	public void setCurraddress(String curraddress) {
		this.curraddress = curraddress;
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

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getLiveNow() {
		return liveNow;
	}

	public void setLiveNow(String liveNow) {
		this.liveNow = liveNow;
	}

	public String getRlycode() {
		return rlycode;
	}

	public void setRlycode(String rlycode) {
		this.rlycode = rlycode;
	}

	public String getYtcode() {
		return ytcode;
	}

	public void setYtcode(String ytcode) {
		this.ytcode = ytcode;
	}

	public String getPolicemancode() {
		return policemancode;
	}

	public void setPolicemancode(String policemancode) {
		this.policemancode = policemancode;
	}

	public String getGtCode() {
		return gtCode;
	}

	public void setGtCode(String gtCode) {
		this.gtCode = gtCode;
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

	public String getIdcardImg1() {
		return idcardImg1;
	}

	public void setIdcardImg1(String idcardImg1) {
		this.idcardImg1 = idcardImg1;
	}

	public String getIdcardImg2() {
		return idcardImg2;
	}

	public void setIdcardImg2(String idcardImg2) {
		this.idcardImg2 = idcardImg2;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
    
}
