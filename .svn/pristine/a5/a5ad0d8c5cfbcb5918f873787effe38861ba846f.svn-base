package com.huaao.ejwplatform.api.model;

public enum MsgReplyEnum {

	BLOCK(0, "已屏蔽"), REPLY(1, "已回复"), UNREPLY(2, "未回复"), APPRAISE(3, "已评价");

	private MsgReplyEnum(Integer code, String desc) {
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
	
	public static MsgReplyEnum valueOf(int value) {
        switch (value) {
	        case 0:
	            return BLOCK;
	        case 1:
	            return REPLY;
	        case 2:
	            return UNREPLY;
	        case 3:
		        return APPRAISE;
	        default:
	            return null;
        }
    }

}
