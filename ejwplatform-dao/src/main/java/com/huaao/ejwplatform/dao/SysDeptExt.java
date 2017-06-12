package com.huaao.ejwplatform.dao;

import java.io.Serializable;

import com.huaao.ejwplatform.common.web.ApiDemoData;

public class SysDeptExt implements Serializable{

	private static final long serialVersionUID = 83632239693446898L;

	@ApiDemoData("4028876d5a652216015a6522ca630000")
    private String id;
	
	@ApiDemoData("当代社区物业服务中心")
    private String name;
	
	@ApiDemoData("110001001017001001001")
    private String code;

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
}
