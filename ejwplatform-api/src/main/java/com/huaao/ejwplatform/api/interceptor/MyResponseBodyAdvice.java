package com.huaao.ejwplatform.api.interceptor;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.util.JsonDateValueProcessor;
import com.huaao.ejwplatform.dao.SysLogsRequestWithBLOBs;
import com.huaao.ejwplatform.mapper.SysLogsRequestMapper;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

@ControllerAdvice
public class MyResponseBodyAdvice  implements ResponseBodyAdvice<Object>{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private static JsonConfig jsonConfig = new JsonConfig();  
	private static Set<String> filterApi = new HashSet<>();
	static{
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());  
		jsonConfig.registerJsonValueProcessor(String.class, new JsonShortValueProcessor());
	}
	@Autowired
	private SysLogsRequestMapper mapper;
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return DtoPublicResponse.class.isAssignableFrom(returnType.getMethod().getReturnType()); 
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		HttpServletRequest httpRequest = ((ServletServerHttpRequest)request).getServletRequest();
		try {
			DtoPublicResponse dpr = (DtoPublicResponse) body;
			dpr.setReqId(String.valueOf(httpRequest.getAttribute(Constants.REQUEST_ID)));
			
			boolean filterFlag = false;
			for(String filter : filterApi) {
				if(filter.contains("*") && httpRequest.getRequestURI().startsWith(filter.substring(0, filter.length()-1))){
					filterFlag = true;
				}
				if(httpRequest.getRequestURI().equals(filter)){
					filterFlag = true;
				}
			}
			
			if(!filterFlag){
				//先将请求和输出结果存入数据库，后续使用缓存
				SysLogsRequestWithBLOBs slr = new SysLogsRequestWithBLOBs();
				slr.setReqId(dpr.getReqId());
				slr.setApi(httpRequest.getRequestURI());
				slr.setIp(FuncTool.getIp(httpRequest));
				slr.setReturnCode(dpr.getCode());
				int runtime = (int)(DateTool.nowTimeStap() - Long.parseLong(httpRequest.getAttribute(Constants.REQUEST_TIME).toString()));
				slr.setRunTime(runtime);
				
				String requestParams = showParams(httpRequest).toString();
				int requestLen = (requestParams.length()/1024) ;
				slr.setRequestLen(requestLen);
				if(requestLen < 5){
					slr.setRequestParams(requestParams);
				}
				String responseParams = JSONUtil.jsonEncode(dpr);
//				String responseParams = JSONObject.fromObject(dpr).toString();
				int responseLen = (responseParams.length()/1024);
				slr.setResponseLen(responseLen);
				if(responseLen < 5){
					slr.setResponseContent(responseParams);
				}
				if(httpRequest.getAttribute(Constants.ERROR_TRACE) != null){
					slr.setErrorTrace(httpRequest.getAttribute(Constants.ERROR_TRACE).toString());
				}
				mapper.insertSelective(slr);
			}
			return dpr;
		} catch (Exception e) {
			log.error(String.valueOf(httpRequest.getAttribute(Constants.REQUEST_ID)), e);
			return body;
		}
	}

	private JSONObject showParams(HttpServletRequest request) {
		JSONObject jo = new JSONObject();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String str = request.getParameter(paramName);
            jo.put(paramName, str);
        }
        return jo;
    } 
}
class JsonShortValueProcessor implements JsonValueProcessor {  
    
    public JsonShortValueProcessor() {  
        super();  
    }  
    @Override  
    public Object processArrayValue(Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
    @Override  
    public Object processObjectValue(String paramString, Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
    private Object process(Object value){  
        if(value!=null && value instanceof String){    
            String str = value.toString();
            if(str.length() > 100){
            	return str.substring(0,100)+"...";
            }
        }    
        return value ;    
    }  
}  