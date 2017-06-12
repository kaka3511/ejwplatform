package com.huaao.ejwplatform.api.control;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.ToDoNumInfo;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.service.ToDoService;

@ApiDescription("待办事宜")
@Controller
@RequestMapping("api/todolist")
public class ToDoListController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ToDoService toDoService;
	

	@RequestMapping("queryToDoListNum")
	@ResponseBody
	@ApiDescription("查询待办事宜数目;负责人：luping")
	public DtoPublicResponseObj<ToDoNumInfo> queryToDoListNum(@Valid DtoPublicRequest dtoRequest) throws Exception {
		DtoPublicResponseObj<ToDoNumInfo> ar = new DtoPublicResponseObj<>();
		//警情
		ToDoNumInfo doNumInfo = new ToDoNumInfo();
		doNumInfo.setSumToDo(toDoService.queryToDoListNum(dtoRequest.getUid()));
		ar.setData(doNumInfo);
		return ar;
	}

}
