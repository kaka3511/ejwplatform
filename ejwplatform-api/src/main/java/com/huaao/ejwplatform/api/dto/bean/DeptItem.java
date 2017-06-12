package com.huaao.ejwplatform.api.dto.bean;

import java.util.List;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DeptItem {

	@ApiDemoData("4028876d5a652216015a6522ca630000")
	@ApiDescription("部门ID")
    private String id;
	
	@ApiDemoData("当代社区物业服务中心")
	@ApiDescription("部门名称")
    private String name;
	
	private List<UserShortInfo> users;

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

	public List<UserShortInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserShortInfo> users) {
		this.users = users;
	}
	
	
}
