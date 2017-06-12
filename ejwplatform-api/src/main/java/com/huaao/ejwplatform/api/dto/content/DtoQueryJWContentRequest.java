package com.huaao.ejwplatform.api.dto.content;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("查询办事指南某类信息列表接口请求参数类")
public class DtoQueryJWContentRequest extends DtoPublicRequestPager {

	@ApiDescription("栏目类别ID")
	/*@NotBlank(message="指南类别ID不能为空")*/
	@ApiDemoData("004507ae57734964b7187a996f117e42")
	private String sysSubjectId;

	@ApiDescription("模糊查询关键词")
	@ApiDemoData("消防知识")
	private String keyword;

	@ApiDescription("发布状态 1待发布 ，2未审批 ，3已发布， 4已撤销 ， 6查询包含1,2和4的状态 不输入查所有")
	@ApiDemoData("1")
	private Integer status;
	
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
}
