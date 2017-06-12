package com.huaao.ejwplatform.service.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetuiConfig {
	//测试
//	public String appId = "5oApgofFGz6AVA9QksgiB8";
//	public String appKey = "YAuWs0zlY09dzisXlBhjx";
//	public String appSecret = "9dcZMRVp997rMAIHRC25O7";
//	public String masterSecret = "zRSQTItODJ9fQUJy5vRRT2";

	//正式
//	public String appId = "A8veBRtOGA8Nryjzgdou61";
//	public String appKey = "WKkIoqxpHD8jkYGu2Fuuc2";
//	public String appSecret = "VWlur8EzXk98waoUQbq4n";
//	public String masterSecret = "SuvukeNYEx875RWSSgEN06";

	public static String appId;
	public static String appKey;
	public static String appSecret;
	public static String masterSecret;
	
	@Value("${appId}")
	public void setAppId(String appId) {
		GetuiConfig.appId = appId;
	}
	
	@Value("${appKey}")
	public void setAppKey(String appKey) {
		GetuiConfig.appKey = appKey;
	}
	
	@Value("${appSecret}")
	public void setAppSecret(String appSecret) {
		GetuiConfig.appSecret = appSecret;
	}
	
	@Value("${masterSecret}")
	public void setMasterSecret(String masterSecret) {
		GetuiConfig.masterSecret = masterSecret;
	}
}
