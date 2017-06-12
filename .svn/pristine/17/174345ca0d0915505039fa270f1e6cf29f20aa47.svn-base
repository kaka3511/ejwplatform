package com.huaao.ejwplatform.service.model;

public enum AlertStatusEnum {

	UNCOMIT(0,"未处理"), DONE(1,"已处理（已解除）"), APPOINT(2,"已委派(选配)"), COOPER(3,"已协作(选配)"), REPORT(4,"已上报(选配)"), DEL(5,"已删除");
	
	private AlertStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public String toString(){  //覆盖了父类Enum的toString()  
        return super.toString()+"("+code+","+desc+")";  
    }  
	private Integer code; // 自定义数据域，private为了封装。
	private String desc;
	public Integer getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static AlertStatusEnum valueOf(int value) {
        switch (value) {
	        case 0:
	            return UNCOMIT;
	        case 1:
	            return DONE;
	        case 2:
	            return APPOINT;
	        case 3:
	            return COOPER;
	        case 4:
	            return REPORT;
	        case 5:
	            return DEL;
	        default:
	            return null;
        }
    }
}
