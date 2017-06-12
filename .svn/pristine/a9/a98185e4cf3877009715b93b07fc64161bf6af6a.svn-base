package com.huaao.ejwplatform.api.control;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.validation.Valid;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.analysis.DtoDeptAlertInfoRequest;
import com.huaao.ejwplatform.api.dto.analysis.DtoGetAlertChartRequest;
import com.huaao.ejwplatform.api.dto.analysis.DtoGetAlertProcessChartRequest;
import com.huaao.ejwplatform.api.dto.analysis.DtoGetAlertSummaryRequest;
import com.huaao.ejwplatform.api.dto.analysis.DtoGetPoliceAreaChartRequest;
import com.huaao.ejwplatform.api.dto.analysis.DtoGetPoliceChartRequest;
import com.huaao.ejwplatform.api.dto.bean.AlertItem;
import com.huaao.ejwplatform.api.dto.bean.analysis.AlertDoneBarChar;
import com.huaao.ejwplatform.api.dto.bean.analysis.AlertDoneLineChar;
import com.huaao.ejwplatform.api.dto.bean.analysis.AlertDonePaiChart;
import com.huaao.ejwplatform.api.dto.bean.analysis.DeptAlerts;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetAlertChart;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetAlertChartBar;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetAlertMapChart;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetAlertProcessChart;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetAlertProcessChartCategory;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetAlertSummary;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetPoliceArea;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetPoliceAreaBar;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetPoliceCharBar;
import com.huaao.ejwplatform.api.dto.bean.analysis.GetPoliceChart;
import com.huaao.ejwplatform.api.dto.bean.analysis.PieDept;
import com.huaao.ejwplatform.api.dto.bean.analysis.PieJob;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.BMapUtils;
import com.huaao.ejwplatform.common.web.CoordConvert;
import com.huaao.ejwplatform.common.web.Point;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.JwAlert;
import com.huaao.ejwplatform.dao.JwAlertExample;
import com.huaao.ejwplatform.dao.SysAppointedRecord;
import com.huaao.ejwplatform.dao.SysAppointedRecordExample;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDict;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.mapper.JwAlertMapper;
import com.huaao.ejwplatform.mapper.SysAppointedRecordMapper;
import com.huaao.ejwplatform.service.AlertService;
import com.huaao.ejwplatform.service.AnalysisService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.model.CommonDict;
import com.huaao.ejwplatform.service.system.DeptService;
import com.huaao.ejwplatform.service.system.DictService;

