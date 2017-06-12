package com.huaao.ejwplatform.api.control.socket;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.service.websocket.SocketIoService;

@ApiDescription("socket状态接口")
@Controller
@RequestMapping("/api/socket")
public class SocketIoController {
    @Autowired
    private SocketIoService service;
    
    @ApiDescription("重启socket服务端;负责人：jinsu")
    @RequestMapping("startServer")
    @ResponseBody
    public DtoPublicResponse startServer(@Valid DtoPublicRequest dtoRequest) throws Exception{
    	DtoPublicResponse resp = new DtoPublicResponse();
        try {
            if(service.getServer() == null){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        try {
                            service.startServer();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resp.setCode(500);
            resp.setMsg("socket服务启动失败");
        }
        return resp;
    }
    
    @ApiDescription("查看socket服务状态;负责人：jinsu")
    @RequestMapping("serverStatus")
    @ResponseBody
    public DtoPublicResponseObj serverStatus(@Valid DtoPublicRequest dtoRequest) throws Exception{
    	DtoPublicResponseObj resp = new DtoPublicResponseObj();
        try {
            if(service.getServer() != null){

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resp.setCode(500);
            resp.setMsg("查询socket状态失败");
        }
        return resp;
    }
    
    @ApiDescription("停止socket服务端;负责人：jinsu")
    @RequestMapping("stopServer")
    @ResponseBody
    public DtoPublicResponse stopServer(@Valid DtoPublicRequest dtoRequest) throws Exception{
    	DtoPublicResponse resp = new DtoPublicResponse();
        try {
            if(service.getServer() != null){
                service.stopServer();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resp.setCode(500);
            resp.setMsg("停止socket服务失败");
        }
        return resp;
    }
    
    @ApiDescription("给指定的客户端推送消息;负责人：jinsu")
    @RequestMapping("sendMsg")
    @ResponseBody
    public DtoPublicResponse sendMsg(@Valid DtoPublicRequest dtoRequest, @RequestParam("uid") String uid) throws Exception{
    	DtoPublicResponse resp = new DtoPublicResponse();
        try {
            if(service.getServer() != null && !StringUtils.isEmpty(uid)){
                service.sendMessageToUser(uid, SocketIoService.SOCKET_MSG_TEST, "测试socket推送消息");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resp.setCode(500);
            resp.setMsg("停止socket服务失败");
        }
        return resp;
    }
}
