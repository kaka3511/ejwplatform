package com.huaao.ejwplatform.api.dto.content;

import javax.validation.constraints.NotNull;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoModifyJWContentRequest extends DtoPublicRequest{

	@ApiDescription("栏目内容ID")
	@ApiDemoData("004507ae57734964b7187a996f117e42")
	private String id;

	@ApiDescription("栏目内容标题")
	@ApiDemoData("消防知识")
    private String title;

	@ApiDescription("摘要")
	@ApiDemoData("消防小知识：火灾逃生自救十二招")
    private String summary;

	@ApiDescription("摘要浓缩图")
	@ApiDemoData("/storage/emulated/0/ejingwu/images/1488855115287.jpg")
    private String summaryImg;

	@ApiDescription("状态")
	@ApiDemoData("1")
    private Integer status;

	@ApiDescription("阅读数")
	@ApiDemoData("0")
    private Integer readnum;

	@ApiDescription("点赞数")
	@ApiDemoData("0")
    private Integer likenum;

	@ApiDescription("栏目ID")
	@ApiDemoData("74e1b44a82ad44a79e7032dbd8a15857")
    private String subjectId;

	@ApiDescription("内容描述")
	@ApiDemoData("消防小知识：火灾逃生自救十二招 1.逃生预演，临危不乱")
    private String content;
	
	@ApiDescription("直接发布 0：新增  1：直接发布")
	@ApiDemoData("0")
	private String directPublish;
	
	@ApiDescription("信息类别编号, 1警情通报 2协查通报 3社区动态 4办事指南 5防范小贴士 6消息通知  7热点新闻 8i学习 9知识库")
	@ApiDemoData("1")
	@NotNull(message="信息类型不能为空")
	private Integer infoType;

	@ApiDescription("小区ID逗号分隔")
	private String communityIds;

	@ApiDescription("是否置顶 0不置顶 1置顶")
	@ApiDemoData("0")
	private Integer isTop;
	
	@ApiDescription("置顶天数")
	@ApiDemoData("10")
	private Integer uptopDays;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUptopDays() {
		return uptopDays;
	}

	public void setUptopDays(Integer uptopDays) {
		this.uptopDays = uptopDays;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummaryImg() {
		return summaryImg;
	}

	public void setSummaryImg(String summaryImg) {
		this.summaryImg = summaryImg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getReadnum() {
		return readnum;
	}

	public void setReadnum(Integer readnum) {
		this.readnum = readnum;
	}

	public Integer getLikenum() {
		return likenum;
	}

	public void setLikenum(Integer likenum) {
		this.likenum = likenum;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDirectPublish() {
		return directPublish;
	}

	public void setDirectPublish(String directPublish) {
		this.directPublish = directPublish;
	}

	public Integer getInfoType() {
		return infoType;
	}

	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

	public String getCommunityIds() {
		return communityIds;
	}

	public void setCommunityIds(String communityIds) {
		this.communityIds = communityIds;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
}
