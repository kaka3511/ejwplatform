package com.huaao.ejwplatform.common.util;

import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.security.Encrypt;

public class TokenUtil {
	
	public static String createToken(String uid){
		StringBuffer buff = new StringBuffer();
		buff.append("id_"+uid);
		buff.append("version_" + Constants.Version);
		byte[] encryptResult = Encrypt.encrypt(buff.toString());
		String encryptResultStr = Encrypt.parseByte2HexStr(encryptResult);
		return encryptResultStr;
	}
}
