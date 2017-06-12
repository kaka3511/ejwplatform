package com.huaao.ejwplatform.dao;

import com.huaao.ejwplatform.dao.SysMessage;

public class SysMessageExt extends SysMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName; //咨询人昵称
	
	private String realName; //咨询人姓名
	
	private String userImg;//咨询人头像
	
	private String replyUserName;//回复人昵称
	
	private String replyRealName;//回复人姓名
	
	private String replyUserImg;//回复人头像
	
	private String phone; //来信人电话
	
	private String deptCode;
	
	private String replyUserJobName;
	

	public String getReplyUserJobName() {
		return replyUserJobName;
	}

	public void setReplyUserJobName(String replyUserJobName) {
		this.replyUserJobName = replyUserJobName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public String getReplyRealName() {
		return replyRealName;
	}

	public void setReplyRealName(String replyRealName) {
		this.replyRealName = replyRealName;
	}

	public String getReplyUserImg() {
		return replyUserImg;
	}

	public void setReplyUserImg(String replyUserImg) {
		this.replyUserImg = replyUserImg;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

}
