package com.huaao.ejwplatform.service.model;

public enum UserActionEnum {

	Login(1, "登录"), Logout(0, "登出");

	private UserActionEnum(Integer code, String desc) {
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
	
	public static UserActionEnum valueOf(int value) {
        switch (value) {
	        case 0:
	            return Logout;
	        case 1:
	            return Login;
	        default:
	            return null;
        }
    }

}
