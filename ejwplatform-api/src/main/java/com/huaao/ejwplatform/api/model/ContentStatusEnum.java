package com.huaao.ejwplatform.api.model;

public enum ContentStatusEnum {

	DAI_FA_BU(1,"待发布"), WEI_SHEN_PI(2,"未审批") ,YI_FA_BU(3,"已发布"), YI_CHE_XIAO(4, "已撤销");
	
	private ContentStatusEnum(Integer code, String desc) {
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
	
	public static ContentStatusEnum valueOf(int value) {
        switch (value) {
	        case 1:
	            return DAI_FA_BU;
	        case 2:
	            return WEI_SHEN_PI;
	        case 3:
	            return YI_FA_BU;
	        case 4:
	            return YI_CHE_XIAO;
	        default:
	            return null;
        }
    }
}
