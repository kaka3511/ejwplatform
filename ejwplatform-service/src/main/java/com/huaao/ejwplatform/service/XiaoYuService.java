package com.huaao.ejwplatform.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.util.HttpClientUtils;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.util.MapBuilder;
import com.huaao.ejwplatform.service.model.XiaoYuMeeting;

@Service
public class XiaoYuService {
	 private static final Logger logger = LoggerFactory.getLogger(XiaoYuService.class);

//		@Autowired
//		XiaoyuConfig xiaoYuConfig;

	    private static String enterpriseId = "ff8ae6e00aa747752763ed4b57a9e3cfccab3a55";
	    private static String appId = "BMCBURDUJOST";
	    private static String token = "532151d7efa453789faa06c1a5822656815a9ed85e21f1defba30c9b7e4b51ff";

	    public final String URL = "https://www.ainemo.com/api/rest/external/v1";

	    public XiaoYuMeeting createMeeting(String name, long starttime, long endtime, int max_participant) {


	        final String url = String.format("%s/create_meeting", URL);
	        String signature;
	        try {
	            signature = String.format("GET\ncreate_meeting\n%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s\n47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=",
	                    URLEncoder.encode("end_time", "UTF-8"),
	                    URLEncoder.encode(String.valueOf(endtime), "UTF-8"),
	                    URLEncoder.encode("enterprise_id", "UTF-8"),
	                    URLEncoder.encode(enterpriseId, "UTF-8"),
	                    URLEncoder.encode("max_participant", "UTF-8"),
	                    URLEncoder.encode(String.valueOf(max_participant), "UTF-8"),
	                    URLEncoder.encode("meeting_name", "UTF-8"),
	                    URLEncoder.encode(name, "UTF-8"),
	                    URLEncoder.encode("require_password", "UTF-8"),
	                    URLEncoder.encode("false", "UTF-8"),
	                    URLEncoder.encode("start_time", "UTF-8"),
	                    URLEncoder.encode(String.valueOf(starttime), "UTF-8"));
	        } catch (UnsupportedEncodingException e) {
	            return null;
	        }

	        logger.info("signature:{}", signature);

	        try {
	            signature = calculateHMAC(signature, token);
	        } catch (SignatureException e) {
	            return null;
	        }
	        signature = signature.trim();

	        logger.info("signature:{}", signature);

//	        try {
//	            signature = URLEncoder.encode(signature, "UTF-8");
//	        } catch (UnsupportedEncodingException e) {
//	            return null;
//	        }

//	        logger.info("signature:{}", signature);

	        Map<String, String> params = new MapBuilder<String, String>()
	                .put("enterprise_id", enterpriseId)
	                .put("meeting_name", name)
	                .put("start_time", String.valueOf(starttime))
	                .put("end_time", String.valueOf(endtime))
	                .put("max_participant", String.valueOf(max_participant))
	                .put("require_password", "false")
	                .put("signature", signature)
	                .build();


	        final String response = HttpClientUtils.httpGet(url, params);

	        logger.info("response:{}", response);

	        return JSONUtil.decodeJson(response, XiaoYuMeeting.class);
	    }

	    public static String calculateHMAC(String data, String key) throws java.security.SignatureException {
	        final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
	        String result;
	        try {
	            // Get an hmac_sha256 key from the raw key bytes.
	            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF8"), HMAC_SHA256_ALGORITHM);
	            // Get an hmac_sha256 Mac instance and initialize with the signing key.
	            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
	            mac.init(signingKey);
	            // Compute the hmac on input data bytes.
	            byte[] rawHmac = mac.doFinal(data.getBytes("UTF8"));
	            // Base64-encode the hmac by using the utility in the SDK
	            result = Base64.encodeBase64String(rawHmac);
	        } catch (Exception e) {
	            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
	        }
	        return result;
	    }
}
