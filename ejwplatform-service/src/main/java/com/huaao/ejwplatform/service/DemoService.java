package com.huaao.ejwplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.redis.RedisTool;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.UserTest;
import com.huaao.ejwplatform.dao.UserTestExample;
import com.huaao.ejwplatform.mapper.UserTestMapper;

@Service
public class DemoService {

	@Autowired
	private UserTestMapper userTestMapper;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	 
	public boolean checkLogin(String account,String password) throws Exception{
		if("2".equals(account)){
			//自定义异常
			throw SystemException.init("账号已经存在");
		}
		if("3".equals(account)){
			//数据库异常
			String id = userTestMapper.test(account,password); 
		}
		if("4".equals(account)){
			//空异常
			Object o = null;
			o.toString();
		}
		return false;
	}
	
	public void insert(String account,String password){
		UserTest userTest = new UserTest();
		userTest.setAccount(account);
		userTest.setPassword(password);
		userTestMapper.insert(userTest);
	}
	
	public List<UserTest> listUser(){
		//使用自动生成的工具类
		UserTestExample example = new UserTestExample();
//		可添加条件
//		example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password); 
		return userTestMapper.selectByExample(example);
	}
	
	public void delete(String userId){
		userTestMapper.deleteByPrimaryKey(Integer.parseInt(userId));
	}
	
	public long test(){
		return RedisTool.generatorId("user_test", stringRedisTemplate.getConnectionFactory());
	}
}
