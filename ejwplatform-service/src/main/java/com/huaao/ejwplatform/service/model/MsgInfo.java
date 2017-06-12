package com.huaao.ejwplatform.service.model;

import java.util.Date;

public class MsgInfo extends AbstractJsonModel{

	private static final long serialVersionUID = -889436118126441477L;
	
	
	public String id;
	public Integer type;
	public String userId;
	public Date time;
	public String title;
	public String content;
	public String replyUserId;
	public Date replyTime;
	public String replyContent;
	public Integer status;
	public String userName;
	public String realName;
	public String userImg;
	public String replyUserName;
	public String replyRealName;
	public String replyUserImg;
	public String phone;
	public Integer isRead;
	public Integer open;
    public Integer classify;
    public String classifyName;
	
}
