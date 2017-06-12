package com.huaao.ejwplatform.api.dto.content;

import java.util.Date;
import java.util.List;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwLearnRecordExt;
import com.huaao.ejwplatform.dao.SysDeptExt;

@ApiDescription("栏目查询响应参数类")
public class DtoQueryJWContentExtResponse extends DtoQueryJWContentResponse {
	@ApiDescription("信息类型,1警情通报 2协查通报 3社区动态 4办事指南 5防范小贴士 6消息通知  7热点新闻 8i学习 9知识库")
	@ApiDemoData("1")
	private Integer infoType;

	@ApiDescription("置顶时间")
	@ApiDemoData("1488600442000")
	private Date uptopTime;

	@ApiDescription("置顶天数")
	@ApiDemoData("10")
	private Integer uptopDays;

	@ApiDescription("置顶人ID")
	@ApiDemoData("4028876d5a464e38015a464ee85e0000")
	private String uptopId;
	
	@ApiDescription("置顶人")
	@ApiDemoData("张某某")
	private String uptopName;
	
	@ApiDescription("信息类型名称")
	@ApiDemoData("警情通报")
	private String infoTypeName;
	
	@ApiDescription("消息发送状态 0失败 1成功")
	@ApiDemoData("1")
	private Integer msgStatus;
	
	@ApiDescription("内容链接")
	@ApiDemoData("http://www.huaaotech.tech/api/html/getContent.do?id=xxx")
	private String link;
	
	@ApiDescription("更新人所在单位名称")
	@ApiDemoData("金地社区")
	private String updaterDeptName;
	
	private List<SysDeptExt> dept;
	
	@ApiDescription("已阅读人员列表")
    private List<JwLearnRecordExt> learn;
    
    @ApiDescription("发布范围内的总人数")
	@ApiDemoData("20")
    private Integer total;
    
    @ApiDescription("当前用户是否已阅读  1已读 0 未读")
	@ApiDemoData("1")
    private Integer currentUserRead;
    
    @ApiDescription("已阅读的人数")
   	@ApiDemoData("10")
    private Integer alreadyRead;
    
    @ApiDescription("办事指南对应的网上办事事项    默认0 1：无犯罪记录")
	@ApiDemoData("0")
	private Integer code;
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
    
    
	public Integer getAlreadyRead() {
		if(learn == null){
			setAlreadyRead(0);
		}else{
			setAlreadyRead(learn.size());
		}
		return this.alreadyRead;
	}

	public void setAlreadyRead(Integer alreadyRead) {
		this.alreadyRead = alreadyRead;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getCurrentUserRead() {
		return currentUserRead;
	}

	public void setCurrentUserRead(Integer currentUserRead) {
		this.currentUserRead = currentUserRead;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<JwLearnRecordExt> getLearn() {
		return learn;
	}

	public void setLearn(List<JwLearnRecordExt> learn) {
		this.learn = learn;
	}
	
	public String getUpdaterDeptName() {
		return updaterDeptName;
	}

	public void setUpdaterDeptName(String updaterDeptName) {
		this.updaterDeptName = updaterDeptName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<SysDeptExt> getDept() {
		return dept;
	}

	public void setDept(List<SysDeptExt> dept) {
		this.dept = dept;
	}

	public String getUptopName() {
		return uptopName;
	}

	public void setUptopName(String uptopName) {
		this.uptopName = uptopName;
	}

	public Integer getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}

	public String getInfoTypeName() {
		return infoTypeName;
	}

	public void setInfoTypeName(String infoTypeName) {
		this.infoTypeName = infoTypeName;
	}

	public Integer getInfoType() {
		return infoType;
	}

	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

	public Date getUptopTime() {
		return uptopTime;
	}

	public void setUptopTime(Date uptopTime) {
		this.uptopTime = uptopTime;
	}

	public Integer getUptopDays() {
		return uptopDays;
	}

	public void setUptopDays(Integer uptopDays) {
		this.uptopDays = uptopDays;
	}

	public String getUptopId() {
		return uptopId;
	}

	public void setUptopId(String uptopId) {
		this.uptopId = uptopId;
	}
}
