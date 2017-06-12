package com.huaao.ejwplatform.api.dto.lifeData;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;


@ApiDescription("用水用电数据查询请求参数")
public class DtoQueryLifeDataRequest extends DtoPublicRequestPager {

	@ApiDescription("小区ID")
	@ApiDemoData("8a2b2a045a93f275015a93fcb02f0000")
	@NotEmpty(message="所属单位不能为空")
	private String deptId;
	
	@ApiDescription("1 水 2 电 默认1")
	@ApiDemoData("1")
	@NotNull(message="类型必需输入")
	private Integer type;
	
	@ApiDescription("起始年月 2017-01")
	@ApiDemoData("2017-01")
	private String startMonth;
	
	@ApiDescription("截止年月 2017-03")
	@ApiDemoData("2017-03")
	private String endMonth;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
}
