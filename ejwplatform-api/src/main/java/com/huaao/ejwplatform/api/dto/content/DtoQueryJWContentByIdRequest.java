package com.huaao.ejwplatform.api.dto.content;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("根据消息ID查询信息接口请求参数类")
public class DtoQueryJWContentByIdRequest extends DtoPublicRequest {

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
