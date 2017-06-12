package com.huaao.ejwplatform.api.dto.bean.analysis;

import java.util.ArrayList;
import java.util.List;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class AlertDoneLineChar {

	@ApiDemoData("群众求助;举报线索")
	@ApiDescription("警情分类")
	private List<String> classifyList = new ArrayList<>();
	
	@ApiDemoData("[30, 2, 32];[12, 0, 12]")
	@ApiDescription("警情数量，'解除警情','委派警情','接收警情',序号与分类对应")
	private List<String> alertData  = new ArrayList<>();

	public List<String> getClassifyList() {
		return classifyList;
	}

	public void setClassifyList(List<String> classifyList) {
		this.classifyList = classifyList;
	}

	public List<String> getAlertData() {
		return alertData;
	}

	public void setAlertData(List<String> alertData) {
		this.alertData = alertData;
	}
	
}
