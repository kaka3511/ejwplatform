package com.huaao.ejwplatform.api.dto.pub;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.SystemException;

public class DtoPublicRequest {

	@ApiDescription("公用参数 tokenId")
	@NotBlank
	private String token;

	private String _uid;

	@ApiDescription("公用参数，预留。字符串  key1 desc,key2 asc")
	private String sortby;
	
	@ApiDescription("公用参数，预留。模糊查询关键词")
	private String keyword;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		String uid = (String) request.getAttribute(Constants.userId);
		this.setUid(uid);
	}
	public String getUid() throws Exception{
		return this._uid;
	}
	
	public void setUid(String uid){
		this._uid = uid;
	}
	
	public String getSortby() {
		return FuncTool.underscoreName(sortby) ;
	}
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
