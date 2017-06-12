package com.huaao.ejwplatform.service.model;


public class MeetingInvitationTransmission extends AbstractJsonModel{
	private static final long serialVersionUID = -889436118126441477L;
	public MeetingInvitationTransmission(){}

	public MeetingInvitationTransmission(MeetingInvitationInfo invitation){
		this.id = invitation.id;
		this.message = invitation.message;
        this.time = invitation.time;
        this.topic = invitation.topic;
        this.password = invitation.password;
        this.inviterid = invitation.inviterid;
        this.inviter = invitation.inviter;
		this.invitericon = invitation.invitericon;
        this.createtime = invitation.createtime;
        this.roomid = invitation.roomid;
        this.roomidstr = invitation.roomidstr;
        this.roomname = invitation.roomname;
	}

	public String id;
	public String message;
	public Long time;
	public String topic;
	public String password;
	public String inviterid;
	public String inviter;
	public String invitericon;
	public Long createtime;
	public String roomid;
	public String roomidstr;
	public String roomname;
}
