package com.huaao.ejwplatform.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.dao.JwNotice;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.mapper.JwNoticeMapper;
import com.huaao.ejwplatform.service.model.PushMessage;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.Device;
import javapns.notification.Payload;
import javapns.notification.PushNotificationBigPayload;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushedNotification;
import javapns.notification.PushedNotifications;

import net.sf.json.JSONObject;

@Service
public class ApnsPushService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwNoticeMapper noticeMapper;
	
	/**
	 * complex() UnSupport set JSONObject, just use fromJSON
	 * @param title
	 * @param text
	 * @param msg
	 * @return
	 * @throws JSONException
	 */
	public PushNotificationBigPayload genPayLoad(String title, String text, PushMessage msg) throws JSONException{
		//PushNotificationBigPayload payload = PushNotificationBigPayload.complex();
		JSONObject alert = new JSONObject();
		alert.put("body", text);
		alert.put("title", title);
		JSONObject aps = new JSONObject();
		aps.put("alert", alert);
		JSONObject info = new JSONObject();
		info.put("aps", aps);
		info.put("type", msg.type);
		info.put("data", msg.data.toString());
		//log.info("json data "+info.toString());
//		payload.addCustomAlertTitle(title);
//		payload.addCustomAlertBody(text);
//		payload.addCustomDictionary("type", msg.type);
//		payload.addCustomDictionary("data", JSONObject.fromObject(msg.data));
		//payload.getPayload().putOpt("data", msg.data);
		PushNotificationBigPayload payload = PushNotificationBigPayload.fromJSON(info.toString());
		
		//log.info("payload "+payload.getPayload().toString());
		return payload;
	}
	
	@Value("${p12File}")
	private String p12File;
	
	@Value("${p12Pwd}")
	private  String password;
	
	//use thread run backgroud. we don't need any return values.
	@Async
	public void pushToTokens(String title, String text, PushMessage msg, Map<String, String> tokens){
		try {
			PushNotificationBigPayload payload = genPayLoad(title, text, msg);
			List<String> devices = new ArrayList<String>(tokens.keySet());
			boolean isProduct = p12File.indexOf("Distribution") >= 0;
			PushedNotifications result = Push.payload(payload, p12File, password, isProduct, devices);
            for(PushedNotification notify: result){
            	log.info("ios push result "+notify.toString());
            	String token = notify.getDevice().getToken();
            	String nid = tokens.get(token);
            	JwNotice notice = new JwNotice();
            	notice.setId(nid);
            	notice.setMsg("token:"+token);
            	if(notify.isSuccessful()){
            		notice.setStatus(1);
            	}else{
            		notice.setStatus(0);
            		notice.setMsg(notice.getMsg()+";"+notify.getResponse().getMessage());
            	}
            	noticeMapper.updateByPrimaryKeySelective(notice);
            }
			log.info("send push msg finish");
		} catch (JSONException e) {
			log.error("PushMessage data format JSON failed");
			e.printStackTrace();
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			log.error("PushMessage connect apn server failed");
			e.printStackTrace();
		} catch (KeystoreException e) {
			// TODO Auto-generated catch block
			log.error("PushMessage keystore invalid");
			e.printStackTrace();
		}
		
	}
	
	

}



