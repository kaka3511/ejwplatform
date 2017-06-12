package com.huaao.ejwplatform.dao;

import java.io.Serializable;
import java.util.Date;

public class JwElectricity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.electricity_no
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String electricityNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.user_name
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.telphone
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String telphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.address
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.consumption
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private Integer consumption;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.year
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String year;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.month
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String month;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.creator_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.create_time
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.updater_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String updaterId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.update_time
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.dept_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private String deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_electricity.order_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private Integer orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jw_electricity
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.id
     *
     * @return the value of jw_electricity.id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.id
     *
     * @param id the value for jw_electricity.id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.electricity_no
     *
     * @return the value of jw_electricity.electricity_no
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getElectricityNo() {
        return electricityNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.electricity_no
     *
     * @param electricityNo the value for jw_electricity.electricity_no
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setElectricityNo(String electricityNo) {
        this.electricityNo = electricityNo == null ? null : electricityNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.user_name
     *
     * @return the value of jw_electricity.user_name
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.user_name
     *
     * @param userName the value for jw_electricity.user_name
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.telphone
     *
     * @return the value of jw_electricity.telphone
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.telphone
     *
     * @param telphone the value for jw_electricity.telphone
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.address
     *
     * @return the value of jw_electricity.address
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.address
     *
     * @param address the value for jw_electricity.address
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.consumption
     *
     * @return the value of jw_electricity.consumption
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public Integer getConsumption() {
        return consumption;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.consumption
     *
     * @param consumption the value for jw_electricity.consumption
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.year
     *
     * @return the value of jw_electricity.year
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.year
     *
     * @param year the value for jw_electricity.year
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.month
     *
     * @return the value of jw_electricity.month
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getMonth() {
        return month;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.month
     *
     * @param month the value for jw_electricity.month
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.creator_id
     *
     * @return the value of jw_electricity.creator_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.creator_id
     *
     * @param creatorId the value for jw_electricity.creator_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.create_time
     *
     * @return the value of jw_electricity.create_time
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.create_time
     *
     * @param createTime the value for jw_electricity.create_time
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.updater_id
     *
     * @return the value of jw_electricity.updater_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getUpdaterId() {
        return updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.updater_id
     *
     * @param updaterId the value for jw_electricity.updater_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId == null ? null : updaterId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.update_time
     *
     * @return the value of jw_electricity.update_time
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.update_time
     *
     * @param updateTime the value for jw_electricity.update_time
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.dept_id
     *
     * @return the value of jw_electricity.dept_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.dept_id
     *
     * @param deptId the value for jw_electricity.dept_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_electricity.order_id
     *
     * @return the value of jw_electricity.order_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_electricity.order_id
     *
     * @param orderId the value for jw_electricity.order_id
     *
     * @mbggenerated Thu May 25 14:10:31 CST 2017
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}