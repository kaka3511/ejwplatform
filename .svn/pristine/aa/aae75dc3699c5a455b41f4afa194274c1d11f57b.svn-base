package com.huaao.ejwplatform.api.dto.msg;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.common.web.ApiDescription;


public class DtoMsgListRequest extends DtoPublicRequestPager{

	@ApiDescription("消息类型1居民咨询 2所长信箱 3我要找警")
	@NotNull
	private Integer type;
	@ApiDescription("是否已读 0已读 1未读")
	private Integer isRead;
	@ApiDescription("姓名")
	private String realName;
	@ApiDescription("联系电话")
	private String phone;
	@ApiDescription("查询公开 设置为1 ")
	private Integer open;
	@ApiDescription("回复状态 1已回复(已回复、已评价) 2未回复 ")
	private Integer status;
	@ApiDescription("1:居民  2:警察 ")
	private Integer appType; 
	@ApiDescription("咨询服务类别classify。1，户政类2，交管类3，证明类4，出入境5，其他 ,多个用逗号隔开")
	private String classify;
	 
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAppType() {
		return appType;
	}

	public void setAppType(Integer appType) {
		this.appType = appType;
	}
	
}
