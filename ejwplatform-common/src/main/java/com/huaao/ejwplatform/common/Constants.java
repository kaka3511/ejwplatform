package com.huaao.ejwplatform.common;


public class Constants {
	public static final String Version = "1.0";
	
	public static final String MENU_ID = "menuId";
	
	public static final String CURRENT_USER = "user";
    
    public static final String CACHE_MENU_URL = "menuUrlCache";
    
    public static final String CACHE_API_TOKEN = "apiTokenCache";
    
    public static final String CACHE_SOCEKT_CLIENT = "socket_cliten";
    
    public static final String apiUserToken = "token";
    
    public static final String REQUEST_ID = "_reqid";
    
    public static final String ERROR_TRACE = "_errorTrace";
    
    public static final String REQUEST_TIME = "_reqtime";
    
    public static final String CACHE_SMS_CODE = "smsCode";
    
    public static final String userId = "_uid";
    
    public static final Integer API_CODE_SUCCESS = 0;
    
    public static final Integer API_CODE_FAIL = 500;
    
    public final static int ROOTLEVEL = 1;
    
    public final static int formErrorCode = 502;
    
    public final static String formErrorMsg = "表单不合法";
    
    public final static String fieldPrefixSys = "sys_";
    public final static String fieldPrefixCus = "cus_";
    public final static String fieldPrefixClob = "clob_";
    
    
//    public static final Integer API_CODE_TOKEN_INVALID = 501;
    
    public static final Integer API_CODE_TOKEN_INVALID = 10001;
    public static final Integer API_CODE_PERMISSION_DENIED = 10002;
    public static final Integer API_CODE_TOO_MUCH = 10003;
    public static final Integer API_CODE_PARAMS_INVALID = 10004;
    public static final Integer API_CODE_SQL_GRAMMAR = 10005;
    public static final Integer API_CODE_NOT_FOUND = 10404;
    public static final Integer API_CODE_SERVER_ERROR = 10500;
    
    public static final Integer API_CODE_PWD_WRONG = 20001;
    public static final Integer API_CODE_COMMUNITY_NOT_FOUND = 20002;
    public static final Integer API_CODE_PHONE_DUPLICATE = 20003;
    public static final Integer API_CODE_SMS_FAILED = 20004;
    public static final Integer API_CODE_SMS_SEND = 20005;
    public static final Integer API_CODE_SMS_EXPIRED = 20006;
    public static final Integer API_CODE_SMS_WRONG = 20007;
    public static final Integer API_CODE_PWD_INVALID = 20008;
    public static final Integer API_CODE_OLDPWD_INVALID = 20009;
    public static final Integer API_CODE_PWD_DIFF = 20010;
    public static final Integer API_CODE_PHONE_NOTEXSITS = 20011;

    public static final Integer API_CODE_ALERT_INVALID = 20101;
    public static final Integer API_CODE_ALERT_DISPATCH_FAILD = 20102;
    public static final Integer API_CODE_ALERT_RELEASE_FAILED = 20103;

	public static final Integer API_CODE_ALERT_ALREADY_SOLVED = 20104;
	public static final Integer API_CODE_ALERT_ALREADY_HANDOVER = 20105;
	public static final Integer API_CODE_ALERT_ALREADY_DELEGATE = 20106;
	public static final Integer API_CODE_ALERT_ALREADY_BELONG_DEPT = 20107;
	public static final Integer API_CODE_ALERT_ALREADY_APPRAISE = 20108;
    
    public static final Integer API_CODE_APPLY_DUPLICATE = 20201;
    public static final Integer API_CODE_APPLY_UNSUPPORT = 20202;
    
    public static final Integer API_CODE_POINTS_INSUFF = 20301;
    public static final Integer API_CODE_RCODE_WRONG = 20302;
    public static final Integer API_CODE_RCODE_INVALID = 20303;
    public static final Integer API_CODE_RCODE_UNSUPPORT = 20304;
    
    public static final Integer API_CODE_MEETING_NOUSER = 20401;
    public static final Integer API_CODE_MEETING_NORIGHT = 20402;
    public static final Integer API_CODE_MEETING_NOROOM = 20403;
    public static final Integer API_CODE_MEETING_END = 20404;
    public static final Integer API_CODE_MEETING_OFFLINE = 20405;
    
    public static final Integer API_CODE_SDK_INVALID_PARAMS = 90001;
    public static final Integer API_CODE_SDK_NO_RECORDS = 90002;
	public static final Integer API_CODE_SDK_DUPLICATE_RECORD = 90003;
	public static final Integer API_CODE_SDK_WAIT_AUTH = 90004;
	public static final Integer API_CODE_SDK_EXPIRDED = 90005;
	public static final Integer API_CODE_SDK_RE_PRINT = 90006;
	public static final Integer API_CODE_SDK_USE_EMS = 90007;
	public static final Integer API_CODE_SDK_AUTH_FAILED = 90008;
	public static final Integer API_CODE_EMS_INVALID_PARAMS = 90101;
	public static final Integer API_CODE_EMS_NOTEXSITS = 90102;
	public static final Integer API_CODE_EMS_DUPLICATE = 90103;
	public static final Integer API_CODE_EMS_STATE_ERROR = 90104;
	public static final Integer API_CODE_EMS_NO_ADDRESS = 90105;
	public static final Integer API_CODE_EMS_API_ERROR = 90500;
	public static final Integer API_CODE_EMS_HAS_PAY = 90106;
	  
