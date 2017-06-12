package com.huaao.ejwplatform.api.dto.deptinformation;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("导入微信息数据接口请求参数")
public class DtoDeptInfomationImportRequest {

	@ApiDescription("部门ID")
	@ApiDemoData(DemoData.ID)
	private String deptId;

	@ApiDescription("已上传的文件路径，由文件上传接口返回")
	@ApiDemoData("/xxx/xxxx.xlsx")
	private String filepath;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}	
}
