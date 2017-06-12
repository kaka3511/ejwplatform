package com.huaao.ejwplatform.api.dto.meetingRoom;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;

public class DtoInvitep2pXiaoyuRequest extends DtoPublicRequest{

	private String toid; //接受邀请的用户ID
	 
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	
	 
}
