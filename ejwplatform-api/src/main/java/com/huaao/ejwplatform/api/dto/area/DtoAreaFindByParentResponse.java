package com.huaao.ejwplatform.api.dto.area;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.SysAreaExt;

public class DtoAreaFindByParentResponse {

	@ApiDescription("上级区域ID")
	@ApiDemoData("4028876d5a652216015a6522ca630000")
	private String id;
	
	@ApiDescription("")
	@ApiDemoData("")
	private String name;
	
	@ApiDescription("")
	@ApiDemoData("")
	private String code;
	
	@ApiDescription("")
	@ApiDemoData("")
	private Integer level;
	
	@ApiDescription("")
	@ApiDemoData("")
	private Boolean isLeaf;
	
	@ApiDescription("")
	@ApiDemoData("")
	private String type;

	private DtoAreaFindByParentResponse parent;
	
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	
	public DtoAreaFindByParentResponse getParent() {
		return parent;
	}


	public void setParent(DtoAreaFindByParentResponse parent) {
		this.parent = parent;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
