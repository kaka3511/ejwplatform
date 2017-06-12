package com.huaao.ejwplatform.mapper.mymapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.huaao.ejwplatform.dao.SysDeptExample;
import com.huaao.ejwplatform.dao.SysUserExample;

public interface AnalysisMapper {

	/************************* shilei   **************************/
	int countByMutiExa(@Param("userExa") SysUserExample userExa, @Param("deptExa") SysDeptExample deptExa);
	
	List<Map> getDayAlertChart(Map<String, Object> params);
	
	List<Map> getDeptAlertChartJW(Map<String, Object> params);
	
	List<Map> getDeptAlertChartXQ(Map<String, Object> params);
	
	/************************* lihao   **************************/
	List<Map> policeAreaChartJobCount(String createTime, String type, String deptCodeLike ,String deptCode,String auth);
	
	Integer policeAreaChartDeptCount(String createTime, String type, String deptCodeLike ,String deptCode, String auth);
	
	
	
	/************************* jingsu **************************/
	List<Map> getAlertMapChart(Map<String, Object> params);
	
	
	/************************* hongli   **************************/

	List<Map> getTotalPoliceChartBar(Map<String, Object> params);

	List<Map> getOnlinePoliceChartBar(Map<String, Object> params);

	List<Map> getPoliceChartPie(Map<String, Object> params);
	/************************* luping   **************************/
	
	Integer queryAlertDonePaiChart(Map<String,Object> map);
	
	Integer queryAlertAppointed(String deptId,String startTime);
	
	Integer queryAlertAppraise(String deptId,Integer startAvg,Integer endAvg,String startTime);
}
