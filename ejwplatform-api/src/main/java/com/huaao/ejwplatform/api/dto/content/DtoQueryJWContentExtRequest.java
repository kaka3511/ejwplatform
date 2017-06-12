package com.huaao.ejwplatform.api.dto.content;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("查询办事指南某类信息列表接口请求参数类")
public class DtoQueryJWContentExtRequest extends DtoPublicRequestPager {

	@ApiDescription("栏目类别ID")
	@ApiDemoData("004507ae57734964b7187a996f117e42")
	private String sysSubjectId;

	@ApiDescription("模糊查询关键词")
	@ApiDemoData("消防知识")
	private String keyword;

	@ApiDescription("发布状态 1待发布 ，2未审批 ，3已发布， 4已撤销 ，  6查询包含1,2和4的状态 不输入查所有")
	@ApiDemoData("1")
	private Integer status;
	
	@ApiDescription("信息类别编号用逗号分隔。1警情通报 2协查通报 3社区动态 4办事指南 5防范小贴士 6消息通知  7热点新闻 8i学习 9知识库")
	@ApiDemoData("1,2,3,5")
	@NotBlank(message="信息类别不能为空")
	private String infoType;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSysSubjectId() {
		return sysSubjectId;
	}

	public void setSysSubjectId(String sysSubjectId) {
		this.sysSubjectId = sysSubjectId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	
}
