package com.huaao.ejwplatform.service.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.mqtt.MqttConnectMessage;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;


@Sharable
public class MqttHandler extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttHandler.class);
	
	@Autowired MqttService mqttService;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		MqttMessage resMessage = null;
		try {
			final MqttMessage message = (MqttMessage)msg;
			final MqttMessageType mtype = message.fixedHeader().messageType();
			switch(mtype) {
			case CONNECT:
				MqttConnectMessage connMessage = (MqttConnectMessage)message;
				resMessage = mqttService.connect(ctx, connMessage, "", "");
				break;
			case PINGREQ:
				resMessage = mqttService.hartbeating(ctx, message);
				break;
			case PUBLISH:
				MqttPublishMessage publishMessage = (MqttPublishMessage)message;
				resMessage = mqttService.recieveMessage(ctx, publishMessage);
				break;
			default:
				resMessage = mqttService.ignoreMessage(ctx, message);
				break;
			}
			if(resMessage != null) {
				logger.info("发送消息:{}", resMessage);
				ctx.writeAndFlush(resMessage);
			}
		}catch(Exception ex) {
			try{
				ctx.close();
			}catch(Exception ex1){
			}
			logger.error("处理消息{}失败", msg);
			logger.error("", ex);
			
		}
	}
	
	
	
	@Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		this.mqttService.close(ctx);
    }
	
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        this.mqttService.close(ctx);
    }
}
