package com.huaao.ejwplatform.api.dto.alert;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("警情解除接口请求参数")
public class DtoOperateAlertRequest extends DtoPublicRequest{
	@ApiDescription("警情ID")
	@NotBlank
	@ApiDemoData("03fc86e759c64b029563da4037989df7,03fc86e759c64b029563da4037989df6")
	private String alertIds; //多个ID以逗号分隔
	
	@ApiDescription("1 有效警情 , 2 重复警情 , 3无效警情")
	@NotNull
	@ApiDemoData("1")
	private Integer alertCategory; //1 有效警情 , 2 重复警情 , 3无效警情

	@ApiDescription("备注")
	@ApiDemoData("备注描述内容")
	private String remark; //备注
	
	@ApiDescription("报警类型分类 : 群众求助1 ,举报线索2 ,投诉监督3 ,治安事件4 ,交通事件5 ,抢险救援6 ,刑事案件7")
	@ApiDemoData("1")
	private Integer classify; 
	
	public String getAlertIds() {
		return alertIds;
	}

	public void setAlertIds(String alertIds) {
		this.alertIds = alertIds;
	}

	public Integer getAlertCategory() {
		return alertCategory;
	}

	public void setAlertCategory(Integer alertCategory) {
		this.alertCategory = alertCategory;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}
	
	
}
