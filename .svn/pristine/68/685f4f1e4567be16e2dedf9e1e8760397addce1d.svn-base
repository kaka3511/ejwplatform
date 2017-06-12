package com.huaao.ejwplatform.api.control;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.DemoUserInfo;
import com.huaao.ejwplatform.api.dto.demo.DemoUserDeleteRequest;
import com.huaao.ejwplatform.api.dto.demo.DemoUserInsertRequest;
import com.huaao.ejwplatform.api.dto.demo.DemoUserLoginRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.UserTest;
import com.huaao.ejwplatform.service.DemoService;

@Controller 
@RequestMapping(value = { "/api/demo" })
public class DemoController  {

	@Autowired
	private DemoService testService; 
	
	@RequestMapping("/userLogin.do")
    @ResponseBody
    public DtoPublicResponse UserLogin(@Valid DemoUserLoginRequest dto) throws Exception{
		if("1".equals(dto.getAccount())){
			throw SystemException.init("账号错误");
		}
		testService.checkLogin(dto.getAccount(), dto.getPassword());
		return DtoPublicResponse.init();
	}
	
	@RequestMapping("/userInsert.do")
    @ResponseBody
    public DtoPublicResponse userInsert(DemoUserInsertRequest rqt) throws Exception{
		testService.insert(rqt.getAccount(), rqt.getPassword());
		return  DtoPublicResponse.init();
	}
	
	@RequestMapping("/userDelete.do")
    @ResponseBody
    public DtoPublicResponse userDelete(DemoUserDeleteRequest rqt) throws Exception{
		testService.delete(rqt.getUserId());
		return  DtoPublicResponse.init();
	}
	
	@RequestMapping("/userList.do")
    @ResponseBody
    public DtoPublicResponsePager<DemoUserInfo> UserList(DtoPublicRequestPager rqt) throws Exception{
		DtoPublicResponsePager<DemoUserInfo> rps = new DtoPublicResponsePager<>();
		List<UserTest> list = testService.listUser();
		rps.setPage(rqt.getPage());
		rps.setRecords(list.size());
		for(UserTest user : list){
			DemoUserInfo item = new DemoUserInfo();
			BeanUtils.copyProperties(user,item);
			rps.addData(item);
		}
		return  rps ;
	}
	
	@RequestMapping("/userTest.do")
    @ResponseBody
    public DtoPublicResponse userTest(DtoPublicRequest dto) throws Exception{
		return DtoPublicResponse.init(String.valueOf(testService.test()));
	}
}
