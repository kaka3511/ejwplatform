package com.huaao.ejwplatform.api.dto.bean;

import java.util.Date;


import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindByIdResponse;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.SysMessageAppraise;

public class Message {


	@ApiDescription("消息id")
	@ApiDemoData("097f2f9ec7544e3da71ba6c87c72c028")
	private String id;
	
	@ApiDescription("留言类型 1居民咨询 2所长信箱")
	@ApiDemoData("2")
    private Integer type;
	
	@ApiDescription("咨询人id")
	@ApiDemoData("8a2b2a045aa1876f015aa2b4f14e0003")
    private String userId;
	
	@ApiDescription("咨询时间")
	@ApiDemoData("1488806417000")
    private Date time;
	
	@ApiDescription("咨询时间")
    private String timeStr;
	
	@ApiDescription("咨询标题")
	@ApiDemoData("咨询标题")
    private String title;
	
	@ApiDescription("咨询内容")
	@ApiDemoData("咨询内容")
    private String content;
	
	@ApiDescription("回复人id")
	@ApiDemoData("8a2b2a045a9d1b00015aa12f51660056")
    private String replyUserId;
	
	@ApiDescription("回复时间")
	@ApiDemoData("1488809173000")
    private Date replyTime;
	
	@ApiDescription("回复内容")
	@ApiDemoData("回复内容")
    private String replyContent;
	
	@ApiDescription("回复状态 0已屏蔽 1已回复 2未回复 3已评价")
	@ApiDemoData("1")
    private Integer status;
	
	@ApiDescription("咨询人昵称")
	@ApiDemoData("咨询人昵称")
	private String userName;
	
	@ApiDescription("咨询人姓名")
	@ApiDemoData("咨询人姓名")
	private String realName;
	
	@ApiDescription("咨询人头像")
	@ApiDemoData("http://xxx.jpg")
	private String userImg;
	
	@ApiDescription("回复人昵称")
	@ApiDemoData("回复人昵称")
	private String replyUserName;
	
	@ApiDescription("回复人姓名")
	@ApiDemoData("回复人姓名")
	private String replyRealName;
	
	@ApiDescription("回复人头像")
	@ApiDemoData("http://xxx.jpg")
	private String replyUserImg;
	
	@ApiDescription("来信人联系电话")
	@ApiDemoData("13000000000")
	private String phone;
	
	@ApiDescription("消息是否已读0未读1已读")
	@ApiDemoData("1")
	private Integer isRead; 
	
	@ApiDescription("0不公开 1公开")
	@ApiDemoData("0")
	private Integer open;
	
	@ApiDescription("回复人职务")
	@ApiDemoData("社区民警")
	private String replyUserJobName;
	
	@ApiDescription("警务室")
	private DtoDeptFindByIdResponse dept;
	
	@ApiDescription("")
	private String updateTimeStr;
	
	private Date updateTime;

	@ApiDescription("评价信息")
	private MessageAppraiseInfo appraise;
	
	@ApiDescription("咨询服务类别classify。1，户政类2，交管类3，证明类4，出入境5，其他")
	private Integer classify;
	
	@ApiDescription("咨询服务类别名称classifyName。1，户政类2，交管类3，证明类4，出入境5，其他")
	private String classifyName;
	
	@ApiDescription("所属类别")
	@ApiDemoData("")
    private String category;
	
	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public MessageAppraiseInfo getAppraise() {
		return appraise;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

	public void setAppraise(MessageAppraiseInfo appraise) {
		this.appraise = appraise;
	}

	public String getReplyUserJobName() {
		return replyUserJobName;
	}

	public void setReplyUserJobName(String replyUserJobName) {
		this.replyUserJobName = replyUserJobName;
	}

	public DtoDeptFindByIdResponse getDept() {
		return dept;
	}

	public void setDept(DtoDeptFindByIdResponse dept) {
		this.dept = dept;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		switch (type) {
		case 1:
			category = "consultation";
			break;
		case 2:
			category = "mailbox";
			break;
		default:
			break;
		}
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.timeStr = DateTool.formatDateTime(time);
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getReplyRealName() {
		return replyRealName;
	}

	public void setReplyRealName(String replyRealName) {
		this.replyRealName = replyRealName;
	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTime) {
		this.updateTimeStr = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTimeStr = DateTool.formatDateTime(updateTime);
		this.updateTime = updateTime;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;

	}
}
