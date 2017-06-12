package com.huaao.ejwplatform.service.model;
 

public enum PushMessageType {

	/*会议通知（1）、警情(2)、审核通知(3)、自定义通知(4)、咨询通知(5)、网上办事(6)、APP端踢人通知（7）、用户信息修改（8）、 会议邀请(9)、 视频呼叫和接通(10)、视频拒绝和挂断（11）所长信箱(12)我要找警(13)i政策(14)*/
	MeetingCall(1),Alerting(2),Audit(3),Custom(4),Consultation(5),Apply(6),
	Kickoff(7), UserInfoChanged(8), MeetingInvitation(9), P2pCall(10), P2pRefuse(11), Mail(12), FindPolice(13), iPolicy(14);
	
	public final byte value;
	PushMessageType(int value) {
		this.value = (byte)value;
	}
	
	public PushMessage create(AbstractJsonModel data) {
		PushMessage message = new PushMessage();
		message.type = this.value;
		message.data = data;
		return message;
	}
}