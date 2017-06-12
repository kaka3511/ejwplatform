package com.huaao.ejwplatform.api.model;

public enum MsgClassifyEnum {

	HOUSEHOLDREGISTRATION(1, "户政类"), TRAFFICCONTROL(2, "交管类"), PROVE(3, "证明类"), IMMIGRATION(4, "出入境"), OTHER(5, "其他");

	private MsgClassifyEnum(Integer code, String desc) {
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
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static MsgClassifyEnum valueOf(int value) {
        switch (value) {
	        case 1:
	            return HOUSEHOLDREGISTRATION;
	        case 2:
	            return TRAFFICCONTROL;
	        case 3:
	            return PROVE;
	        case 4:
		        return IMMIGRATION;
	        case 5:
		        return OTHER;
	        default:
	            return null;
        }
    }

}
