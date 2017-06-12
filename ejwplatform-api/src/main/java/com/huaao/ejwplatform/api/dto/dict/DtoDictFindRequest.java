package com.huaao.ejwplatform.api.dto.dict;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoDictFindRequest extends DtoPublicRequest{

	@ApiDemoData("alertClassifyDict")
	@ApiDescription("数据字典CODE ：alertClassifyDict 警情类型 ,  businessMatters 网上办事事项 ,   subjectIco:办事指南图标, counselingClassifyDict 咨询服务类别 ")
	@NotEmpty(message="code 不能为空")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	 
	
	
}
