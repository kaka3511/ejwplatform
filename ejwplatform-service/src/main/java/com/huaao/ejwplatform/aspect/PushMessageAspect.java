package com.huaao.ejwplatform.aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.huaao.ejwplatform.dao.JwNotice;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.dao.SysUserExample;
import com.huaao.ejwplatform.mapper.JwNoticeMapper;
import com.huaao.ejwplatform.mapper.SysUserMapper;
import com.huaao.ejwplatform.service.ApnsPushService;
import com.huaao.ejwplatform.service.GetuiService;
import com.huaao.ejwplatform.service.model.MeetingInvitationInfo;
import com.huaao.ejwplatform.service.model.MeetingInvitationTransmission;
import com.huaao.ejwplatform.service.model.NewPushMessage;
import com.huaao.ejwplatform.service.model.PushMessage;
import com.huaao.ejwplatform.service.model.PushMessageType;
import com.huaao.ejwplatform.service.websocket.SocketIoService;


/**
 * watch all service which has method name createPushMessage
 * deside use ApnsPushService or GetuiService to send push message
 * @author sujin
 *
 */
@Component
@Aspect
public class PushMessageAspect {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private JwNoticeMapper noticeMapper;
	
	@Autowired
	private ApnsPushService pushService;
	
	@Autowired
	private GetuiService gPushService;
	
	@AfterReturning(pointcut="execution(com.huaao.ejwplatform.service.model.NewPushMessage com.huaao.ejwplatform.service.PushService.*(..))", returning="returnValue")
	public void process(JoinPoint point, Object returnValue) throws Throwable{
		if (returnValue == null) {
			log.info("aspect aop push message is null");
			return ;
		}
		NewPushMessage msg = (NewPushMessage) returnValue;
		log.info("aspect aop get new push message "+msg.getMessage().toString());
		SysUserExample exa = new SysUserExample();
		exa.createCriteria().andIdIn(msg.getUids());
		List<SysUser> users =  sysUserMapper.selectByExample(exa);
		
		Map<String, String> ios_devices = new HashMap<String, String>();
		//for test
		//ios_devices.put("9faaad7346ed8c08b7495ac43d0addfad7ec1d6ffb7561f8571184a249377c57", "4028876d5a934b98015a9350e8880000");
		List<String> android_devices = new ArrayList<String>();
		for(SysUser user: users){
			//ios use async thread to write jw_notice record
			if(user.getDeviceType() != null && user.getDeviceType().equals("ios")){
				String deviceToken = user.getDeviceToken();
				if(!StringUtils.isEmpty(deviceToken)){
					String noticeId = saveJwNotice(msg, user.getId());
					ios_devices.put(deviceToken, noticeId);
				}
			}else if(!StringUtils.isEmpty(user.getGtCode())){
				android_devices.add(user.getGtCode());
				saveJwNotice(msg, user.getId());
			}
		}
		
		if(ios_devices.size() > 0){
			pushService.pushToTokens(msg.getTitle(), msg.getText(), msg.getMessage(), ios_devices);  	
		}
		
		if(android_devices.size() > 0){
			byte msgType = msg.getMessage().type;
			if(msgType == PushMessageType.P2pCall.value || msgType == PushMessageType.P2pRefuse.value || msgType == PushMessageType.Kickoff.value){
				gPushService.pushToUser(android_devices, msg.getMessage());

			}else{
				gPushService.pushToUsersEx(msg.getTitle(), msg.getText(), android_devices, true, msg.getMessage());
			}
		}
	}
	
	public String saveJwNotice(NewPushMessage msg, String uid){
		JwNotice notice=new JwNotice();
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		notice.setId(id);
		notice.setType((int)msg.getMessage().type);
		notice.setUserId(uid);
		notice.setTime(new Date());
		notice.setCreateTime(new Date());
		notice.setTitle(msg.getTitle());
		notice.setMessage(msg.getText());
		notice.setCreatorId(uid);
        notice.setUpdaterId(uid);
        notice.setMsgId(msg.getId());
		noticeMapper.insert(notice);
		return id;
	}

}
