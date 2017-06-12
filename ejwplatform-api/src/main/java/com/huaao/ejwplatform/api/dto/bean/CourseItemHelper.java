package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class CourseItemHelper {


	@ApiDescription("发展历程-2")
	@ApiDemoData("")
	private DeptInformationInfoHelper course2;
	
	@ApiDescription("发展历程-3")
	@ApiDemoData("")
	private DeptInformationInfoHelper course3;
	
	@ApiDescription("发展历程-4")
	@ApiDemoData("")
	private DeptInformationInfoHelper course4;

	public DeptInformationInfoHelper getCourse2() {
		return course2;
	}

	public void setCourse2(DeptInformationInfoHelper course2) {
		this.course2 = course2;
	}

	public DeptInformationInfoHelper getCourse3() {
		return course3;
	}

	public void setCourse3(DeptInformationInfoHelper course3) {
		this.course3 = course3;
	}

	public DeptInformationInfoHelper getCourse4() {
		return course4;
	}

	public void setCourse4(DeptInformationInfoHelper course4) {
		this.course4 = course4;
	}

}
