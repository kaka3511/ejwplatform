package com.huaao.ejwplatform.dao;

import java.io.Serializable;
import java.util.Date;

public class SysMessage implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.type
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.user_id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.title
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.content
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.reply_user_id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private String replyUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.reply_time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Date replyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.reply_content
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private String replyContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.status
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.is_read
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Integer isRead;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.open
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Integer open;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.update_time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_message.classify
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private Integer classify;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_message
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.id
     *
     * @return the value of sys_message.id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.id
     *
     * @param id the value for sys_message.id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.type
     *
     * @return the value of sys_message.type
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.type
     *
     * @param type the value for sys_message.type
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.user_id
     *
     * @return the value of sys_message.user_id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.user_id
     *
     * @param userId the value for sys_message.user_id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.time
     *
     * @return the value of sys_message.time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.time
     *
     * @param time the value for sys_message.time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.title
     *
     * @return the value of sys_message.title
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.title
     *
     * @param title the value for sys_message.title
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.content
     *
     * @return the value of sys_message.content
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.content
     *
     * @param content the value for sys_message.content
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.reply_user_id
     *
     * @return the value of sys_message.reply_user_id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public String getReplyUserId() {
        return replyUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.reply_user_id
     *
     * @param replyUserId the value for sys_message.reply_user_id
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId == null ? null : replyUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.reply_time
     *
     * @return the value of sys_message.reply_time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.reply_time
     *
     * @param replyTime the value for sys_message.reply_time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.reply_content
     *
     * @return the value of sys_message.reply_content
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.reply_content
     *
     * @param replyContent the value for sys_message.reply_content
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.status
     *
     * @return the value of sys_message.status
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.status
     *
     * @param status the value for sys_message.status
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.is_read
     *
     * @return the value of sys_message.is_read
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.is_read
     *
     * @param isRead the value for sys_message.is_read
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.open
     *
     * @return the value of sys_message.open
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Integer getOpen() {
        return open;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.open
     *
     * @param open the value for sys_message.open
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setOpen(Integer open) {
        this.open = open;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.update_time
     *
     * @return the value of sys_message.update_time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.update_time
     *
     * @param updateTime the value for sys_message.update_time
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_message.classify
     *
     * @return the value of sys_message.classify
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public Integer getClassify() {
        return classify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_message.classify
     *
     * @param classify the value for sys_message.classify
     *
     * @mbggenerated Tue May 16 10:26:22 CST 2017
     */
    public void setClassify(Integer classify) {
        this.classify = classify;
    }
}