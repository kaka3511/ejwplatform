package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.dao.JwAlertExample;
import com.huaao.ejwplatform.dao.JwAlertExampleExt;
import com.huaao.ejwplatform.dao.SysDept;
import com.huaao.ejwplatform.dao.SysDeptExample;
import com.huaao.ejwplatform.dao.SysUserExample;
import com.huaao.ejwplatform.dao.SysUserLogExample;
import com.huaao.ejwplatform.dao.SysUserLogExampleExt;
import com.huaao.ejwplatform.mapper.JwAlertMapper;
import com.huaao.ejwplatform.mapper.SysUserLogMapper;
import com.huaao.ejwplatform.mapper.SysUserMapper;
import com.huaao.ejwplatform.mapper.mymapper.AnalysisMapper;
import com.huaao.ejwplatform.mapper.mymapper.JwAlertMapperExt;
import com.huaao.ejwplatform.service.model.AlertCategoryEnum;
import com.huaao.ejwplatform.service.model.AlertStatusEnum;
import com.huaao.ejwplatform.service.system.DeptService;

@Service
public class AnalysisService {

	@Autowired
	private AnalysisMapper analysisMapper;
	
	@Autowired
	private DeptService deptService;

	@Autowired
	private JwAlertMapper jwAlertMapper;
	
	@Autowired
	private JwAlertMapperExt jwAlertMapperExt;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserLogMapper sysUserLogMapper;
	
	/************************* shilei   **************************/
	public Map<String,String> getAlertSummary(String uid){
		SysDept dept = deptService.getDeptByUserId(uid);
		Date curDate = new Date();
		return getAllAlertSummary(curDate, dept.getCode(),dept.getId());
	}
	
