package com.huaao.ejwplatform.service.model;

public enum AlertCategoryEnum {

	VALID(1,"有效警情"), REPEAT(2,"重复警情") ,UNVALID(3,"无效警情");
	
	private AlertCategoryEnum(Integer code, String desc) {
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
	
	public static AlertCategoryEnum valueOf(int value) {
        switch (value) {
	        case 1:
	            return VALID;
	        case 2:
	            return REPEAT;
	        case 3:
	            return UNVALID;
	        default:
	            return null;
        }
    }
}
