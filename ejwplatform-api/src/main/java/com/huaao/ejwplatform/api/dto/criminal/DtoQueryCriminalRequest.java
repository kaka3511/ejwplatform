package com.huaao.ejwplatform.api.dto.criminal;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoQueryCriminalRequest extends DtoPublicRequestPager{

	@ApiDescription("申请人ID,查询自己数据时填写此项")
	@ApiDemoData(DemoData.ID)
	private String userId;
	
	@ApiDescription("审核状态,见上面接口说明,多个状态用逗号分隔")
	@ApiDemoData("")
    private String authStatus;

	@ApiDescription("是否有犯罪记录,1 没有 ， 2 有")
	@ApiDemoData("1")
    private Integer hasRecord;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public Integer getHasRecord() {
		return hasRecord;
	}

	public void setHasRecord(Integer hasRecord) {
		this.hasRecord = hasRecord;
	}
	
	
}
