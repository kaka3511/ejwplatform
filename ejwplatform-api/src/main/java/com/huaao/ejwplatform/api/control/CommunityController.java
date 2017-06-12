package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.dom4j.io.DocumentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.MonitorDeviceInfo;
import com.huaao.ejwplatform.api.dto.bean.MonitorGroupInfo;
import com.huaao.ejwplatform.api.dto.bean.MonitorInfo;
import com.huaao.ejwplatform.api.dto.community.DtoEntitiesGroupRequest;
import com.huaao.ejwplatform.api.dto.community.DtoMonitorDeviceRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwMonitor;
import com.huaao.ejwplatform.dao.JwMonitorDevice;
import com.huaao.ejwplatform.dao.JwMonitorGroup;
import com.huaao.ejwplatform.service.CommunityService;
import com.huaao.ejwplatform.service.UserService;

@ApiDescription("社区信息")
@Controller
@RequestMapping("api/community")
public class CommunityController {

	@Autowired
	private CommunityService service;
	@Autowired 
	private UserService userService;
	
	@ApiDescription("监控设备分组查询;负责人:lihao")
	@RequestMapping("monitorGroups")
	@ResponseBody
	public DtoPublicResponseList<MonitorGroupInfo> monitorGroups(@Valid DtoEntitiesGroupRequest dtoRequest) throws Exception {
		DtoPublicResponseList<MonitorGroupInfo> dtoResponse = new DtoPublicResponseList<>();
		String deptId = userService.getUserById(dtoRequest.getUid()).getDeptId();
		List<JwMonitorGroup> listGroup = service.queryMonitorGroupByDeptId(null, deptId);
		List<JwMonitor> listMonitor = service.queryMonitorByDeptId(null, deptId);
		List<MonitorGroupInfo> listGroupInfo = FuncTool.copyPropertiesList(listGroup, MonitorGroupInfo.class);
		for(MonitorGroupInfo item : listGroupInfo){
			List<MonitorInfo> listInfo = new ArrayList<>();
			for(JwMonitor jm : listMonitor){
				if(item.getId().equals(jm.getGroupid())){
					listInfo.add(FuncTool.copyPropertiesClass(jm, MonitorInfo.class));
				}
			}
			item.setMonitors(listInfo);
		}
		dtoResponse.setData(listGroupInfo);
 		return dtoResponse;
	}
	
	@ApiDescription("监控设备详细信息 ;负责人:lihao")
	@RequestMapping("monitorDevice")
	@ResponseBody
	public DtoPublicResponseObj<MonitorDeviceInfo> monitorDevice(@Valid DtoMonitorDeviceRequest dtoRequest) throws Exception {
		DtoPublicResponseObj<MonitorDeviceInfo> dtoResponse = new DtoPublicResponseObj<>();
		JwMonitorDevice jw = service.queryMonitorDeviceById(dtoRequest.getMonitorDeviceId());
		dtoResponse.setData(FuncTool.copyPropertiesClass(jw, MonitorDeviceInfo.class));
		return dtoResponse;
	}
	
	
}
