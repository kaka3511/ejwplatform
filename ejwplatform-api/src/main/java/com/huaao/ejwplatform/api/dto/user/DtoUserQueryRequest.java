package com.huaao.ejwplatform.api.dto.user;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoUserQueryRequest extends DtoPublicRequestPager{
	@ApiDescription("多个用逗号分隔")
	private String userIds ;//
	private Integer status; //0未认证 ,1资料审核中 ,2已认证
	@ApiDescription("是否可用	0不可用,1可用")
	private Integer isUserable; //
	@ApiDescription("backUser 民警,foreUser 居民,superAdmin 超级管理员,查询多个用逗号分隔")
	private String type; 
	@ApiDescription("authed 审核通过, noAuth 未审核,authFail 审核不通过,authing 审核中,查询多个用逗号分隔")
	private String auth; 
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsUserable() {
		return isUserable;
	}

	public void setIsUserable(Integer isUserable) {
		this.isUserable = isUserable;
	}
	
	
}
