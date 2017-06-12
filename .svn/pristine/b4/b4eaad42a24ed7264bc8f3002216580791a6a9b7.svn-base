package com.huaao.ejwplatform.service.model;

import com.huaao.ejwplatform.dao.SysJobs;
import com.huaao.ejwplatform.dao.SysUser;

public class DtoUserInfoResponse{
	
	private String id;//用户id
	
    private String cardcode;//身份证
    
    private String cardImg1;//图片1
    
    private String cardImg2;//图片2
    
    private String auth;//认证状态
    
    private String realname;//用户昵称
    
    private String username;//用户名
    
    private String phone;//手机号
    
    private String email;//邮箱
    
    private String address;//地址
    
    private String salt;//预留
    
    private String score;//积分
    
    private boolean useable;//预留
    
    private String type;//认证类型
    
    private String stype;//预留
    
    private String authMsg;//审核意见
    
    private String authingTime;//提交认证的时间
    
    private String auditedTime;//认证后台被操作的时间(通过/驳回)
    
    private String currAddress;//地址
    
    private String img;//头像
    
    private String position;//位置
    
    private String deviceID;//设备标识
    
    private String liveNow;//现在居住地？
    
    private String rlyCode;//预留容联云
    
    private String ytCode;//云图ID
    
    private String policemanCode;//警号
    
    private String gtCode;//个推ID
    
    private long lastLoginTime;//最后一次登录时间
    
    private boolean online;//是否在线
    
    private String fullAddr; //所在区域全名

    private SysJobs jobs;
	
	private DtoDeptResponse dept;

	public DtoUserInfoResponse() {
		super();
	}
	
	public DtoUserInfoResponse(SysUser user){
		this.setAddress(user.getAddress());
		this.setAuditedTime(user.getAuditedTime() != null ? user.getAuditedTime()+"":"");
		this.setAuth(user.getAuth());
		this.setAuthingTime(user.getAuthingTime() != null ? user.getAuthingTime().getTime()+"":"");
		this.setAuthMsg(user.getAuthMsg());
		this.setCardcode(user.getIdCard());
		this.setCardImg1(user.getIdcardImg1());
		this.setCardImg2(user.getIdcardImg2());
		this.setCurrAddress(user.getCurrAddress());
		this.setDeviceID(user.getDeviceId());
		this.setEmail(user.getEmail());
		this.setGtCode(user.getGtCode());
		this.setId(user.getId());
		this.setImg(user.getImg());
		this.setLastLoginTime(user.getLastLoginTime() == null ? 0 : user.getLastLoginTime().getTime());
		this.setLiveNow(user.getLiveNow());
		if(user.getIsOnline() != null && user.getIsOnline().intValue() == 1){
			this.setOnline(true);
		}else{
			this.setOnline(false);
		}
		this.setPhone(user.getPhone());
		this.setPolicemanCode(user.getPolicemanCode());
		this.setPosition(user.getPosition());
		this.setRealname(user.getRealname());
		this.setRlyCode(user.getRlyCode());
		this.setSalt(user.getSalt());
		this.setScore(user.getScore() != null ? user.getScore().intValue()+"":"");
		this.setStype(user.getType());
		if(user.getIsUseable() != null && user.getIsUseable().intValue() == 1){
			this.setUseable(true);
		}else{
			this.setUseable(false);
		}
		this.setType(user.getType());
		this.setUsername(user.getUserName());
		this.setYtCode(user.getYtCode());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public String getCardImg1() {
		return cardImg1;
	}

	public void setCardImg1(String cardImg1) {
		this.cardImg1 = cardImg1;
	}

	public String getCardImg2() {
		return cardImg2;
	}

	public void setCardImg2(String cardImg2) {
		this.cardImg2 = cardImg2;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public boolean isUseable() {
		return useable;
	}

	public void setUseable(boolean useable) {
		this.useable = useable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getAuthMsg() {
		return authMsg;
	}

	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}

	public String getAuthingTime() {
		return authingTime;
	}

	public void setAuthingTime(String authingTime) {
		this.authingTime = authingTime;
	}

	public String getAuditedTime() {
		return auditedTime;
	}

	public void setAuditedTime(String auditedTime) {
		this.auditedTime = auditedTime;
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

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getLiveNow() {
		return liveNow;
	}

	public void setLiveNow(String liveNow) {
		this.liveNow = liveNow;
	}

	public String getRlyCode() {
		return rlyCode;
	}

	public void setRlyCode(String rlyCode) {
		this.rlyCode = rlyCode;
	}

	public String getYtCode() {
		return ytCode;
	}

	public void setYtCode(String ytCode) {
		this.ytCode = ytCode;
	}

	public String getPolicemanCode() {
		return policemanCode;
	}

	public void setPolicemanCode(String policemanCode) {
		this.policemanCode = policemanCode;
	}

	public String getGtCode() {
		return gtCode;
	}

	public void setGtCode(String gtCode) {
		this.gtCode = gtCode;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public boolean isOnline() {
		return online;
	}

	public String getFullAddr() {
		return fullAddr;
	}

	public void setFullAddr(String fullAddr) {
		this.fullAddr = fullAddr;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public SysJobs getJobs() {
		return jobs;
	}

	public void setJobs(SysJobs jobs) {
		this.jobs = jobs;
	}

	public DtoDeptResponse getDept() {
		return dept;
	}

	public void setDept(DtoDeptResponse dept) {
		this.dept = dept;
	}
}
