package com.huaao.ejwplatform.service.model;

public enum CriminalAuthStatusEnum {

	DAI_SHOU_LI(0, "提交申请" ,"待受理"), DAI_SHEN_PI(1, "已受理", "待审批"), DAI_QUE_REN(2, "审核", "待确认"), 
	DAI_ZI_QU(3, "申请自行领取", "待自取"), PEI_SONG_ZHONG(4, "已邮寄", "配送中"), WEI_TONG_GUO(5, "未通过", "未通过"),
	YI_QIAN_SHOU(6, "已签收", "已签收"), YI_LING_QU(7, "已领取", "已领取"), YI_SHI_XIAO(8, "已失效", "已失效"), WAIT_PAY(9, "申请邮政快递", "待支付"),YI_PIN_JIA(10, "已评价", "");
	
	private CriminalAuthStatusEnum(Integer code, String action, String desc) {
		this.code = code;
		this.action = action;
		this.desc = desc;
	}

	public String toString() { // 覆盖了父类Enum的toString()
		return super.toString() + "(" + code + "," + desc + ")";
	}

	private Integer code; // 自定义数据域，private为了封装。
	private String action;
	private String desc;

	public Integer getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static CriminalAuthStatusEnum valueOf(int value) {
		switch (value) {
		case 0:
			return DAI_SHOU_LI;
		case 1:
			return DAI_SHEN_PI;
		case 2:
			return DAI_QUE_REN;
		case 3:
			return DAI_ZI_QU;
		case 4:
			return PEI_SONG_ZHONG;
		case 5:
			return WEI_TONG_GUO;
		case 6:
			return YI_QIAN_SHOU;
		case 7:
			return YI_LING_QU;
		case 8:
			return YI_SHI_XIAO;
		case 9:
			return WAIT_PAY;
		default:
			return null;
		}
	}
}
