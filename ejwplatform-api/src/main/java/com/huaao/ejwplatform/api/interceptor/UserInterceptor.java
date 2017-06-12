package com.huaao.ejwplatform.api.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.service.UserService;

public class UserInterceptor implements HandlerInterceptor{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Value("${checktoken}")
	private String checktoken;
	
	/*@Autowired
	private RestTemplate restTemplate;*/
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getRequestURI().startsWith("/api/systemtool") || request.getRequestURI().startsWith("/api/auth") || request.getRequestURI().startsWith("/api/sdk")
				|| request.getRequestURI().startsWith("/api/html/getContent")){
			return true;
		}
		
		if("true".equals(checktoken)){
			String token = request.getParameter(Constants.apiUserToken);
			if(StringUtils.isBlank(token)){
				return getInvalidTokenResp(response, "Token canot null");
			}
			try{
				String uid = userService.getUidByToken(token);
				if(StringUtils.isBlank(uid)){
					return getInvalidTokenResp(response, "Token invalid");
				}
				request.setAttribute(Constants.userId, uid);
			}catch(Exception e){
				log.error("check token fail", e);
				return getInvalidTokenResp(response, e.getMessage());
			}
		}else{
			if(!StringUtils.isBlank(request.getParameter(Constants.apiUserToken))){
				if(request.getParameter(Constants.apiUserToken).length() > 32){
					request.setAttribute(Constants.userId, userService.getUidByToken(request.getParameter(Constants.apiUserToken)));
				}else{
					request.setAttribute(Constants.userId, request.getParameter(Constants.apiUserToken));
				}
			}
			
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	private boolean getInvalidTokenResp(HttpServletResponse response, String msg) throws Exception{
		DtoPublicResponse dpr = DtoPublicResponse.fail(msg);
		dpr.setCode(Constants.API_CODE_TOKEN_INVALID);
		response.getWriter().write(JSONUtil.jsonEncode(dpr));
		return false;
	}
	
}
