package com.huaao.ejwplatform.api.dto.bean;

import java.util.Date;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class AlertItem {
	@ApiDescription("")
	@ApiDemoData("")
	private String alertId;
 
	@ApiDescription("经纬度")
	@ApiDemoData(DemoData.LOCATION)
	private String location;// 
	
	
	@ApiDemoData("1")
	@ApiDescription("1-一键报警 ,2-随手记 ,3-举报")
	private Integer type; 
 
	@ApiDescription("手机号")
	@ApiDemoData(DemoData.CELL_PHONE)
	private String cellphone;
	
	@ApiDescription("处理状态,0 未处理， 1 已处理 , 2 已委派")
	@ApiDemoData("0")
	private Integer status;

	@ApiDescription("报警时间")
	@ApiDemoData(DemoData.STMAP)
	private Date alertTime ;

	@ApiDescription("报警类型分类 : 群众求助1 ,举报线索2 ,投诉监督3 ,治安事件4 ,交通事件5 ,抢险救援6 ,刑事案件7")
	@ApiDemoData("1")
	private Integer classify;
	
	@ApiDescription("描述")
	@ApiDemoData("警情描述")
	private String description;
	
	
	public void setId(String id){
		this.alertId = id;
	}
	
	public String getAlertId() {
		return alertId;
	}


	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(Date alertTime) {
		this.alertTime = alertTime;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
 
  
}
