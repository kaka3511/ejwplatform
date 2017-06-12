package com.huaao.ejwplatform.dao;

import java.util.List;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.ApiLoop;

public class MenuDto {


	@ApiDemoData("")
	@ApiDescription("id")
	private String id;

	@ApiDemoData("")
	@ApiDescription("菜单图标")
    private String icon;

	@ApiDemoData("")
	@ApiDescription("菜单名称")
    private String name;

	@ApiDemoData("")
	@ApiDescription("层级")
    private Integer level;

	@ApiDemoData("")
	@ApiDescription("排序")
    private Integer sort;

	@ApiDemoData("")
	@ApiDescription("请求路径")
    private String url;

	@ApiDemoData("")
	@ApiDescription("权限")
    private String permission;

	@ApiDemoData("")
	@ApiDescription("父菜单ID")
    private String parentId;

	@ApiDemoData("")
	@ApiDescription("类型")
    private String type;
 
	private String userId;
	
	@ApiLoop
	private List<MenuDto> menus;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<MenuDto> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuDto> menus) {
		this.menus = menus;
	}
	
    
}
