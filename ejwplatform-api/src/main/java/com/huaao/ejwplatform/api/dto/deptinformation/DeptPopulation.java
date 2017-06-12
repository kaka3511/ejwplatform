package com.huaao.ejwplatform.api.dto.deptinformation;

import java.util.ArrayList;
import java.util.List;

public class DeptPopulation {

	private String total;
	private String description;
	private List<DeptPopulationData> data1 = new ArrayList<>();
	private List<DeptPopulationData> data2 = new ArrayList<>();
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<DeptPopulationData> getData1() {
		return data1;
	}
	public void setData1(List<DeptPopulationData> data1) {
		this.data1 = data1;
	}
	public List<DeptPopulationData> getData2() {
		return data2;
	}
	public void setData2(List<DeptPopulationData> data2) {
		this.data2 = data2;
	}
	
	public void addData1(String type,String number){
		this.data1.add(new DeptPopulationData(type,number));
	}
	public void addData2(String type,String number){
		this.data2.add(new DeptPopulationData(type,number));
	}
}
 