@ApiDescription("警情,警力统计")
@Controller
@RequestMapping("api/analysis")
public class AnalysisController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	/************************* shilei   **************************/
	@Autowired
	private AnalysisService analysisService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private AlertService alertService;
	
	@Autowired
	private JwAlertMapper jwAlertMapper;
	
	@Autowired
	private SysAppointedRecordMapper sysAppointedRecordMapper;
	
	@Autowired
	private DictService dictService;
	
	@ApiDescription("统计概要数据接口;负责人：shilei")
	@RequestMapping(value="getAlertSummary")
	@ResponseBody
	public DtoPublicResponseObj<GetAlertSummary> getAlertSummary(@Valid DtoGetAlertSummaryRequest dtoRequest) throws Exception{
		
		DtoPublicResponseObj<GetAlertSummary> resp = new DtoPublicResponseObj<GetAlertSummary>();
			Map<String,String> resMap = null;
			int type = Integer.parseInt(dtoRequest.getType());
			switch (type) {
		        case 1:
		        	resMap = analysisService.getAlertSummary(dtoRequest.getUid());
		        	break;
		        case 2:
		        	resMap = analysisService.getPolicySummary(dtoRequest.getUid());
		        	break;
		        case 3:
		        	resMap = analysisService.getAlertHandleSummary(dtoRequest.getUid());
		        	break;
		        default:
	        }
			
			GetAlertSummary gas = new GetAlertSummary();
			gas.setDay(resMap.get("day"));
			gas.setWeek(resMap.get("week"));
			gas.setMonth(resMap.get("month"));
			gas.setQuart(resMap.get("quarter"));
			gas.setAll(resMap.get("all"));
			resp.setData(gas);
			resp.setCode(Constants.API_CODE_SUCCESS);
		
		return resp;
	}
	
	@ApiDescription("辖区警情分布接口;负责人：shilei")
	@SuppressWarnings("unchecked")
	@RequestMapping(value="getAlertChart")
	@ResponseBody
	public DtoPublicResponseObj<GetAlertChart> getAlertChart(DtoGetAlertChartRequest dtoRequest) throws Exception{
		DtoPublicResponseObj<GetAlertChart> resp = new DtoPublicResponseObj<GetAlertChart>();
			Map<String, Object> map = analysisService.getAlertChart(dtoRequest.getUid(), dtoRequest.getDeptId(),
					DateTool.getDateByAddDays(dtoRequest.getStartTime(), DateTool.NORMAL_DATE_FORMAT, null, 0), 
					DateTool.getDateByAddDays(dtoRequest.getEndTime(), DateTool.NORMAL_DATE_FORMAT, null, 1));
			
			GetAlertChart gac = new GetAlertChart();
			GetAlertChartBar bar = new GetAlertChartBar();
			bar.setAlerts((List<String>) map.get("alerts"));
			gac.setBar(bar);
			
			List<Map> mapList = (List<Map>)map.get("pie");
			List<PieDept> pieList = new ArrayList<>();
			for(Map m : mapList){
				PieDept pd = new PieDept();
				pd.setDeptName(m.get("name").toString());
				pd.setCount(Integer.parseInt(m.get("total").toString()));
				pieList.add(pd);
			}
			gac.setPie(pieList);
			resp.setData(gac);
		return resp;
	}
	
	@ApiDescription("警情处理分析接口;负责人：shilei")
	@SuppressWarnings("unchecked")
	@RequestMapping(value="getAlertProcessChart")
	@ResponseBody
	public DtoPublicResponseObj<GetAlertProcessChart> getAlertProcessChart(DtoGetAlertProcessChartRequest dtoRequest)  throws Exception{
		DtoPublicResponseObj<GetAlertProcessChart> resp = new DtoPublicResponseObj<GetAlertProcessChart>();
			Map<String, Object> map = analysisService.getAlertProcessChart(dtoRequest.getUid(), dtoRequest.getDeptId(),
					DateTool.getDateByAddDays(dtoRequest.getStartTime(), DateTool.NORMAL_DATE_FORMAT, null, 0), 
					DateTool.getDateByAddDays(dtoRequest.getEndTime(), DateTool.NORMAL_DATE_FORMAT, null, 1));
			
			GetAlertProcessChart gapc = new GetAlertProcessChart();
			GetAlertProcessChartCategory apcc = new GetAlertProcessChartCategory();
			apcc.setAll((List<String>) map.get("all"));
			apcc.setDone((List<String>) map.get("done"));
			apcc.setUndo((List<String>) map.get("undone"));
			apcc.setSatisfy((List<String>) map.get("satisfy"));
			apcc.setTotalSatisfy((String)map.get("totalSatisfy"));
			gapc.setCategory(apcc);
			List<Map> mapList = (List<Map>)map.get("pie");
			List<PieDept> pieList = new ArrayList<>();
			for(Map m : mapList){
				PieDept pd = new PieDept();
				pd.setDeptName(m.get("name").toString());
				pd.setCount(Integer.parseInt(m.get("total").toString()));
				pieList.add(pd);
			}
			gapc.setPie(pieList);
			resp.setData(gapc);
		
		return resp;
	}
	
	/************************* lihao  **************************/
	@Autowired
	private UserService user_service;
	@Autowired
	private DeptService dept_service;
	
	@ApiDescription("警力资源分析接口;负责人：lihao")
	@RequestMapping(value="getPoliceAreaChart")
	@ResponseBody
	public DtoPublicResponseObj<GetPoliceArea> getPoliceAreaChart(@Valid DtoGetPoliceAreaChartRequest dtoRequest) throws Exception{
		DtoPublicResponseObj<GetPoliceArea> dtoResponse = new DtoPublicResponseObj<>();
			SysUser sysUser = user_service.queryUser(dtoRequest.getUid());
			List<SysDeptWithBLOBs> deptList = null;
			
			SysDeptWithBLOBs sd = null;
			boolean lowestDept = false;
			if(!StringUtils.isEmpty(dtoRequest.getDeptId()) ){
				sd = dept_service.getDeptById(dtoRequest.getDeptId());
				deptList = dept_service.getDeptSubDept(sd);
				//如果是最低部门，则显示部门自己
				if(sd.getLevel() == CommonDict.DEPT_LEVEL_LOWEST){
					lowestDept = true;
					deptList.add(sd);
				}
//				deptList = dept_service.getAllDeptByDept(dtoRequest.getDeptId());
			}else{
				deptList = user_service.queryUserSubDept(sysUser);
				sd = dept_service.getDeptById(sysUser.getDeptId());
				//如果是最低部门，则显示部门自己
				if(sd.getLevel() == CommonDict.DEPT_LEVEL_LOWEST){
					lowestDept = true;
					deptList.add(sd);
				}
			}
			
			
			//只显示警务室
			Iterator<SysDeptWithBLOBs> itDept = deptList.iterator();
			while(itDept.hasNext()){
				SysDeptWithBLOBs dept = itDept.next();
				if(!"公安".equals(dept.getType())){
					itDept.remove();
				}
			}
			
			List<String> depts = new ArrayList<>();
			for(SysDeptWithBLOBs item : deptList){
				depts.add(item.getName() + "," + analysisService.getPoliceAreaChartDeptCount(item.getCode(), dtoRequest.getStartTime(), dtoRequest.getEndTime()));
			}
			
			List<Map> listJobs = analysisService.policeAreaChartJobCount(sd.getCode(), dtoRequest.getStartTime(), dtoRequest.getEndTime(),lowestDept);
			List<PieJob> pieList = new ArrayList<>();
			for(Map item : listJobs){
				PieJob pie = new PieJob();
				pie.setJobName(String.valueOf(item.get("jobName")));
				pie.setCount(Integer.parseInt(String.valueOf(item.get("count"))));
				pieList.add(pie);
			}
			
			GetPoliceAreaBar bar = new GetPoliceAreaBar();
			bar.setDepts(depts);
			
			GetPoliceArea area = new GetPoliceArea();
			area.setBar(bar);
			area.setPie(pieList);
			dtoResponse.setData(area);
		return dtoResponse;
	}
	
	@ApiDescription("警情堆叠条形图;负责人:lihao")
	@RequestMapping("alertDoneLineChar")
	@ResponseBody
	public DtoPublicResponseObj<AlertDoneLineChar> alertDoneLineChar(@Valid DtoPublicRequest dtoRequest) throws Exception {
		String deptId = userService.getUserById(dtoRequest.getUid()).getDeptId();
		if(StringUtils.isEmpty(deptId)){
			throw SystemException.init("该用户所属部门为空，不能查询");
		}
		
		List<SysDict> listAlertClassify = dictService.findByParentCode(CommonDict.DICE_ALERT_CLASSIFY_DICT);
		Date endTime = new Date();
		Date startTime = DateTool.addDays(DateTool.parseDateTime(DateTool.formatDate(new Date())), -6);
//		//找出所有已委派的
//		SysAppointedRecordExample sare = new SysAppointedRecordExample();
//		sare.createCriteria().andAppointeTimeBetween(startTime, endTime).andOldDeptIdEqualTo(deptId);
//		List<SysAppointedRecord> listApp = sysAppointedRecordMapper.selectByExample(sare);
//		List<JwAlert> listAppAlert = alertService.queryAlertList(FuncTool.copyPropertiesByName(listApp, "alertId"));
		
		AlertDoneLineChar adlc = new AlertDoneLineChar();
		for(SysDict item : listAlertClassify){
			adlc.getClassifyList().add(item.getName());
			int classifyCode = Integer.parseInt(item.getCode()) ;
			
			JwAlertExample jae = new JwAlertExample();
			jae.createCriteria().andAlertDeptIdEqualTo(deptId)
				.andAlertTimeBetween(startTime, endTime).andClassifyEqualTo(classifyCode);
			int total = jwAlertMapper.countByExample(jae);
			jae.getOredCriteria().get(0).andStatusIn(
					Arrays.asList(new Integer[]{CommonDict.ALERT_STATUS_APPRAISED,CommonDict.ALERT_STATUS_DONE}));
			int solved = jwAlertMapper.countByExample(jae);
			
			jae = new JwAlertExample();
			jae.createCriteria().andAlertDeptIdEqualTo(deptId).andAlertTimeBetween(startTime, endTime)
				.andClassifyEqualTo(classifyCode).andStatusEqualTo(CommonDict.ALERT_STATUS_DELEGATE);
			int appcount = jwAlertMapper.countByExample(jae);
			
			adlc.getAlertData().add("["+solved+", "+appcount+", "+(total)+"]");
		} 
		DtoPublicResponseObj<AlertDoneLineChar> dtoResponse = new DtoPublicResponseObj<>();
		dtoResponse.setData(adlc);
		return dtoResponse;
	}
	
	@ApiDescription("警情堆叠柱状图;负责人:lihao")
	@RequestMapping("alertDoneBarChar")
	@ResponseBody
	public DtoPublicResponseObj<AlertDoneBarChar> alertDoneBarChar(@Valid DtoPublicRequest dtoRequest) throws Exception {
		String deptId = userService.getUserById(dtoRequest.getUid()).getDeptId();
		if(StringUtils.isEmpty(deptId)){
			throw SystemException.init("该用户所属部门为空，不能查询");
		}
		Date endTime = new Date();
		Date startTime = DateTool.addDays(DateTool.parseDateTime(DateTool.formatDate(new Date())), -6);
//		//找出所有已委派的
//		SysAppointedRecordExample sare = new SysAppointedRecordExample();
//		sare.createCriteria().andAppointeTimeBetween(startTime, endTime).andOldDeptIdEqualTo(deptId);
//		List<SysAppointedRecord> listApp = sysAppointedRecordMapper.selectByExample(sare);
//		List<JwAlert> listAppAlert = alertService.queryAlertList(FuncTool.copyPropertiesByName(listApp, "alertId"));
		
		AlertDoneBarChar adbc = new AlertDoneBarChar();
		float totalSatisfy = 0;
		for(int i=0; i<7; i++){
			Date tmpStartTime = DateTool.addDays(startTime, i);
			Date tmpEndTime = DateTool.addDays(startTime, i+1);
			JwAlertExample jae = new JwAlertExample();
			jae.createCriteria().andAlertDeptIdEqualTo(deptId).andAlertTimeBetween(tmpStartTime, tmpEndTime);
			int total = jwAlertMapper.countByExample(jae);
			jae.getOredCriteria().get(0).andStatusIn(
					Arrays.asList(new Integer[]{CommonDict.ALERT_STATUS_APPRAISED,CommonDict.ALERT_STATUS_DONE}));
			int solved = jwAlertMapper.countByExample(jae);
			
			jae = new JwAlertExample();
			jae.createCriteria().andAlertDeptIdEqualTo(deptId).andAlertTimeBetween(tmpStartTime, tmpEndTime).andStatusEqualTo(CommonDict.ALERT_STATUS_DELEGATE);
			int appcount = jwAlertMapper.countByExample(jae);
			 
			adbc.getDate().add(DateTool.dateToString(tmpStartTime, DateTool.SHORT_DATE_FORMAT));
			adbc.getRecevie().add(String.valueOf(total));
			adbc.getDone().add(String.valueOf(solved));
			adbc.getDelegate().add(String.valueOf(appcount));
			//满意度暂时随机获取
			float f = (3+RandomUtils.nextInt(20)/10.0f);
			totalSatisfy += f;
			adbc.getAppraise().add(String.format("%.1f",f));
		}
		adbc.setTotalApprasie(String.format("%.1f", totalSatisfy/adbc.getAppraise().size()));
		DtoPublicResponseObj<AlertDoneBarChar> dtoResponse = new DtoPublicResponseObj<>();
		dtoResponse.setData(adbc);
		return dtoResponse;
	}
	
	@ApiDescription("部门警情查询;负责人:lihao")
	@RequestMapping("deptAlertInfo")
	@ResponseBody
	public DtoPublicResponseList<DeptAlerts> deptAlertInfo(@Valid DtoDeptAlertInfoRequest dtoRequest) throws Exception {
		DtoPublicResponseList<DeptAlerts> dtoResponse = new DtoPublicResponseList<>();
		//查询用户等级，如果是第5级别，则查询其子部门。
		//查询下属所有子部门的警情，按照时间范围
		//根据部门的关联部门（警务室），分组警情
		SysUser user = userService.queryUser(dtoRequest.getUid());
		if(StringUtils.isEmpty(user.getDeptId())){
			throw SystemException.init("用户所属部门为空，无法查询");
		}
		SysDeptWithBLOBs dept = deptService.getDeptById(user.getDeptId());
		if(dept.getLevel() == null || dept.getLevel() > CommonDict.DEPT_LEVEL_POLICE_STATION){
			throw SystemException.init("用户所属部门低于派出所级别，无法查询");
		}
		
		List<DeptAlerts> deptAlerts = new ArrayList<>();
		List<SysDeptWithBLOBs> listDept = deptService.getPoliceOffice(null,null,dtoRequest.getUid(),1);
		List<JwAlert> listAlert = alertService.queryAlertByDept(dept.getId(),dtoRequest.getStartTime(),dtoRequest.getEndTime());
		for(SysDeptWithBLOBs itemDept : listDept){
			DeptAlerts deptAlert = FuncTool.copyPropertiesClass(itemDept, DeptAlerts.class);
			List<AlertItem> listAlertItem = new ArrayList<>();
			
			List<String> listUserIds = deptService.queryManageUserIdsByPoliceSubStation(itemDept.getId()); 
			Set<String> listSet = new HashSet<String> (listUserIds);
			for(JwAlert itemAlert : listAlert){
				if(listSet.contains(itemAlert.getCreatorId())){
					listAlertItem.add(FuncTool.copyPropertiesClass(itemAlert, AlertItem.class));
				}
			}
			
			deptAlert.setAlerts(listAlertItem);
			deptAlerts.add(deptAlert);
		}
		dtoResponse.setData(deptAlerts);
		return dtoResponse;
	}
	
	@ApiDescription("警情处理嵌套环形图;负责人:luping")
	@RequestMapping("alertDonePaiChart")
	@ResponseBody
	public DtoPublicResponseObj<AlertDonePaiChart> alertDonePaiChart(@Valid DtoPublicRequest dtoRequest) throws Exception {
		DtoPublicResponseObj<AlertDonePaiChart> dtoResponse = new DtoPublicResponseObj<>();
		AlertDonePaiChart alertDonePaiChart = new AlertDonePaiChart();
		SysUser user = userService.queryUser(dtoRequest.getUid());
		if (StringUtils.isEmpty(user.getDeptId())) {
			throw SystemException.init("用户所属部门为空，无法查询");
		}
		SysDeptWithBLOBs dept = deptService.getDeptById(user.getDeptId());
		if (dept == null || StringUtils.isEmpty(dept.getId())) {
			throw SystemException.init("用户未查询到所在部门");
		}
		List<Integer> uncheck = new ArrayList<Integer>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dateList", uncheck);
		params.put("deptId", dept.getId());
		Date endTime = new Date();
		String startTime = DateTool.formatDateTime(DateTool.addDays(DateTool.parseDateTime(DateTool.formatDate(new Date())), -6));
		
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		// 处理中
		uncheck.clear();
		uncheck.add(0);
		params.put("dateList", uncheck);
		alertDonePaiChart.setDoing(analysisService.queryAlertDonePaiChart(params));
		// 已委派
		alertDonePaiChart.setDelegate(analysisService.queryAlertAppointed(dept.getId(),startTime));
		alertDonePaiChart.setDelegater(alertDonePaiChart.getDelegate());//IOS专用
		// 尚未评价
		uncheck.clear();
		uncheck.add(6);
		params.put("dateList", uncheck);
		alertDonePaiChart.setNoAppraise(analysisService.queryAlertDonePaiChart(params));
		// 好评
		alertDonePaiChart.setAppraise1(analysisService.queryAlertAppraise(dept.getId(), 10, 100,startTime));
		// 中评
		alertDonePaiChart.setAppraise2(analysisService.queryAlertAppraise(dept.getId(), 6, 10,startTime));
		// 差评
		alertDonePaiChart.setAppraise3(analysisService.queryAlertAppraise(dept.getId(),0, 6,startTime));
		
		alertDonePaiChart.setUndo(alertDonePaiChart.getDoing()+alertDonePaiChart.getDelegate());// 未解除
		alertDonePaiChart.setDone(alertDonePaiChart.getAppraise1()+alertDonePaiChart.getAppraise2()+alertDonePaiChart.getAppraise3()+alertDonePaiChart.getNoAppraise());
		alertDonePaiChart.setTotal(alertDonePaiChart.getDone()+alertDonePaiChart.getUndo());
		dtoResponse.setData(alertDonePaiChart);
		return dtoResponse;
	}
	
	
	/************************* jingsu **************************/
	@RequestMapping(value="getAlertMapChart")
	@ApiDescription("警情热力图接口;负责人：jinsu")
	@ResponseBody
	public DtoPublicResponseObj<GetAlertMapChart> getAlertMapChart(DtoGetAlertProcessChartRequest dtoRequest) throws Exception{
		DtoPublicResponseObj<GetAlertMapChart> dtoResponse = new DtoPublicResponseObj<GetAlertMapChart>();
		String deptId = dtoRequest.getDeptId();
		
		if(StringUtils.isEmpty(deptId)){
			String uid = dtoRequest.getUid();
			deptId = userService.getUserById(uid).getDeptId();
		}
		SysDeptWithBLOBs dept = dept_service.getDeptById(deptId);
		List<Point> ploy = new ArrayList<Point>();
		try{
			for(String loc : dept.getXyz().split("\\|")){
				double lng = Double.parseDouble(loc.split(",")[0]);
				double lat = Double.parseDouble(loc.split(",")[1]);
				ploy.add(new Point(lng, lat));
			}
		}catch(Exception ex){
			throw SystemException.init("所选辖区坐标数据格式错误，查询失败");
		}
		
		List<Map> result = analysisService.getAlertMapChart(dept.getCode(), dtoRequest.getStartTime(), dtoRequest.getEndTime());
		GetAlertMapChart chart = new GetAlertMapChart();
		List<List> tmp = new ArrayList<List>();
		for(Map map:result){
			List<Double> points = new ArrayList<Double>();
			String location = (String) map.get("location");
			String bd_location = (String) map.get("bd_location");
			try{
				String num = map.get("num").toString();
				Point alertPoint = null;
				if(StringUtils.isEmpty(bd_location)){
					double lat = Double.parseDouble(location.split(",")[0]);
					double lng = Double.parseDouble(location.split(",")[1]);
					alertPoint = new Point(lat, lng);
				}else{
					alertPoint = new Point(bd_location);
				}
				
//				for(Point p: BMapUtils.mockNearByPoint(alertPoint, 0.0044785)){
//					List<Double> mockPoints = new ArrayList<Double>();
//					mockPoints.add(p.getLng());
//					mockPoints.add(p.getLat());
//					mockPoints.add(Math.random() * 100);
//					tmp.add(mockPoints);
//				}
				if(BMapUtils.isPtInPoly(alertPoint.getLng(), alertPoint.getLat(), ploy) ){
					points.add(alertPoint.getLng());
					points.add(alertPoint.getLat());
					points.add(Double.parseDouble(num));
					//log.info("point inside alertPoint "+alertPoint.toString()+" range "+ploy);
				}else{
					log.info("point out of range alertPoint "+alertPoint.toString()+" range "+ploy);
				}
			}catch(Exception ex){
				throw SystemException.init("location exception "+location);
			}
			if(points.size() > 0 ){
				tmp.add(points);
			}
		}	
		chart.setBmap(tmp);
		dtoResponse.setData(chart);
		return dtoResponse;
	}
	
	
	/************************* lihao  end**************************/
	
	/************************* hong li **************************/
	@ApiDescription("查询辖区警力分布接口;负责人：hongli")
	@RequestMapping("getPoliceChart")
	@ResponseBody
	public DtoPublicResponseObj<GetPoliceChart> getPoliceChart(@Valid DtoGetPoliceChartRequest dtoRequest) throws Exception{
		DtoPublicResponseObj<GetPoliceChart> dtoResponse = new DtoPublicResponseObj<GetPoliceChart>();
		try{
			List<Date> dateList = new ArrayList<>();
			Date startTime = DateTool.parseDate(dtoRequest.getStartTime());
			Map<String, Object> dateMap = new TreeMap<String, Object>();
			boolean flag = true;
			int i=0;
			while(flag){
				Date d = DateTool.getDateByAddDays(startTime, i, 0);
				dateMap.put(DateTool.formatDate(d), (long)0);
				dateList.add(DateTool.parseDateTime(DateTool.formatDate(d)+" 23:59:59"));
				i++;
				if(DateTool.formatDate(d).equals(dtoRequest.getEndTime())){
					break;
				}
			}
			
			List<Map> totalPoliceChartBars = analysisService.getTotalPoliceChartBar(dtoRequest.getUid(), dtoRequest.getDeptId(), dateList);
			List<Map> onlinePoliceChartBars = analysisService.getOnlinePoliceChartBar(dtoRequest.getUid(), dtoRequest.getDeptId(), dtoRequest.getStartTime(), dtoRequest.getEndTime());
			List<Map> policeChartPie = analysisService.getPoliceChartPie(dtoRequest.getUid(), dtoRequest.getDeptId(), dtoRequest.getStartTime(), dtoRequest.getEndTime());

			GetPoliceChart policeChar = new GetPoliceChart();
			GetPoliceCharBar policeCharBar = new GetPoliceCharBar();
			List<String> total = new ArrayList<String>();
			List<String> online = new ArrayList<String>();
			
			
			Map<String, Object> tMap = new TreeMap<String,Object>();
			tMap.putAll(dateMap);
			for(Map totalPolice:totalPoliceChartBars){
				String create_time = (String)totalPolice.get("audited_time");
				tMap.put(create_time, totalPolice.get("num"));
			}
//			System.out.println(tMap);
			Map<String, Object> onlineMap = new TreeMap<String,Object>();
			onlineMap.putAll(dateMap);
			for(Map onlinePolice:onlinePoliceChartBars){
				String create_time = (String)onlinePolice.get("audited_time");
				onlineMap.put(create_time, onlinePolice.get("num"));
			}
			if(tMap != null && !tMap.isEmpty()){
				Iterator<String> iterator = tMap.keySet().iterator();
				while(iterator.hasNext()){
					String create_time = iterator.next();
					Object num = tMap.get(create_time);
					total.add(DateTool.parseDate(create_time).getTime()+","+num);
				}
			}
			if(onlineMap != null && !onlineMap.isEmpty()){
				Iterator<String> iterator = onlineMap.keySet().iterator();
				while(iterator.hasNext()){
					String create_time = iterator.next();
					Object num = onlineMap.get(create_time);
					online.add(DateTool.parseDate(create_time).getTime()+","+num);
				}
			}
			//查询辖区警力类型分布
			List<PieDept> pie = new ArrayList<PieDept>();
			for(Map authedPolice:policeChartPie){
				String deptName = (String)authedPolice.get("deptName");
				int count = Integer.parseInt(authedPolice.get("count").toString());
				PieDept job = new PieDept();
				job.setCount(count);
				job.setDeptName(deptName);
				pie.add(job);
			}
			policeCharBar.setOnline(online);
			policeCharBar.setTotal(total);
			policeChar.setBar(policeCharBar);
			policeChar.setPie(pie);
			dtoResponse.setData(policeChar);
		}catch (Exception e) {
			throw e;
		}
		return dtoResponse;
	}
	/************************* hong li end **************************/
}
