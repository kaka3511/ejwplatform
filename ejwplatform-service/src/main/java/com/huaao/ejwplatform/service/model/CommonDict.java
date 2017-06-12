package com.huaao.ejwplatform.service.model;

public class CommonDict {

	public static final int AUDIT_TYPE_USERCHECK = 1;
	public static final int AUDIT_TYPE_ALERT = 2;
	public static final int AUDIT_TYPE_CRIMINAL = 3;
	
	//实名认证 0未认证，1资料审核中，2已认证。 
	public static final int AUDIT_STATUS_USER_UNCHECK = 0;
	public static final int AUDIT_STATUS_USER_CHECKING = 1;
	public static final int AUDIT_STATUS_USER_CHECKED = 2;
	
	//警情 : 0-未处理, 1-已完成,2-已委派(选配),3-已协作(选配),4-已上报(选配),5-已删除,6-待评价（已解除）,7-已移交
	public static final int AUDIT_STATUS_ALERT_UNCHECK = 0;
	public static final int AUDIT_STATUS_ALERT_SOLVED = 1;
	public static final int AUDIT_STATUS_ALERT_DELEGATE = 2;
	public static final int AUDIT_STATUS_ALERT_APPRAISE = 6;
	
	/**
	 * 移交警情，在操作日志中记录有用，移交不改变实际状态，移交后任然是未处理.
	 */
	public static final int AUDIT_STATUS_ALERT_HANDOVER = 7;
	
	//网上办事 :0 待受理 ,1 待审批, 2 待确认 3 待自取 4配送中 5未通过6 已签收7 已领取 8 已失效 9 待支付 10-已完成,11-待评价
	public static final int AUDIT_STATUS_CRIMINAL_UNDELEGATE = 0;
	public static final int AUDIT_STATUS_CRIMINAL__UNCHECK= 1;
	public static final int AUDIT_STATUS_CRIMINAL_CONFIRMING = 2;
	public static final int AUDIT_STATUS_CRIMINAL__UNSELFGET = 3;
	public static final int AUDIT_STATUS_CRIMINAL_DISPATCHING = 4;
	public static final int AUDIT_STATUS_CRIMINAL__UNCONFIRM = 5;
	public static final int AUDIT_STATUS_CRIMINAL_SIGNED = 6;
	public static final int AUDIT_STATUS_CRIMINAL__RECEIVED = 7;
	public static final int AUDIT_STATUS_CRIMINAL_INVALID = 8;
	public static final int AUDIT_STATUS_CRIMINAL__PAYING = 9;
	public static final int AUDIT_STATUS_CRIMINAL_SOLVED = 10;
//	public static final int AUDIT_STATUS_CRIMINAL__APPRAISE = 11;

	
	
	public static final String USER_TYPE_SUPER_ADMIN = "superAdmin";
	public static final String USER_TYPE_FORE_USER = "foreUser";
	public static final String USER_TYPE_BACK_USER = "backUser";
	
	public static final String USER_AUTH_AUTHED = "authed";
	public static final String USER_AUTH_NOAUTH = "noAuth";
	public static final String USER_AUTH_AUTHFAIL = "authFail";
	public static final String USER_AUTH_AUTHING = "authing";
	
	public static final String USER_AUTO_FLAG = "1";
	
	public static final String USER_DEFAULT_PASSWORD = "123456";
	
	public static final int DEPT_LEVEL_LOWEST = 6;
	public static final int DEPT_LEVEL_POLICE_STATION = 5;
	
	public static final String REDIS_ALERT_NEWS = "alert_news_set";
	
	public static final String REDIS_ALERT_READ_UID = "alert_read_uid";
	
	public static final String DICE_ALERT_CLASSIFY_DICT = "alertClassifyDict";
	
	//0-未处理,1-已完成(已评价),2-已委派(选配),3-已协作(选配),4-已上报(选配),5-已删除,6-待评价（已解除）
	public static final Integer ALERT_STATUS_UNDO = 0;
	public static final Integer ALERT_STATUS_APPRAISED = 1;
	public static final Integer ALERT_STATUS_DELEGATE = 2;
	public static final Integer ALERT_STATUS_DELETE = 5;
	public static final Integer ALERT_STATUS_DONE = 6;
}
