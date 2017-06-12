package com.huaao.ejwplatform.service.model;

import com.huaao.ejwplatform.dao.JwMeetingInvitation;

public class MeetingInvitationHelper {
	 public static MeetingInvitationInfo convert(JwMeetingInvitation invitation) {
	        if(invitation == null) {
	            return null;
	        }
	        final MeetingInvitationInfo invitationInfo = new MeetingInvitationInfo();

	        invitationInfo.id = invitation.getId();
	        invitationInfo.message = invitation.getMessage();
	        invitationInfo.inviterid = invitation.getInviterid();
	        invitationInfo.inviter = invitation.getInvitername();
	        invitationInfo.time = invitation.getTime();
	        invitationInfo.createtime = invitation.getCreatetime();
	        invitationInfo.topic = invitation.getTitle();
	        invitationInfo.roomid = invitation.getRoomid();
	        invitationInfo.roomidstr = invitation.getRoomidstr();
	        invitationInfo.roomname = invitation.getRoomname();
	        invitationInfo.password = invitation.getPassword();

	        return  invitationInfo;
	    }
}
