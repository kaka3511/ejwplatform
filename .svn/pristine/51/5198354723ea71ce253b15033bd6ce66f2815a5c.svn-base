package com.huaao.ejwplatform.service.mq;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.mqtt.*;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MqttService {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttService.class);

	
	public static final AttributeKey<String> NETTY_CHANNEL_KEY = AttributeKey.valueOf("NETTY_CHANNEL_KEY");
	public static final String TOPIC_NAME = "all";
	
	private ConcurrentHashMap<String, MqttConnection> connectionMap = new ConcurrentHashMap<>();
	private AtomicInteger nextMessageId = new AtomicInteger();
	
	public MqttMessage connect(ChannelHandlerContext ctx, MqttConnectMessage message, String uid, String deptid) {
		
		final String deviceid = message.payload().clientIdentifier();
		final String atoken = message.payload().password();
		final String username = message.payload().userName();
		
//		final int communityId = NumberUtils.toInt(StringUtils.substringBefore(username, ","));
		
		final MqttConnection oldConn = connectionMap.get(deviceid);
		if(oldConn != null && oldConn.ctx != ctx) {
			logger.info("发现该客户端连接已经存在，将断开：{}", new Object[]{deviceid, oldConn.timestamp});
			try {
				oldConn.ctx.close();
			}catch(Exception ex) {
			}
		}
//		AccessToken token = AccessToken.decode(atoken);
//		if(token == null || token.uid <= 0 ) {
		if(uid == null){
			logger.info("MQTT鉴权失败:{},{}", deviceid, atoken);
			throw new MqttIdentifierRejectedException("鉴权失败拒绝连接");
		}
		
		logger.info("连接建立：{},{},{}", username, deviceid, atoken);
		ctx.channel().attr(NETTY_CHANNEL_KEY).set(deviceid);
		
		connectionMap.put(deviceid, new MqttConnection(ctx, deptid, uid));
		
		final MqttConnAckVariableHeader variableHeader = new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, false);
		final MqttFixedHeader fixhedHeader = createFixedHeader(MqttMessageType.CONNACK, 2);
		final MqttMessage ack = MqttMessageFactory.newMessage(fixhedHeader, variableHeader, null);
		return ack;
	}
	
	public MqttMessage hartbeating(ChannelHandlerContext ctx, MqttMessage message) {
		logger.info("心跳：{}", message);
		MqttMessage ack = MqttMessageFactory.newMessage(createFixedHeader(MqttMessageType.PINGRESP, 0), null, null);
		return ack;
	}
	
	public MqttMessage recieveMessage(ChannelHandlerContext ctx, MqttPublishMessage message) {
		final ByteBuf payload = message.payload();
		final byte[] data = new byte[payload.readableBytes()];
		
		payload.readBytes(data);
		
		logger.info("收到PUB消息：{}", new String(data));
		
		if(message.fixedHeader().qosLevel() != MqttQoS.AT_MOST_ONCE) {
			MqttMessageIdVariableHeader variableHeader = MqttMessageIdVariableHeader.from(message.variableHeader().messageId());
			final MqttFixedHeader fixhedHeader = createFixedHeader(MqttMessageType.PUBACK, 4);
			final MqttMessage ack = MqttMessageFactory.newMessage(fixhedHeader, variableHeader, null);
			
			return ack;
		}
		return null;
	}
	
	public MqttMessage ignoreMessage(ChannelHandlerContext ctx, MqttMessage message) {
		logger.info("忽略消息：{}", message);
		return null;
	}
	
	public void pushToAll(String deptid, List<String> uids, String message) {
		try {
			
			final byte[] messageData = message.getBytes();
			
			final MqttPublishVariableHeader vheader = new MqttPublishVariableHeader(TOPIC_NAME, nextMessageId.incrementAndGet());
			final MqttFixedHeader fixedHeader = createFixedHeader(MqttMessageType.PUBLISH, TOPIC_NAME.length() + 4 + messageData.length);
			
			for(final String deviceId : connectionMap.keySet()) {
				final MqttConnection mconn = this.connectionMap.get(deviceId);
				if(uids.contains(mconn.uid)) {
						logger.info("将要推送消息：{},{},{}", deviceId, mconn.deptid, mconn.uid);
						final ByteBuf payload = Unpooled.wrappedBuffer(messageData);
						final MqttMessage pmessage = MqttMessageFactory.newMessage(fixedHeader, vheader, payload);
						mconn.ctx.writeAndFlush(pmessage);
					}else{
						logger.info("无需推送给这个用户{} ,{},{}", deviceId, deptid, mconn);
					}
			}
			
			
		}catch(Exception ex) {
			logger.error("推送消息失败：{}", ex);
		}
	}
	
	public void close(ChannelHandlerContext ctx) {
		final Attribute<String> attr = ctx.channel().attr(NETTY_CHANNEL_KEY);
		final String deviceid = attr.get();
		if(deviceid != null) {
			connectionMap.remove(deviceid);
			attr.remove();
		}
		ctx.close();
	}
	
	private MqttFixedHeader createFixedHeader(MqttMessageType mtype, int remainLength) {
		return new MqttFixedHeader(mtype, false, MqttQoS.AT_LEAST_ONCE, false, remainLength);
	}
	
	
}
