package com.huaao.ejwplatform.service.model;


public class MeetingInvitationInfo extends AbstractJsonModel{
	private static final long serialVersionUID = -889436118126441477L;
	
	public String id;
    public String message;
    public Long time;
    public String topic;
    public String password;
    public String inviterid;
    public String inviter;
    public Long createtime;
    public String roomid;
    public String roomidstr;
    public String roomname;
    public String invitericon;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInviterid() {
		return inviterid;
	}
	public void setInviterid(String inviterid) {
		this.inviterid = inviterid;
	}
	public String getInviter() {
		return inviter;
	}
	public void setInviter(String inviter) {
		this.inviter = inviter;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getRoomidstr() {
		return roomidstr;
	}
	public void setRoomidstr(String roomidstr) {
		this.roomidstr = roomidstr;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getInvitericon() {
		return invitericon;
	}
	public void setInvitericon(String invitericon) {
		this.invitericon = invitericon;
	}
}
