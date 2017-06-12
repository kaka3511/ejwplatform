package com.huaao.ejwplatform.api.dto.bean.analysis;

import java.util.ArrayList;
import java.util.List;

import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class GetAlertProcessChartCategory {

	@ApiDemoData("1489051270503,100")
	@ApiDescription("未处理警情数量，日期毫秒数+数量，逗号分隔")
	private List<String> undo;
	
	@ApiDemoData("1489051270503,100")
	@ApiDescription("已处理警情数量，日期毫秒数+数量，逗号分隔")
	private List<String> done;
	
	@ApiDemoData("1489051270503,100")
	@ApiDescription("总警情数量，日期毫秒数+数量，逗号分隔")
	private List<String> all;

	@ApiDemoData("1489051270503,4.2")
	@ApiDescription("满意度，日期毫秒数+满意度，逗号分隔")
	private List<String> satisfy;
	
	@ApiDemoData("4.0")
	@ApiDescription("总满意度，日期毫秒数+满意度，逗号分隔")
	private String totalSatisfy;
	
	public List<String> getUndo() {
		return undo;
	}

	public void setUndo(List<String> undo) {
		this.undo = undo;
	}

	public List<String> getDone() {
		return done;
	}

	public void setDone(List<String> done) {
		this.done = done;
	}

	public List<String> getAll() {
		return all;
	}

	public void setAll(List<String> all) {
		this.all = all;
	}
	
	public void addUndo(String date,String count){
		if(undo == null){
			undo = new ArrayList<>();
		}
		undo.add(DateTool.dateStrToTimeStap(date)+","+count) ;
	}
	public void addDone(String date,String count){
		if(done == null){
			done = new ArrayList<>();
		}
		done.add(DateTool.dateStrToTimeStap(date)+","+count) ;
	}
	public void addAll(String date,String count){
		if(all == null){
			all = new ArrayList<>();
		}
		all.add(DateTool.dateStrToTimeStap(date)+","+count) ;
	}

	public List<String> getSatisfy() {
		return satisfy;
	}

	public void setSatisfy(List<String> satisfy) {
		this.satisfy = satisfy;
	}

	public String getTotalSatisfy() {
		return totalSatisfy;
	}

	public void setTotalSatisfy(String totalSatisfy) {
		this.totalSatisfy = totalSatisfy;
	}
	
}
