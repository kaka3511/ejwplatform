package com.huaao.ejwplatform.service.mq;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.mqtt.MqttDecoder;
import io.netty.handler.codec.mqtt.MqttEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public class MqttServer implements InitializingBean{
	public static final int MQTT_PORT = 33338;
	private static final Logger logger = LoggerFactory.getLogger(MqttService.class);
    @Autowired MqttHandler mqttHandler;
    
    public boolean launch(int port)  {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            final ServerBootstrap b = new ServerBootstrap();
            final ChannelInitializer<SocketChannel> childHandler = new ChannelInitializer<SocketChannel>() {
	            @Override
	            public void initChannel(SocketChannel ch) throws Exception {
	            	ChannelPipeline pipeline = ch.pipeline();

					pipeline.addFirst("idleStateHandler", new IdleStateHandler(60, 0, 60));
					pipeline.addAfter("idleStateHandler", "idleEventHandler", new TimeoutHandler());

					pipeline.addLast("decoder", new MqttDecoder());
					pipeline.addLast("encoder", new MqttEncoder());
					pipeline.addLast("handler", mqttHandler);
	            }
	        };
			b.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
                .childHandler(childHandler).option(ChannelOption.SO_BACKLOG, 128) 
                .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind("0.0.0.0", port);
            f.sync();
            return true;
        } catch(Exception ex){
        	logger.error("启动MQTT线程失败", ex);
        	return false;
        }
    }
    
    public void start() throws Exception {
    	final AtomicBoolean isRunning = new AtomicBoolean(true);
		final Thread thread = new Thread(){
			@Override public void run() {
				
		        try {
					final boolean launch = launch(MQTT_PORT);
					isRunning.set(launch);
				} catch (Exception ex) {
					isRunning.set(false);
					logger.error("启动HTTP监听端口失败", ex);
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(1000);
		if(!isRunning.get()) {
			throw new IllegalArgumentException();
		}else{
			logger.info("启动MQTT端口成功：{}", MQTT_PORT);
			
		}
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		this.start();
	}
}
