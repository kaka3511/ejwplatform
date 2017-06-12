package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DictBean {
	
		@ApiDescription("名称")
	    private String name;
		
		@ApiDescription("编码")
	    private String code;
		
		@ApiDescription("父级节点")
	    private String parentId;
		
		@ApiDescription("排序字段")
		@ApiDemoData("1")
		private Integer sort;


	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code == null ? null : code.trim();
	    }

	    public String getParentId() {
	        return parentId;
	    }

	    public void setParentId(String parentId) {
	        this.parentId = parentId == null ? null : parentId.trim();
	    }

		public Integer getSort() {
			return sort;
		}

		public void setSort(Integer sort) {
			this.sort = sort;
		}
}
