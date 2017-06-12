package com.huaao.ejwplatform.api.dto.bean;

import java.util.List;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class PopulationItem {
	@ApiDescription("人口数据-0")
	@ApiDemoData("")
	private DeptInformationInfoHelper population0;
	
	@ApiDescription("人口数据-1")
	@ApiDemoData("1000")
	private DeptInformationInfoHelper population1;
	
	@ApiDescription("人口数据-2")
	@ApiDemoData("6")
	private  PopulationItemHelper population22;
	
	@ApiDescription("人口数据-2")
	@ApiDemoData("6")
	private  PopulationItemHelper population33;


	public PopulationItemHelper getPopulation33() {
		return population33;
	}

	public void setPopulation33(PopulationItemHelper population33) {
		this.population33 = population33;
	}

	public DeptInformationInfoHelper getPopulation0() {
		return population0;
	}

	public void setPopulation0(DeptInformationInfoHelper population0) {
		this.population0 = population0;
	}

	public DeptInformationInfoHelper getPopulation1() {
		return population1;
	}

	public void setPopulation1(DeptInformationInfoHelper population1) {
		this.population1 = population1;
	}

	public PopulationItemHelper getPopulation22() {
		return population22;
	}

	public void setPopulation22(PopulationItemHelper population22) {
		this.population22 = population22;
	}


	
	
	
	
}
