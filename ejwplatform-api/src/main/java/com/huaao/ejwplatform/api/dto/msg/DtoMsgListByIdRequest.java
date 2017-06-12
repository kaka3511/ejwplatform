package com.huaao.ejwplatform.api.dto.msg;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoMsgListByIdRequest extends DtoPublicRequest{

	@ApiDescription("消息ID,多个以逗号隔开")
	@NotBlank
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	
	
}
