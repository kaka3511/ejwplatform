package com.huaao.ejwplatform.api.control.system;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.service.UserService;

@Controller
@RequestMapping("api/token")
public class TokenController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@ApiDescription("根据token获取用户;负责人：shilei")
	@RequestMapping("findUserByToken")
	@ResponseBody
	public DtoPublicResponseObj<Map<String, Object>> findUserByToken(DtoPublicRequest req){
		DtoPublicResponseObj<Map<String, Object>> resp = new DtoPublicResponseObj<Map<String, Object>>();
		try {
			Map<String, Object> data = userService.login(req.getUid(), true, true, true, true, true, true, false);
			resp.setData(data);
			resp.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			log.error("findUserByToken fail",e);
			resp.setCode(Constants.API_CODE_FAIL);
			resp.setMsg(Constants.API_MSG_SERVER_ERROR);
		}
		return resp;
	}
	
}
