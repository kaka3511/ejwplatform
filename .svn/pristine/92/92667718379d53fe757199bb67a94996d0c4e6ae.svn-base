package com.huaao.ejwplatform.api.model;

/**
 * 
* @Title: ContentTopEnum.java
* @Package com.huaao.ejwplatform.api.model
* @Description: 消息内容置顶
* @author hongli  
* @date 2017年3月10日 上午9:44:34
 */
public enum ContentTopEnum {

	UN_TOP(0, "不置顶"), TOP(1, "置顶");

	private ContentTopEnum(Integer code, String desc) {
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
	
	public static ContentTopEnum valueOf(int value) {
        switch (value) {
	        case 0:
	            return UN_TOP;
	        case 1:
	            return TOP;
	        default:
	            return null;
        }
    }

}