	private Map<String,String> getAllAlertSummary(Date curDate, String deptCode, String deptId){
		Map<String,String> map = new HashMap<>();
		
		JwAlertExampleExt exa = new JwAlertExampleExt();
//		exa.setDeptCode(deptCode);
		exa.setAlertCategory(AlertCategoryEnum.VALID.getCode());
		exa.setStatus(AlertStatusEnum.UNCOMIT.getCode());
		exa.setAll(0);
		exa.setDeptId(deptId);
		exa.setEndDate(DateTool.getDateByAddDays(curDate, -1, 1));
		//所有
		int all = jwAlertMapperExt.countByCriteria(exa);
		map.put("all", String.valueOf(all));
		
		//近一个季度
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -90, 0));
		int quarter = jwAlertMapperExt.countByCriteria(exa);
		map.put("quarter", String.valueOf(quarter));
		
		//近一个月
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -30, 0));
		int month = jwAlertMapperExt.countByCriteria(exa);
		map.put("month", String.valueOf(month));
		
		//近一周
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -7, 0));
		int week = jwAlertMapperExt.countByCriteria(exa);
		map.put("week", String.valueOf(week));
		
		//昨日
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -1, 0));
		int yes = jwAlertMapperExt.countByCriteria(exa);
		map.put("day", String.valueOf(yes));
		
		return map;
	}
	
	public Map<String,String> getAlertHandleSummary(String uid){
		SysDept dept = deptService.getDeptByUserId(uid);
		Date curDate = new Date();
		
		Map<String,String> map = getAllAlertSummary(curDate, dept.getCode(),dept.getId());
		
		JwAlertExampleExt exa = new JwAlertExampleExt();
//		exa.setDeptCode(dept.getCode());
		exa.setAlertCategory(AlertCategoryEnum.VALID.getCode());
		exa.setEndDate(DateTool.getDateByAddDays(curDate, -1, 1));
		exa.setStatus(AlertStatusEnum.DONE.getCode());
		exa.setDeptId(dept.getId());
		//所有
		int allDone = jwAlertMapperExt.countByCriteria(exa);
		map.put("all", map.get("all")+","+allDone);
		
		//近一个季度
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -90, 0));
		int quarterDone = jwAlertMapperExt.countByCriteria(exa);
		map.put("quarter", map.get("quarter")+","+quarterDone);
		
		//近一个月
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -30, 0));
		int monthDone = jwAlertMapperExt.countByCriteria(exa);
		map.put("month", map.get("month")+","+monthDone);
		
		//近一周
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -7, 0));
		int weekDone = jwAlertMapperExt.countByCriteria(exa);
		map.put("week", map.get("week")+","+weekDone);
		
		//昨日
		exa.setStartDate(DateTool.getDateByAddDays(curDate, -1, 0));
		int yesDone = jwAlertMapperExt.countByCriteria(exa);
		map.put("day", map.get("day")+","+yesDone);
		
		return map;
	}
	
	public Map<String,String> getPolicySummary(String uid){
		Map<String,String> map = new HashMap<>();
		Date curDate = new Date();
		
		SysDept dept = deptService.getDeptByUserId(uid);
		
		SysUserLogExample exa = new SysUserLogExample();
		SysUserLogExampleExt ule = new SysUserLogExampleExt();
		SysUserExample userExa = new SysUserExample();
		SysDeptExample deptExa = new SysDeptExample();
		
		ule.setDeptCode(dept.getCode());
		ule.setDeptType("公安");
		exa.createCriteria().andActionEqualTo(1)
		.andCreateTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1));

		userExa.createCriteria().andAuthEqualTo("authed").andIsUseableEqualTo(1).andAuditedTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1));
		deptExa.createCriteria().andTypeEqualTo("公安").andCodeLike(dept.getCode()+"%");
		int all = analysisMapper.countByMutiExa(userExa, deptExa);
		int allOnline = sysUserLogMapper.countByCriteria(ule, exa);
		map.put("all", all+","+allOnline);
		
		//-90-
		exa.clear();
		exa.createCriteria().andActionEqualTo(1)
		.andCreateTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -90, 0))
		.andCreateTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1));
		userExa.clear();
		userExa.createCriteria().andAuthEqualTo("authed").andIsUseableEqualTo(1).andAuditedTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1))
		.andAuditedTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -90, 0));
		int quarterAll = analysisMapper.countByMutiExa(userExa, deptExa);
		int quarterOnline = sysUserLogMapper.countByCriteria(ule, exa);
		map.put("quarter", quarterAll+","+quarterOnline);
		
		//-30-
		exa.clear();
		exa.createCriteria().andActionEqualTo(1)
		.andCreateTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -30, 0))
		.andCreateTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1));
		userExa.clear();
		userExa.createCriteria().andAuthEqualTo("authed").andIsUseableEqualTo(1).andAuditedTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1))
		.andAuditedTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -30, 0));
		int monthAll = analysisMapper.countByMutiExa(userExa, deptExa);
		int monthOnline = sysUserLogMapper.countByCriteria(ule, exa);
		map.put("month", monthAll+","+monthOnline);
		
		//-7-
		exa.clear();
		exa.createCriteria().andActionEqualTo(1)
		.andCreateTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -7, 0))
		.andCreateTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1));
		userExa.clear();
		userExa.createCriteria().andAuthEqualTo("authed").andIsUseableEqualTo(1).andAuditedTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1))
		.andAuditedTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -7, 0));
		int weekAll = analysisMapper.countByMutiExa(userExa, deptExa);
		int weekOnline = sysUserLogMapper.countByCriteria(ule, exa);
		map.put("week", weekAll+","+weekOnline);
		
		//-1-
		exa.clear();
		exa.createCriteria().andActionEqualTo(1)
		.andCreateTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 0))
		.andCreateTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1));
		userExa.clear();
		userExa.createCriteria().andAuthEqualTo("authed").andIsUseableEqualTo(1).andAuditedTimeLessThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 1))
		.andAuditedTimeGreaterThanOrEqualTo(DateTool.getDateByAddDays(curDate, -1, 0));
		int yesAll = analysisMapper.countByMutiExa(userExa, deptExa);
		int yesOnline =sysUserLogMapper.countByCriteria(ule, exa);
		map.put("day", yesAll+","+yesOnline);
		
		return map;
	}
	
	public Map<String, Object> getAlertChart(String uid, String deptId, Date startDate, Date endDate) throws Exception {
		/**
		 * 派出所 看 警务室
		 * 警务室 看 小区
		 * （小区 归属 警务室 根据 link_dept_id）
		 * deptId 不为空 则为 警务室id 或 小区id
		 */
		
		//判断是派出所 还是 警务室
		SysDept dept = deptService.getDeptByUserId(uid);
		if(!"公安".equals(dept.getType()))
			return null;
		
		Map<String, Object> params = new HashMap<>(); 
		params.put("startTime", startDate);
		params.put("endTime", endDate);
		params.put("deptId", deptId);
		List<Map> deptList = null; 
		if(dept.getLevel().intValue()==5&&StringUtils.isBlank(deptId)){//派出所
			params.put("deptCode", dept.getCode());
			deptList = analysisMapper.getDeptAlertChartJW(params);
		}else if(dept.getLevel().intValue()==5&&StringUtils.isNotBlank(deptId)){//派出所
			params.put("jwDeptId",deptId);
			params.remove("deptId");
			deptList = analysisMapper.getDeptAlertChartXQ(params);
		}else if(dept.getLevel().intValue()==6){//警务室
			params.put("jwDeptId",dept.getId());
			deptList = analysisMapper.getDeptAlertChartXQ(params);
		}else{
			return null;
		}
		
		//统计每天
		params.put("startTime", startDate);
		params.put("endTime", endDate);
		if(dept.getLevel().intValue()==5){//派出所
			params.remove("deptId");
			if(StringUtils.isNotBlank(deptId)){
				params.put("linkDeptId", deptId);
			}
		}else if(dept.getLevel().intValue()==6){//警务室
			params.put("linkDeptId", dept.getId());
		}
		Map<String, String> dayAllCntMap = new HashMap<>();
		List<Map> dayList = analysisMapper.getDayAlertChart(params);
		for(Map map : dayList){
			dayAllCntMap.put(map.get("alertdate").toString(), map.get("total").toString());
		}
		List<String> dayCntList = new ArrayList<>();
		Date begin = DateTool.getDateByAddDays(startDate, null, 0);
		Date end = DateTool.getDateByAddDays(endDate, null, 0);
		int sum = 0;
		String val = null;
		while(begin.compareTo(end) < 1){
			val = dayAllCntMap.get(DateTool.dateToNormalString(begin));
			if(val!=null){
				sum = Integer.parseInt(val);
			}else{
				sum = 0;
			}
			dayCntList.add(begin.getTime()+","+sum);
			begin = DateTool.getDateByAddDays(begin, 1, 0);
		}
		
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("pie", deptList);
		resMap.put("alerts", dayCntList);
		return resMap;
	}
	
	
    public Map<String, Object> getAlertProcessChart(String uid, String deptId, Date startDate, Date endDate){
		
    	//判断是派出所 还是 警务室
		SysDept dept = deptService.getDeptByUserId(uid);
		if(!"公安".equals(dept.getType()))
			return null;
		
		Map<String, Object> params = new HashMap<>(); 
		params.put("startTime", startDate);
		params.put("endTime", endDate);
		params.put("deptId", deptId);
		List<Map> deptList = null; 
		if(dept.getLevel().intValue()==5&&StringUtils.isBlank(deptId)){//派出所
			params.put("deptCode", dept.getCode());
			deptList = analysisMapper.getDeptAlertChartJW(params);
		}else if(dept.getLevel().intValue()==5&&StringUtils.isNotBlank(deptId)){//派出所
			params.put("jwDeptId",deptId);
			params.remove("deptId");
			deptList = analysisMapper.getDeptAlertChartXQ(params);
		}else if(dept.getLevel().intValue()==6){//警务室
			params.put("jwDeptId",dept.getId());
			deptList = analysisMapper.getDeptAlertChartXQ(params);
		}else{
			return null;
		}
		
		//统计每天
		params.put("startTime", startDate);
		params.put("endTime", endDate);
		if(dept.getLevel().intValue()==5){//派出所
			params.remove("deptId");
			if(StringUtils.isNotBlank(deptId)){
				params.put("linkDeptId", deptId);
			}
		}else if(dept.getLevel().intValue()==6){//警务室
			params.put("linkDeptId", dept.getId());
		}
		
		List<Map> dayList = analysisMapper.getDayAlertChart(params);
		params.put("status", 1);
		List<Map> dayDoneList = analysisMapper.getDayAlertChart(params);
		
		Map<String, String> dayAllCntMap = new HashMap<>();
		Map<String, String> dayDoneCntMap = new HashMap<>();
		for(Map map : dayList){
			dayAllCntMap.put(map.get("alertdate").toString(), map.get("total").toString());
		}
		for(Map map : dayDoneList){
			dayDoneCntMap.put(map.get("alertdate").toString(), map.get("total").toString());
		}
		
		List<String> dayCntList = new ArrayList<>();
		List<String> dayDoneCntList = new ArrayList<>();
		List<String> dayUndoneCntList = new ArrayList<>();
		List<String> daySatisfyList = new ArrayList<>();
		Date begin = DateTool.getDateByAddDays(startDate, null, 0);
		Date end = DateTool.getDateByAddDays(endDate, null, 0);
		int sum = 0;
		int done = 0;
		String valAll = null;
		String valDone = null;
		float totalSatisfy = 0;
		while(begin.compareTo(end) < 1){
			valAll = dayAllCntMap.get(DateTool.dateToNormalString(begin));
			valDone = dayDoneCntMap.get(DateTool.dateToNormalString(begin));
			if(valAll!=null){
				sum = Integer.parseInt(valAll);
			}else{
				sum = 0;
			}
			if(valDone!=null){
				done = Integer.parseInt(valDone);
			}else{
				done = 0;
			}
			dayCntList.add(begin.getTime()+","+sum);
			dayDoneCntList.add(begin.getTime()+","+done);
			dayUndoneCntList.add(begin.getTime()+","+(sum-done));
			//满意度暂时随机获取
			float f = (3+RandomUtils.nextInt(20)/10);
			totalSatisfy += f;
			daySatisfyList.add(begin.getTime()+","+String.format("%.1f",f));
			
			begin = DateTool.getDateByAddDays(begin, 1, 0);
		}
		
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("pie", deptList);
		resMap.put("all", dayCntList);
		resMap.put("done", dayDoneCntList);
		resMap.put("undone", dayUndoneCntList);
		resMap.put("satisfy", dayUndoneCntList);
		resMap.put("totalSatisfy", String.format("%.1f", totalSatisfy/resMap.size())  );
		
		return resMap;
	}
    
	
	/************************* lihao   **************************/
	public List<Map> policeAreaChartJobCount(String deptCode, String startTime, String endTime, boolean lowestDept){
		if(lowestDept){
			return analysisMapper.policeAreaChartJobCount(endTime+" 23:59:59","backUser", deptCode+"%"," ","authed");
		}else{
			return analysisMapper.policeAreaChartJobCount(endTime+" 23:59:59","backUser", deptCode+"%",deptCode,"authed");
		}
		
	}
	
	public Integer getPoliceAreaChartDeptCount(String deptCode, String startTime, String endTime){
		return analysisMapper.policeAreaChartDeptCount(endTime+" 23:59:59","backUser", deptCode+"%",deptCode,"authed");
	}
	
	/************************* jingsu **************************/
	public List<Map> getAlertMapChart(String deptCode, String startTime, String endTime){
		Map<String, Object> params = new HashMap<String, Object>();
		//System.out.println("deptCode=========="+deptCode);
		//System.out.println("startTime=========="+startTime);
		//System.out.println("endTime=========="+endTime);
		params.put("deptCode", deptCode);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		return analysisMapper.getAlertMapChart(params);
	}
	
	
	
	
	/************************* hongli   **************************/
	/**
	 * 辖区警力查询
	 * @param uid
	 * @param deptId
	 * @param dateList
	 * @return
	 */
	public List<Map> getTotalPoliceChartBar(String uid,String deptId, List<Date> dateList) throws Exception{
		SysDept dept = null;
		//获取区域
		if(StringUtils.isNotBlank(deptId)){
			dept = deptService.getDeptById(deptId);
		}else{
			dept = deptService.getDeptByUserId(uid);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptCode", dept.getCode());
		params.put("dateList", dateList);
		return analysisMapper.getTotalPoliceChartBar(params);
	}
	
	/**
	 * 辖区警力查询
	 * @param uid
	 * @param deptId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Map> getOnlinePoliceChartBar(String uid,String deptId, String startTime, String endTime) throws Exception{
		SysDept dept = null;
		//获取区域
		if(StringUtils.isNotBlank(deptId)){
			dept = deptService.getDeptById(deptId);
		}else{
			dept = deptService.getDeptByUserId(uid);
		}
		Date startTimeDate = DateTool.parseDateTime(startTime+" 00:00:00");
		Date endTimeDate = DateTool.parseDateTime(endTime+" 23:59:59");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptCode", dept.getCode());
		params.put("startTime", startTimeDate);
		params.put("endTime", endTimeDate);
		return analysisMapper.getOnlinePoliceChartBar(params);
	}
	
	/**
	 * 辖区警力类型及人数查询 
	 * @param uid
	 * @param deptId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Map> getPoliceChartPie(String uid,String deptId, String startTime, String endTime) throws Exception{
		SysDept dept = null;
		//获取区域
		if(StringUtils.isNotBlank(deptId)){
			dept = deptService.getDeptById(deptId);
		}else{
			dept = deptService.getDeptByUserId(uid);
		}
		Date startTimeDate = DateTool.parseDateTime(startTime+" 00:00:00");
		Date endTimeDate = DateTool.parseDateTime(endTime+" 23:59:59");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptCode", dept.getCode());
		params.put("startTime", startTimeDate);
		params.put("endTime", endTimeDate);
		return analysisMapper.getPoliceChartPie(params);
	}

	public Integer queryAlertDonePaiChart(Map<String,Object> map) throws Exception {
		if (map==null || map.size()==0) {
			return null;
		}
		return analysisMapper.queryAlertDonePaiChart(map);
	}

	
	public Integer queryAlertAppointed(String deptId,String startTime) throws Exception {
		if (deptId==null) {
			return null;
		}
		return analysisMapper.queryAlertAppointed(deptId,startTime);
	}
	
	public Integer queryAlertAppraise(String deptId,Integer startAvg,Integer endAvg,String startTime) throws Exception {
		if (deptId==null) {
			return null;
		}
		return analysisMapper.queryAlertAppraise(deptId,startAvg,endAvg,startTime);
	}
	
}