	public static final Integer API_CODE_CRIMINAL_ALREADY_APPRAISE = 30001;
	public static final Integer API_CODE_CRIMINAL_REFUSED_APPRAISE = 30002;
    
    public static final String API_MSG_TOKEN_INVALID = "您的会话已过期，请重新登录";
    public static final String API_MSG_PERMISSION_DENIED = "您没有此操作权限，请联系管理员";
    public static final String API_MSG_TOO_MUCH = "调用次数过于频繁，请稍后重试";
    public static final String API_MSG_PARAMS_INVALID = "请求参数不合法, 请检查";
    public static final String API_MSG_NOT_FOUND = "请求的资源不存在或已被删除";
    public static final String API_MSG_SERVER_ERROR = "请求失败，服务器异常";

    public static final String API_MSG_PWD_WRONG = "登录失败，用户名或密码错误";
    public static final String API_MSG_COMMUNITY_NOT_FOUND = "登录失败，用户所属社区尚未开放";
    public static final String API_MSG_PHONE_DUPLICATE = "该手机号已注册，请重新输入";
    public static final String API_MSG_SMS_FAILED = "验证码发送失败，请稍后重试";
    public static final String API_MSG_SMS_SEND = "验证码已发送，请查看手机";
    public static final String API_MSG_SMS_EXPIRED = "验证码已过期，请重试";
    public static final String API_MSG_SMS_WRONG = "验证码错误，请重新输入";
    public static final String API_MSG_PWD_INVALID = "密码格式错误，必须是6~16为的字母数字或者标点符号的组合";
    public static final String API_MSG_OLDPWD_INVALID = "修改密码失败，原密码错误，请重新输入";
    public static final String API_MSG_PWD_DIFF = "修改密码失败，新密码两次输入不一致，请重新输入";
    public static final String API_MSG_PHONE_NOTEXISTS = "该手机号尚未注册，请重新输入";

    public static final String API_MSG_ALERT_INVALID = "报警类型不正确，请重新输入";
    public static final String API_MSG_ALERT_DISPATCH_FAILD = "委派失败，请联系管理员维护委派对象";
    public static final String API_MSG_ALERT_RELEASE_FAILED = "解场警情失败，该警情已被解除";

    public static final String API_MSG_APPLY_DUPLICATE = "您已经提交过该类申请，请勿重复提交";
    public static final String API_MSG_APPLY_UNSUPPORT = "提交申请失败，此类业务尚未开通";
    public static final String API_MSG_ACTION_DUPLICATE = "您已经提交，请勿重复操作";

    public static final String API_MSG_POINTS_INSUFF = "商品兑换失败，您的积分不足";
    public static final String API_MSG_RCODE_WRONG = "商品兑换失败，兑换码不正确";
    public static final String API_MSG_RCODE_INVALID = "商品兑换失败，兑换码已使用";
    public static final String API_MSG_RCODE_UNSUPPORT = "商品兑换失败，此兑换券不能在本社区使用";

    public static final String API_MSG_MEETING_NOUSER = "发起会议失败，至少需要邀请一个与会人员";
    public static final String API_MSG_MEETING_NORIGHT = "结束会议失败，您没有权限进行此操作";
    public static final String API_MSG_MEETING_NOROOM = "加入会议失败，会议号不存在";
    public static final String API_MSG_MEETING_END = "加入会议失败，会议已结束";
    public static final String API_MSG_MEETING_OFFLINE = "发起呼叫失败，对方不在线";
    
    public static final String API_MSG_SDK_INVALID_PARAMS = "身份证号不能为空，请重新输入";
    public static final String API_MSG_SDK_NO_RECORDS = "未找到该身份证对应的记录证明，请重新输入";
	public static final String API_MSG_SDK_DUPLICATE_RECORD = "数据异常，存在重复记录！";
	public static final String API_MSG_SDK_WAIT_AUTH = "您的申请尚未通过审核，请等待审核通过后再打印";
	public static final String API_MSG_SDK_EXPIRDED = "您的申请超过7天未领取，已失效，请重新申请";
	public static final String API_MSG_SDK_RE_PRINT = "您的申请已经打印过，打印时间";
	public static final String API_MSG_SDK_USE_EMS = "您选择的领取方式是邮政快递，不能自助打印";
	public static final String API_MSG_SDK_AUTH_FAILED = " 您的申请已被驳回，请重新申请";
	public static final String API_MSG_EMS_INVALID_PARAMS = "订单号和运单号不能为空";
	public static final String API_MSG_EMS_NOTEXSITS = "记录不存在，或已被删除，请刷新后重试，谢谢！";
	public static final String API_MSG_EMS_DUPLICATE = "存在重复的运单号";
	public static final String API_MSG_EMS_STATE_ERROR = "您的申请尚未通过审核，暂不能提交快递申请，请耐心等待";
	public static final String API_MSG_EMS_API_ERROR = "EMS接口错误，原因是:";
	public static final String API_MSG_EMS_NO_ADDRESS = "未找到邮寄地址信息，请重新提交申请";
	public static final String API_MSG_EMS_HAS_PAY = "您已经支付过该笔订单，请勿重复提交，谢谢！";
    
