package com.huaao.ejwplatform.service.model;


import com.huaao.ejwplatform.dao.SysMessage;
import com.huaao.ejwplatform.dao.SysUser;

public final class MsgInfoHelper {

	/**
	 * 
	 * @param msg
	 * @param sui 回复人
	 * @param sendFui 提问者
	 * @return
	 */
	public static MsgInfo convert(SysMessage msg,SysUser sui,SysUser sendFui) {
		MsgInfo msgInfo = new MsgInfo();
		
		msgInfo.id=msg.getId();
		msgInfo.type=msg.getType();
		msgInfo.userId=msg.getUserId();
		msgInfo.time=msg.getTime();
		msgInfo.title=msg.getTitle();
		msgInfo.content=msg.getContent();
		msgInfo.replyUserId=msg.getReplyUserId();
		msgInfo.replyTime=msg.getReplyTime();
		msgInfo.replyContent=msg.getReplyContent();
		msgInfo.status=msg.getStatus();
		msgInfo.userName=sendFui.getUserName();
		msgInfo.realName=sendFui.getRealname();
		msgInfo.userImg=sendFui.getImg();
		if(sui==null){
			msgInfo.replyUserName=null;
			msgInfo.replyRealName=null;
			msgInfo.replyUserImg=null;
		}else{
			msgInfo.replyUserName=sui.getUserName();
			msgInfo.replyRealName=sui.getRealname();
			msgInfo.replyUserImg=sui.getImg();
		}
		
		msgInfo.phone=sendFui.getPhone();
		msgInfo.isRead=msg.getIsRead();
		msgInfo.open=msg.getOpen();
		msgInfo.classify=msg.getClassify();
		return msgInfo;
		
	}
}
