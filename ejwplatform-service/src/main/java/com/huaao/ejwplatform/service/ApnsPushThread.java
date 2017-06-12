package com.huaao.ejwplatform.service;

import java.util.Map;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.huaao.ejwplatform.dao.JwNotice;
import com.huaao.ejwplatform.mapper.JwNoticeMapper;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.notification.PushNotificationBigPayload;
import javapns.notification.PushedNotification;
import javapns.notification.PushedNotifications;

@Component
@Scope("prototype")
public class ApnsPushThread implements Runnable{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${p12File}")
	private String p12File;
	
	@Value("${p12Pwd}")
	private  String password;
	
	@Autowired
	private JwNoticeMapper noticeMapper;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendPushMsg();
	}
	
	private PushNotificationBigPayload payload;
	
	/**
	 * when send push msg finish, should save msg status
	 * key deviceToken
	 * value noticeId
	 */
	private Map<String, String> deviceTokens;
	
	public void sendPushMsg(){
		try {
			PushedNotifications result = Push.payload(payload, p12File, password, true, deviceTokens.keySet());
            for(PushedNotification notify: result){
            	String token = notify.getDevice().getToken();
            	String nid = deviceTokens.get(token);
            	JwNotice notice = new JwNotice();
            	notice.setId(nid);
            	if(notify.isSuccessful()){
            		notice.setStatus(1);
            	}else{
            		notice.setStatus(0);
            		notice.setMsg(notify.getResponse().getMessage());
            	}
            	noticeMapper.updateByPrimaryKeySelective(notice);
            }
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeystoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PushNotificationBigPayload getPayload() {
		return payload;
	}

	public void setPayload(PushNotificationBigPayload payload) {
		this.payload = payload;
	}

	public Map<String, String> getDeviceTokens() {
		return deviceTokens;
	}

	public void setDeviceTokens(Map<String, String> deviceTokens) {
		this.deviceTokens = deviceTokens;
	}
	

}
