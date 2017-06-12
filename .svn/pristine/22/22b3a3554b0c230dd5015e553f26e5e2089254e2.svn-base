package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.IQueryResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.AbstractTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.service.model.GetuiConfig;
import com.huaao.ejwplatform.service.model.PushMessage;
 

@Service
public class GetuiService {
	static final Logger logger = LoggerFactory.getLogger(GetuiService.class);
	 
//	private GetuiConfig GetuiConfig = new GetuiConfig();
	public static final String PUSHURL = "http://sdk.open.api.igexin.com/apiex.htm";
	@Autowired
	private UserService userService;
	
	public TransmissionTemplate truansmissionTemplate(final PushMessage mt) {
	    TransmissionTemplate template = new TransmissionTemplate();
	    template.setAppId(GetuiConfig.appId);
		template.setAppkey(GetuiConfig.appKey);
	    // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
	    template.setTransmissionType(2);
	    template.setTransmissionContent(mt.toString());
	    // 设置定时展示时间
	    // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
	    return template;
	}
	
	public void pushToUser(List<String> cids, PushMessage msg){
		final AbstractTemplate template = truansmissionTemplate(msg);
        for(String cid: cids){
        	pushToUser(template, cid, false);
        }
	}
	
	public String pushToUser(AbstractTemplate template, String cid, boolean offline) {
		IGtPush push = new IGtPush(PUSHURL, GetuiConfig.appKey, GetuiConfig.masterSecret);
		SingleMessage message = new SingleMessage();
		message.setOffline(offline);
		if(offline) {
			message.setOfflineExpireTime(24 * 3600 * 1000);
		}
		/*IQueryResult abc = push.getClientIdStatus(GetuiConfig.appId, cid);
		logger.info("pushToUser status {}", abc.getResponse().toString());
//		{result=Online} {result=Offline, lastLogin=1496290020570}*/		
		message.setData(template);
		message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
		Target target = new Target();

		target.setAppId(GetuiConfig.appId);
		target.setClientId(cid);

		IPushResult ret = null;
		try {
			logger.info("pushMessageToSingle cid {}, time {}", cid, new Date().getTime());
			ret = push.pushMessageToSingle(message, target);
		} catch (RequestException ex) {
			logger.error("首次推送失败，重试第二次推送：", ex);
			logger.info("pushMessageToSingle sec cid {}, time {}", cid, new Date().getTime());
			ret = push.pushMessageToSingle(message, target, ex.getRequestId());
		}
		final Map<String, Object> response = ret.getResponse();
		logger.info("response={}", JSONUtil.jsonEncode(response));
		if (!StringUtils.equals(MapUtils.getString(response, "result"), "ok") ) {
			logger.error("发送消息失败：{}", response);
		}
		return MapUtils.getString(response, "taskId");
	}
	
	/**
	 * lih
	 */
	public String pushToUser(String title,String text,PushMessage msg, String ... uids){
		List<String> cids = new ArrayList<>();
		List<SysUser> listUser = userService.queryUserList(uids);
		for(SysUser item : listUser){
			if(!StringUtils.isEmpty(item.getGtCode())){
				cids.add(item.getGtCode());
			}
		}
		return pushToUsersEx( title, text,  cids, false, msg);
	}
	
	public String pushToUsersEx(String title,String text, List<String> cids, boolean offline,PushMessage msg) {
		if(cids.isEmpty()) {
			return null;
		}

  		final List<Target> targets = new ArrayList<>();

		final List<String> iosCids=new ArrayList<>();
		final List<String> androidCids=new ArrayList<>();
		for (String cid : cids) {
			if(cid!=null&&cid.length()>0){
				if(cid.length()>32){
					iosCids.add(cid);
				}else{
					final Target target = new Target();
					target.setAppId(GetuiConfig.appId);
					target.setClientId(cid);
					targets.add(target);
					androidCids.add(cid);
				}
			}
		}
		IPushResult ret=null;
		if(iosCids.size()>0){
			IGtPush push = new IGtPush(PUSHURL, GetuiConfig.appKey, GetuiConfig.masterSecret);
			final ListMessage message = new ListMessage();
			message.setOffline(true);
			message.setData(this.getTemplate(title,text));
			message.setPushNetWorkType(0);
			String taskId = push.getContentId(message);
			ret = push.pushAPNMessageToList(GetuiConfig.appId, taskId,iosCids);
		}
		if(androidCids.size()>0){
			IGtPush push = new IGtPush(PUSHURL, GetuiConfig.appKey, GetuiConfig.masterSecret);
			final ListMessage message = new ListMessage();
			message.setOffline(true);
			message.setData(this.commonTemplateDemo(title, text, msg));
			message.setPushNetWorkType(0);
			String taskId = push.getContentId(message);
			ret = push.pushMessageToList(taskId, targets);
		}
		 Map<String, Object> response=null;
		if(ret!=null) {
			 response = ret.getResponse();
			if (!StringUtils.equals(MapUtils.getString(response, "result"), "ok")  ) {
				logger.error("发送消息失败：{},{}", cids, response);
				return null;
			} else {
				logger.info("推送成功：{}", response);
			}
		}
		return MapUtils.getString(response, "contentId");
	}
	
	public NotificationTemplate commonTemplateDemo(String title, String text,PushMessage msg) {
		NotificationTemplate template = new NotificationTemplate();
		// 设置APPID与APPKEY
		template.setAppId(GetuiConfig.appId);
		template.setAppkey(GetuiConfig.appKey);
		// 设置通知栏标题与内容
		template.setTitle(title);
		template.setText(text);
		// 配置通知栏图标
		//template.setLogo("icon.png");
		template.setLogo("");
		// 配置通知栏网络图标
		//template.setLogoUrl("");
		template.setLogoUrl("http://huaao2016.oss-cn-hangzhou.aliyuncs.com/standard.png");
		// 设置通知是否响铃，震动，或者可清除
		template.setIsRing(true);
		template.setIsVibrate(true);
		template.setIsClearable(true);
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		template.setTransmissionType(2);
		template.setTransmissionContent(msg==null?null:msg.toString());
		// 设置定时展示时间
		// template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");

		return template;
	}
	
	/**
	 * 获取 IOS透传模板
	 * @return
	 */
	public  TransmissionTemplate getTemplate(String title,String text) {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(GetuiConfig.appId);
		template.setAppkey(GetuiConfig.appKey);
		template.setTransmissionContent("透传内容");
		template.setTransmissionType(2);
		APNPayload payload = new APNPayload();
		payload.setBadge(1);
		payload.setContentAvailable(1);
		payload.setSound("default");
		payload.setCategory("$由客户端定义");
		// 简单模式APNPayload.SimpleMsg
//		payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
		// 字典模式使用下者
		payload.setAlertMsg(getDictionaryAlertMsg(title,text));
		template.setAPNInfo(payload);
		return template;
	}
	
	/**
	 * 透传消息设置
	 * @return
	 */
	private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(String title,String text) {
		APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
		alertMsg.setBody(text);
		alertMsg.setActionLocKey("ActionLockey");
		alertMsg.setLocKey(text);
		alertMsg.addLocArg("loc-args");
		alertMsg.setLaunchImage("launch-image");
		// IOS8.2以上版本支持
		alertMsg.setTitle(title);
		alertMsg.setTitleLocKey(title);
		alertMsg.addTitleLocArg("TitleLocArg");
		return alertMsg;
	}
	
	

}
