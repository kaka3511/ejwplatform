package com.huaao.ejwplatform.api.dto.alert;


import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoAllAlertItemRequest extends DtoPublicRequestPager{
	@ApiDescription("状态 0-未解除（未处理和已委派）,1-已解除（已完成和待评价）")
	@ApiDemoData("0")
	private Integer status = null; 
	
	@ApiDescription("报警类型 报警类型 1-一键报警 2-随手记 3-举报 4 补录")
	@ApiDemoData("1")
	private Integer type = null; // 1-一键报警 2-随手记 3-举报

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
