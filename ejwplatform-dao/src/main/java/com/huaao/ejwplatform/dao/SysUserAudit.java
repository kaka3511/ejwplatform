package com.huaao.ejwplatform.dao;

import java.io.Serializable;
import java.util.Date;

public class SysUserAudit implements Serializable {
    private String id;

    private String userId;

    private String deptId;

    private String jobsId;

    private String type;

    private String email;

    private String phone;

    private String realname;

    private String userName;

    private Integer sex;

    private String img;

    private String currAddress;

    private String address;

    private String liveNow;

    private String policemanCode;

    private String idCard;

    private String idcardImg1;

    private String idcardImg2;

    private Integer version;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getJobsId() {
        return jobsId;
    }

    public void setJobsId(String jobsId) {
        this.jobsId = jobsId == null ? null : jobsId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getCurrAddress() {
        return currAddress;
    }

    public void setCurrAddress(String currAddress) {
        this.currAddress = currAddress == null ? null : currAddress.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLiveNow() {
        return liveNow;
    }

    public void setLiveNow(String liveNow) {
        this.liveNow = liveNow == null ? null : liveNow.trim();
    }

    public String getPolicemanCode() {
        return policemanCode;
    }

    public void setPolicemanCode(String policemanCode) {
        this.policemanCode = policemanCode == null ? null : policemanCode.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdcardImg1() {
        return idcardImg1;
    }

    public void setIdcardImg1(String idcardImg1) {
        this.idcardImg1 = idcardImg1 == null ? null : idcardImg1.trim();
    }

    public String getIdcardImg2() {
        return idcardImg2;
    }

    public void setIdcardImg2(String idcardImg2) {
        this.idcardImg2 = idcardImg2 == null ? null : idcardImg2.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}