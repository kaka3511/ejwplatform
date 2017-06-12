package com.huaao.ejwplatform.service.mq;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TimeoutHandler extends ChannelDuplexHandler {
	private static final Logger logger=LoggerFactory.getLogger(TimeoutHandler.class);
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState e = ((IdleStateEvent) evt).state();
            if(e == IdleState.READER_IDLE){
            	String deviceId = null;
        		logger.info("TIMEOUT:{},{}", deviceId, ctx.channel().remoteAddress());
                ctx.close();
            }
        }
    }
    
    @Override
    public boolean isSharable() {
    	return true;
    }
}
