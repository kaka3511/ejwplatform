package com.huaao.ejwplatform.api.model;

public enum MsgReadEnum {

	UNREAD(0, "未读"), READ(1, "已读");

	private MsgReadEnum(Integer code, String desc) {
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
	
	public static MsgReadEnum valueOf(int value) {
        switch (value) {
	        case 0:
	            return UNREAD;
	        case 1:
	            return READ;
	        default:
	            return null;
        }
    }

}
