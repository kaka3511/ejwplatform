package com.huaao.ejwplatform.dao;

import java.io.Serializable;
import java.util.Date;

public class JwBusinessDept implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.dept_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private String deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.user_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.type
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.creator_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private String creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.create_time
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.updater_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private String updaterId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.update_time
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jw_business_dept.code
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jw_business_dept
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.id
     *
     * @return the value of jw_business_dept.id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.id
     *
     * @param id the value for jw_business_dept.id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.dept_id
     *
     * @return the value of jw_business_dept.dept_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.dept_id
     *
     * @param deptId the value for jw_business_dept.dept_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.user_id
     *
     * @return the value of jw_business_dept.user_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.user_id
     *
     * @param userId the value for jw_business_dept.user_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.type
     *
     * @return the value of jw_business_dept.type
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.type
     *
     * @param type the value for jw_business_dept.type
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.creator_id
     *
     * @return the value of jw_business_dept.creator_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.creator_id
     *
     * @param creatorId the value for jw_business_dept.creator_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.create_time
     *
     * @return the value of jw_business_dept.create_time
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.create_time
     *
     * @param createTime the value for jw_business_dept.create_time
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.updater_id
     *
     * @return the value of jw_business_dept.updater_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public String getUpdaterId() {
        return updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.updater_id
     *
     * @param updaterId the value for jw_business_dept.updater_id
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId == null ? null : updaterId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.update_time
     *
     * @return the value of jw_business_dept.update_time
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.update_time
     *
     * @param updateTime the value for jw_business_dept.update_time
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jw_business_dept.code
     *
     * @return the value of jw_business_dept.code
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jw_business_dept.code
     *
     * @param code the value for jw_business_dept.code
     *
     * @mbggenerated Tue Apr 25 17:53:00 CST 2017
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}