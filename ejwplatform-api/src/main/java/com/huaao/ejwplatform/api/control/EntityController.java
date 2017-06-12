package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.Entity;
import com.huaao.ejwplatform.api.dto.entity.DtoEntityDetailRequest;
import com.huaao.ejwplatform.api.dto.entity.DtoEntityListRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwEntityExt;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.service.EntityService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.system.DeptService;

@ApiDescription("站点信息")
@Controller
@RequestMapping("api/entity")
public class EntityController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityService entityService; 
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	
	@ApiDescription("站点列表;负责人：shilei")
	@RequestMapping("list")
	@ResponseBody
	public DtoPublicResponseList<Entity> list(@Valid DtoEntityListRequest req){
		DtoPublicResponseList<Entity> resp =new DtoPublicResponseList<Entity>();
		try{
			SysUser sysUser = userService.queryUser(req.getUid());
			List<SysDeptWithBLOBs> listDept = deptService.getAllDeptByDept(sysUser.getDeptId());
			List<JwEntityExt> resList = entityService.list(null, null, "create_time desc",FuncTool.copyPropertiesByName(listDept, "id"));
			List<Entity> repList = new ArrayList<Entity>();
			for(JwEntityExt je : resList){
				Entity e = new Entity();
				BeanUtils.copyProperties(je, e);
				for(SysDeptWithBLOBs itemDept : listDept){
					if(itemDept.getId().equals(e.getDeptId())){
						e.setDeptName(itemDept.getName());
					}
				}
				repList.add(e);
			}
			resp.setData(repList);
			resp.setCode(Constants.API_CODE_SUCCESS);//0
		}catch(Exception e){
			e.printStackTrace();
			log.error("get Entity list fail", e);
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("查询站点失败");
		}
		return resp;
	}
	
	@ApiDescription("站点详情;负责人：shilei")
	@RequestMapping("detail")
	@ResponseBody
	public DtoPublicResponseObj<Entity> detail(@Valid DtoEntityDetailRequest req){
		DtoPublicResponseObj<Entity> resp =new DtoPublicResponseObj<Entity>();
		try{
			JwEntityExt je = entityService.queryById(req.getId());
			resp.setCode(Constants.API_CODE_SUCCESS);//0
			Entity e = new Entity();
			BeanUtils.copyProperties(je, e);
			SysDeptWithBLOBs sysDept = deptService.getDeptById(e.getDeptId());
			if(sysDept != null){
				e.setDeptName(sysDept.getName());
			}
			resp.setData(e);
		}catch(Exception e){
			log.error("get Entity detail fail", e);
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("查询站点失败");
		}
		return resp;
	}
}
