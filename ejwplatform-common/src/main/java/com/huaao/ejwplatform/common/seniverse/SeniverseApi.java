package com.huaao.ejwplatform.common.seniverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SeniverseApi {
	//新知天气API
	//查最近几天
	private final static String TIANQI_DAILY_WEATHER_URL = "https://api.seniverse.com/v3/weather/daily.json";
	//查当天
	private final static String TIANQI_NOW_WEATHER_URL = "https://api.seniverse.com/v3/weather/now.json";

    private final static String TIANQI_API_SECRET_KEY = "voddebzvjucjd0bo"; //

    private final static String TIANQI_API_USER_ID = "U01C0BCFA9"; //
    
    public static Map<String, String> getSeniverse(){
		Map<String, String> seniverse = new HashMap<String, String>();
		seniverse.put("key", TIANQI_API_SECRET_KEY);
		seniverse.put("uid", TIANQI_API_USER_ID);
		return seniverse;
	}
    

	public static String generateGetDiaryWeatherURL(
            String location,
            String language,
            String unit,
            String start,
            String days,
            String url,
            String key,
            String uid
    )  throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(new Date().getTime());
        String params = "ts=" + timestamp + "&ttl=30&uid=" + uid;
        String signature = URLEncoder.encode(generateSignature(params, key), "UTF-8");
        return url + "?" + params + "&sig=" + signature + "&location=" + location + "&language=" + language + "&unit=" + unit + "&start=" + start + "&days=" + days;
    }
	
	public static String generateGetNowWeatherURL(
            String location,
            String language,
            String unit,
            String url,
            String key,
            String uid
    )  throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(new Date().getTime());
        String params = "ts=" + timestamp + "&ttl=30&uid=" + uid;
        String signature = URLEncoder.encode(generateSignature(params, key), "UTF-8");
        return url + "?" + params + "&sig=" + signature + "&location=" + location + "&language=" + language + "&unit=" + unit ;
    }
	
	private static String generateSignature(String data, String key) throws SignatureException {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
            result = new sun.misc.BASE64Encoder().encode(rawHmac);
        }
        catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }
	
	public static String getWeatherInfo(String url) {

		String seniverseUrl =url;
		StringBuffer strBuf;

		strBuf = new StringBuffer();

		try {
			URL urlT = new URL(seniverseUrl);
			URLConnection conn = urlT.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));// 转码。
			String line = null;
			while ((line = reader.readLine()) != null)
				strBuf.append(line + " ");
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return strBuf.toString();
	}

	public static String getTIANQI_DAILY_WEATHER_URL() {
		return TIANQI_DAILY_WEATHER_URL;
	}

	public static String getTIANQI_NOW_WEATHER_URL() {
		return TIANQI_NOW_WEATHER_URL;
	}
	
	public static String getTIANQI_API_SECRET_KEY() {
		return TIANQI_API_SECRET_KEY;
	}



	public static String getTIANQI_API_USER_ID() {
		return TIANQI_API_USER_ID;
	}


    
}
