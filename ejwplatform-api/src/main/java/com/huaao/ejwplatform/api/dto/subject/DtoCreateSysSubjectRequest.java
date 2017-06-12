package com.huaao.ejwplatform.api.dto.subject;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("新增办事指南类别接口请求参数")
public class DtoCreateSysSubjectRequest extends DtoPublicRequest {

	@ApiDescription("ID")
	@ApiDemoData("74e1b44a82ad44a79e7032dbd8a15857")
	private String id;

	@ApiDescription("栏目名称")
	@NotBlank(message="指南名称不能为空")
	@Length(min=1,max = 30,message="请输入30字以内的标题")
	@ApiDemoData("消防知识")
    private String name;

	@ApiDescription("栏目浓缩图")
	@ApiDemoData("/storage/emulated/0/ejingwu/images/1488855115287.jpg")
    private String image;

	@ApiDescription("排序")
	@ApiDemoData("0")
    private Integer sort;

	@ApiDescription("层级")
	@ApiDemoData("0")
    private Integer level;

	@ApiDescription("所属单位ID")
	@ApiDemoData("4028876d5a652216015a6522ca630000")
    private String deptId;

	@ApiDescription("父栏目ID")
	@ApiDemoData("")
    private String parentId;

	@ApiDescription("是否允许评论 0不允许 1允许")
	@NotNull(message="是否允许评论不能为空")
	@ApiDemoData("0")
    private Integer isComment;

	@ApiDescription("是否需要经过审批 0不审批1审批")
	@ApiDemoData("0")
    private Integer isAudit;

	@ApiDescription("是否启用 0不启用1启用")
	@NotNull(message="是否启用不能为空")
	@ApiDemoData("0")
    private Integer isUseable;
	
	@ApiDescription("共享范围 1社区2街道3区")
	@ApiDemoData("1")
    private String range;

	@ApiDescription("模型编号")
	@ApiDemoData("0")
    private String modelId;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getIsComment() {
		return isComment;
	}

	public void setIsComment(Integer isComment) {
		this.isComment = isComment;
	}

	public Integer getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(Integer isAudit) {
		this.isAudit = isAudit;
	}

	public Integer getIsUseable() {
		return isUseable;
	}

	public void setIsUseable(Integer isUseable) {
		this.isUseable = isUseable;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
}
