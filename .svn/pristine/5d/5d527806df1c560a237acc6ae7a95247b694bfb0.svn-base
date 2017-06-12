package com.huaao.ejwplatform.api.dto.lifeData;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("导入生活用户数据接口请求参数")
public class DtoImportLifeDataRequest extends DtoPublicRequest{

	@ApiDescription("小区ID")
	@ApiDemoData("8a2b2a045a93f275015a93fcb02f0000")
	@NotEmpty(message="所属单位不能为空")
	private String deptId;
	
	@ApiDescription("1 水 2 电 默认1")
	@ApiDemoData("1")
	@NotNull(message="类型必需输入")
	private Integer type;

	@ApiDescription("已上传的文件路径，由文件上传接口返回")
	@ApiDemoData("/xxx/xxxx.xlsx")
	private String filepath;
	
	@ApiDescription("月份")
	@ApiDemoData("2017-03")
	@NotEmpty(message="月份不能为空")
	private String month;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
