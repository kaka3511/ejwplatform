package com.huaao.ejwplatform.api.dto.content;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("新增栏目内容接口请求参数")
public class DtoCreateJWContentRequest extends DtoPublicRequest{
	
	@ApiDescription("栏目内容ID")
	@ApiDemoData("004507ae57734964b7187a996f117e42")
	private String id;

	@ApiDescription("栏目内容标题")
	@NotBlank(message="标题不能为空")
	@Length(min=1,max = 30,message="请输入30字以内的标题")
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
	@NotBlank(message="指南类别ID不能为空")
	@ApiDemoData("74e1b44a82ad44a79e7032dbd8a15857")
    private String subjectId;

	@ApiDescription("内容描述")
	@NotBlank(message="内容不能为空")
	@ApiDemoData("消防小知识：火灾逃生自救十二招 1.逃生预演，临危不乱")
    private String content;
	
	@ApiDescription("直接发布 0：新增  1：直接发布")
	@ApiDemoData("0")
	private String directPublish;
	
	@ApiDescription("信息类别编号用逗号分隔")
	private String infoType;

	public String getDirectPublish() {
		return directPublish;
	}

	public void setDirectPublish(String directPublish) {
		this.directPublish = directPublish;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	
}
