package com.huaao.ejwplatform.service.sms;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.dao.SysSmsCode;
import com.huaao.ejwplatform.mapper.SysSmsCodeMapper;

@Service
public class SmsService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private SysSmsCodeMapper sysSmsCodeMapper;

	@Value("${redis.save}")
	private boolean flg;
	/**
	 * 检查验证码
	 * @param phone
	 * @param code
	 * @return true 对应验证号码 false 验证码错误
	 */
	public boolean checkSmsCode(String phone, String code, String type) {
		String val = stringRedisTemplate.opsForValue().get(Constants.CACHE_SMS_CODE+"_"+type+"_"+phone);
		return StringUtils.isNotBlank(val)&&val.equals(code);
	}
	
	public void cashSmsCode(String phone, String code , String type){
		stringRedisTemplate.opsForValue().set(Constants.CACHE_SMS_CODE+"_"+type+"_"+phone, code, 120, TimeUnit.SECONDS);
		if(flg){
			SysSmsCode ssc= new SysSmsCode();
			ssc.setId(FuncTool.createUUID());
			ssc.setCreateTime(new Date());
			ssc.setCode(code);
			ssc.setPhone(phone);
			ssc.setType(type);
			sysSmsCodeMapper.insertSelective(ssc);
		}
	}
	
	
	
	
}
