package com.huaao.ejwplatform.service.model;

import com.huaao.ejwplatform.dao.JwMeetingRoomXy;

public final class MeetingRoomHelper {
 

	public static MeetingRoomInfo convert(JwMeetingRoomXy room) {
		if(room == null) {
			return null;
		}
		final MeetingRoomInfo roomInfo = new MeetingRoomInfo();
		roomInfo.id = room.getId();
		roomInfo.name = room.getName();
		roomInfo.notice = room.getNotice();
		roomInfo.type = room.getType();
		roomInfo.roomId = room.getRoomid();
		roomInfo.password = room.getPassword();
        roomInfo.url = room.getUrl();
		return roomInfo;
	}
	
}