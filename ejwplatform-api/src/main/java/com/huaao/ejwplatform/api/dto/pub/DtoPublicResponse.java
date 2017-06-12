package com.huaao.ejwplatform.api.dto.pub;

import java.io.Serializable;

import com.huaao.ejwplatform.api.dto.bean.CriminalInfo;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

import net.sf.json.JSONObject;

public class DtoPublicResponse implements Serializable{

	private static final long serialVersionUID = -3783199459021802877L;

	@ApiDescription("错误描述")
	@ApiDemoData("操作成功")
	private String msg = "";
	
	//错误码
	@ApiDescription("错误代码")
	@ApiDemoData("0")
	private Integer code = Constants.API_CODE_SUCCESS;
	
	@ApiDescription("请求序列，每次请求会产生唯一编号,接口错误时请记录该编号")
	@ApiDemoData("RQ"+DemoData.ID)
	private String reqId=null;
	
	public String getMsg() {
		return msg;
	}
	public DtoPublicResponse setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public DtoPublicResponse addMsg(String msg){
		this.msg += msg;
		return this;
	}
	
	public Integer getCode() {
		return code;
	}
	public DtoPublicResponse setCode(Integer code) {
		this.code = code;
		return this;
	}
	
	public static DtoPublicResponse init(){
		return new DtoPublicResponse();
	}
	public static DtoPublicResponse init(String message){
		DtoPublicResponse dr = new DtoPublicResponse();
		dr.setMsg(message);
		return dr;
	}
	
	public static DtoPublicResponse fail(String message){
	    return fail(Constants.API_CODE_SERVER_ERROR, message);
	}
	
	public static DtoPublicResponse fail(int code, String message){	
		DtoPublicResponse dr = new DtoPublicResponse();
		dr.setCode(code);
		dr.setMsg(message);
		return dr;
	}
	
	public void setFail(String message){
		this.setCode(Constants.API_CODE_SERVER_ERROR);
		this.setMsg(message);
	}
	public String toJson(){
		JSONObject jo = JSONObject.fromObject(this);
		return jo.toString();
	}
	
	public void initDemoData(Class genClass){
		FuncTool.createDemoData(this.getClass(), genClass ,this,false); 
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	
	
}
