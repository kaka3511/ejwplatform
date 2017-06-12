package com.huaao.ejwplatform.api.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.MenuDto;
import com.huaao.ejwplatform.service.SysMenuService;

@ApiDescription("用户信息")
@Controller
@RequestMapping("api/menu")
public class MenuController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SysMenuService sysMenuService;
	
	@ApiDescription("查询用户菜单;负责人：shilei")
	@RequestMapping(value="user/list",method=RequestMethod.GET)
	@ResponseBody
	public DtoPublicResponseList<MenuDto> list(DtoPublicRequest req){
		DtoPublicResponseList<MenuDto> resp = new DtoPublicResponseList<MenuDto>();
		try{
			List<MenuDto> resList = sysMenuService.getUserMenu(req.getUid());
			resp.setCode(Constants.API_CODE_SUCCESS);//0
			resp.setData(resList);
		}catch(Exception e){
			log.error("", e);
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("获取用户菜单失败");
		}
		
		return resp;
	}
	
}
