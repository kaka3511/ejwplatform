package com.huaao.ejwplatform.service.websocket;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SocketServer implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
    private SocketIoService service;
	
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//          public void run() {
            //启动socket监听
//              try{
                  if(service.getServer() == null){
                      new Thread(new Runnable() {
                          @Override
                          public void run() {
                              try {
                                  service.startServer();
                              } catch (InterruptedException e) {
                                  e.printStackTrace();
                              }
                          }
                      }).start();
                  }
//              }catch(Exception e){
//              }
//          }
//        }, delay,cacheTime);// 这里设定将延时每天固定执行

    }
                  
}
