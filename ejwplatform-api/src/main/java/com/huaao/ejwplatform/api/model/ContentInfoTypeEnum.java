package com.huaao.ejwplatform.api.model;

public enum ContentInfoTypeEnum {

	JING_QING_TONG_BAO(1,"警情通报"), XIE_CHA_TONG_BAO(2,"协查通报") ,SHE_QU_DONG_TAI(3,"社区动态"), 
	BAN_SHI_ZHI_NAN(4, "办事指南"), FANG_ZHA_PIAN(5,"防范小贴士"), XIAO_XI_TONG_ZHI(6,"消息通知"),
	ZHENG_CE_XUAN_CHUAN(7,"热点新闻"), ZHENG_CE_XUE_XI(8, "i学习"),ZHI_SHI_KU(9,"知识库");
	
	private ContentInfoTypeEnum(Integer code, String desc) {
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
	
	public static ContentInfoTypeEnum valueOf(int value) {
        switch (value) {
	        case 1:
	            return JING_QING_TONG_BAO;
	        case 2:
	            return XIE_CHA_TONG_BAO;
	        case 3:
	            return SHE_QU_DONG_TAI;
	        case 4:
	            return BAN_SHI_ZHI_NAN;
	        case 5:
	            return FANG_ZHA_PIAN;
	        case 6:
	            return XIAO_XI_TONG_ZHI;
	        case 7:
	            return ZHENG_CE_XUAN_CHUAN;
	        case 8:
	            return ZHENG_CE_XUE_XI;
	        case 9:
	            return ZHI_SHI_KU;
	        default:
	            return null;
        }
    }
}
