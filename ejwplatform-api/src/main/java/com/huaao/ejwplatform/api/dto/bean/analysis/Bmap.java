package com.huaao.ejwplatform.api.dto.bean.analysis;

import java.util.List;

import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class Bmap {

	@ApiDemoData("120.14322240845;30.236064370321")
	@ApiDescription("经纬度坐标")
	private List<String> coord ;
	
	@ApiDemoData("18")
	@ApiDescription("警情数量")
	private Integer count;

	public List<String> getCoord() {
		return coord;
	}

	public void setCoord(List<String> coord) {
		this.coord = coord;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
