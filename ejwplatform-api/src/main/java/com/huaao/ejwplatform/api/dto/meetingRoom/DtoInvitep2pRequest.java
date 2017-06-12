package com.huaao.ejwplatform.api.dto.meetingRoom;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;

public class DtoInvitep2pRequest extends DtoPublicRequest{

	private String roomid;
	private String toid; //接受邀请的用户ID
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	 
}
