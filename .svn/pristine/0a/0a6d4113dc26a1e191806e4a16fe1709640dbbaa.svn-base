package com.huaao.ejwplatform.service.mq;

import io.netty.channel.ChannelHandlerContext;

public class MqttConnection {

	public MqttConnection(final ChannelHandlerContext ctx, final String deptid, final String uid) {
		this.ctx = ctx;
		this.deptid = deptid;
		this.uid = uid;
	}
	
	public final long timestamp = System.currentTimeMillis();
	public final ChannelHandlerContext ctx;
	public final String deptid;
	public final String uid;
}