    //------------------警察消息通知------------------
    //警情上报通知
    public static final String[] template_report=new String[]{"一键报警","提交了警情"};
    public static final String[] template_note=new String[]{"随手记","提交了警情"};
    public static final String[] template_phone=new String[]{"举报","提交了警情"};
    public static final String[] template_notereply=new String[]{"随手记","您提交的随手记警情已解除。"};
    public static final String[] template_delegate = new String[]{"有一条警情委派给你", "委派了一条警情给你"};
    //咨询服务
    public static final String[] template_consultation=new String[]{"咨询服务","您有一个咨询问题待回复，请查看。"};
    //我要找警，留言
    public static final String[] template_find_police_consultation=new String[]{"留言","提交了留言"};
    //------------------居民消息通知------------------
    //警情解除通知
    public static final String[] template_relieve=new String[]{"一键报警","您的一键报警警情已解除，请查看。"};
    public static final String[] template_solve=new String[]{"警情解除","您的报警警情已解除，请查看。"};
    public static final String[] template_reliphone=new String[]{"举报","您举报的警情已解除"};
    //消息咨询
    public static final String[] template_reply=new String[]{"咨询服务","您的咨询问题已回复，请查看。"};
    public static final String[] template_rlymail=new String[]{"所长信箱","您的所长信箱留言已回复，请查看。"};
    public static final String[] template_police_reply=new String[]{"我要找警","回复了你的提问"};
    //实名认证
    public static final String[] template_audipass=new String[]{"实名认证","您的实名认证审核已通过。"};
    public static final String[] template_audireject=new String[]{"实名认证","您的实名认证审核未通过。"};
    //会议通知
    public static final String[] template_meetingroom = new String[]{"会议通知", "您收到了一个会议邀请。"};
    
    //i学习
    public static final String[] template_ZhengCheXueXi=new String[]{"i学习","您有一条i学习通知，请查看。"};
    //消息通知
    public static final String[] template_XiaoXiTongZhi=new String[]{"消息通知","您有一条消息通知,请查看。"};

    //办事事项列表
    public static final String[] BUSINESS_MATTERS = new String[]{"无犯罪记录证明"};
    
    public static final String[] WORK_ITEMS = new String[]{"无犯罪记录证明", "您的无犯罪记录证明"};
    public static final String[] template_crircd_pass = new String[]{"无犯罪记录证明","无犯罪记录证明审批通过"};
    public static final String[] template_crircd_unpass = new String[]{"无犯罪记录证明","无犯罪记录证明受理未通过"};
    public static final String[] template_crircd_peisong = new String[]{"无犯罪记录证明","无犯罪记录证明配送中"};
    public static final String[] template_crircd_daiziqu = new String[]{"无犯罪记录证明","无犯罪记录证明待自取"};
    public static final String[] template_crircd_shouli = new String[]{"无犯罪记录证明","无犯罪记录证明已受理"};
   
    //办事指南
    public static final String API_MSG_SUBJECT_ALREADY_EXISTS = "已有该事项分类";
    public static final String API_MSG_SUBJECT_HAS_CONTENT = "请确认该分类下无办事事项";

    //网上办事
    public static final String API_MSG_CRIMINAL_ID_INVALID = "网上办事ID不正确";
    public static final String API_MSG_CRIMINAL_ALREADY_APPRAISE = "网上办事已被评价";
    public static final String API_MSG_CRIMINAL_REFUSED_APPRAISE = "未签收或者未确认，暂时还不能评价";
    
    //警情
	public static final String API_MSG_ALERT_ID_INVALID = "警情ID不正确";
	public static final String API_MSG_ALERT_ALREADY_SOLVED = "已解除的警情不能执行该操作";
	public static final String API_MSG_ALERT_ALREADY_HANDOVER = "已移交至其他派出所的警情不能执行该操作";
	public static final String API_MSG_ALERT_ALREADY_DELEGATE = "已委派给其他人员的警情不能执行该操作";
	public static final String API_MSG_ALERT_ALREADY_BELONG_DEPT = "警情已属于该派出所";
	public static final String API_MSG_ALERT_ALREADY_APPRAISE = "警情已被评价";
}
