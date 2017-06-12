package com.huaao.ejwplatform.api.dto.alert;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("查询警情接口请求参数")
public class DtoQueryAlertRequest extends DtoPublicRequestPager{
	@ApiDescription("根据ID查询警情，多个id用逗号分隔")
	@ApiDemoData("03fc86e759c64b029563da4037989df7,03fc86e759c64b029563da4037989df6")
	private String alertIds ; //
	
	@ApiDescription("状态 0-未解除（未处理和已委派）,1-已解除（已完成和待评价）")
	@ApiDemoData("0")
	private Integer status = null; //状态 0-未处理 ,1-已处理（已解除）
	
	@ApiDescription("报警类型 1-一键报警 2-随手记 3-举报 4 补录")
	@ApiDemoData("1")
	private Integer type = null; // 1-一键报警 2-随手记 3-举报
	
	@ApiDescription("报警类型分类 : 群众求助1 ,举报线索2 ,投诉监督3 ,治安事件4 ,交通事件5 ,抢险救援6 ,刑事案件7 ,多个逗号分开")
	@ApiDemoData("1")
	private String classify;  
	
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

	public String getAlertIds() {
		return alertIds;
	}

	public void setAlertIds(String alertIds) {
		this.alertIds = alertIds;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	
}
