package com.huaao.ejwplatform.dao;

import java.io.Serializable;
import java.util.Date;

public class JwEntity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.type
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.entity_name
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String entityName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.address
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.location
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String location;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.telphone
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String telphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.liab_policy
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String liabPolicy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.imgs
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String imgs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.description
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.dept_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.creator_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.create_time
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.updater_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String updaterId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.update_time
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_entity.location_gd
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private String locationGd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jw_entity
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.id
     *
     * @return the value of jw_entity.id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.id
     *
     * @param id the value for jw_entity.id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.type
     *
     * @return the value of jw_entity.type
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.type
     *
     * @param type the value for jw_entity.type
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.entity_name
     *
     * @return the value of jw_entity.entity_name
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.entity_name
     *
     * @param entityName the value for jw_entity.entity_name
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName == null ? null : entityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.address
     *
     * @return the value of jw_entity.address
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.address
     *
     * @param address the value for jw_entity.address
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.location
     *
     * @return the value of jw_entity.location
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.location
     *
     * @param location the value for jw_entity.location
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.telphone
     *
     * @return the value of jw_entity.telphone
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.telphone
     *
     * @param telphone the value for jw_entity.telphone
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.liab_policy
     *
     * @return the value of jw_entity.liab_policy
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getLiabPolicy() {
        return liabPolicy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.liab_policy
     *
     * @param liabPolicy the value for jw_entity.liab_policy
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setLiabPolicy(String liabPolicy) {
        this.liabPolicy = liabPolicy == null ? null : liabPolicy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.imgs
     *
     * @return the value of jw_entity.imgs
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.imgs
     *
     * @param imgs the value for jw_entity.imgs
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.description
     *
     * @return the value of jw_entity.description
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.description
     *
     * @param description the value for jw_entity.description
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.dept_id
     *
     * @return the value of jw_entity.dept_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.dept_id
     *
     * @param deptId the value for jw_entity.dept_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.creator_id
     *
     * @return the value of jw_entity.creator_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.creator_id
     *
     * @param creatorId the value for jw_entity.creator_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.create_time
     *
     * @return the value of jw_entity.create_time
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.create_time
     *
     * @param createTime the value for jw_entity.create_time
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.updater_id
     *
     * @return the value of jw_entity.updater_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getUpdaterId() {
        return updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.updater_id
     *
     * @param updaterId the value for jw_entity.updater_id
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId == null ? null : updaterId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.update_time
     *
     * @return the value of jw_entity.update_time
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.update_time
     *
     * @param updateTime the value for jw_entity.update_time
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_entity.location_gd
     *
     * @return the value of jw_entity.location_gd
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public String getLocationGd() {
        return locationGd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_entity.location_gd
     *
     * @param locationGd the value for jw_entity.location_gd
     *
     * @mbggenerated Wed May 24 11:30:10 CST 2017
     */
    public void setLocationGd(String locationGd) {
        this.locationGd = locationGd == null ? null : locationGd.trim();
    }
}