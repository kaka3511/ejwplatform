package com.huaao.ejwplatform.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.ReadExcelUtils;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwElectricity;
import com.huaao.ejwplatform.dao.JwElectricityExample;
import com.huaao.ejwplatform.dao.JwElectricityExampleExt;
import com.huaao.ejwplatform.dao.JwWater;
import com.huaao.ejwplatform.dao.JwWaterExample;
import com.huaao.ejwplatform.dao.JwWaterExampleExt;
import com.huaao.ejwplatform.mapper.JwElectricityMapper;
import com.huaao.ejwplatform.mapper.JwWaterMapper;

@Service
public class LifeDataService {
	private static final Logger LOG = LoggerFactory.getLogger(LifeDataService.class);

	@Autowired
	private JwWaterMapper  jwWaterMapper;

	@Autowired
	private JwElectricityMapper jwElectricityMapper;
	
	/**
	 * 分批插入条数
	 */
	private static final int NUM = 500;

	/**
	 * 查询用水数据
	 * @param page
	 * @param startMonth
	 * @param endMonth
	 * @param orderby
	 * @param keyword
	 * @param deptId
	 * @return
	 */
	public List<JwWater> queryWaterList(Page page, String startMonth, String endMonth, String orderby, String keyword,
			String deptId) {
		JwWaterExampleExt exa = new JwWaterExampleExt();
		exa.setKeyword(keyword);
		exa.setStartMonth(startMonth);
		exa.setEndMonth(endMonth);
		exa.setDeptId(deptId);
		int total = jwWaterMapper.countMultiByExample(exa);
		page.setTotalCount(total);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(orderby);
		List<JwWater> jwWaters = jwWaterMapper.selectMultiByExample(exa);
		return jwWaters;
	}
	
	/**
	 * 查询用电数据列表
	 * @param page
	 * @param startMonth
	 * @param endMonth
	 * @param orderby
	 * @param keyword
	 * @param deptId
	 * @return
	 */
	public List<JwElectricity> queryElectricityList(Page page, String startMonth, String endMonth, String orderby, String keyword,
			String deptId) {
		JwElectricityExampleExt exa = new JwElectricityExampleExt();
		exa.setKeyword(keyword);
		exa.setStartMonth(startMonth);
		exa.setEndMonth(endMonth);
		exa.setDeptId(deptId);
		int total = jwElectricityMapper.countMultiByExample(exa);
		page.setTotalCount(total);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(orderby);
		List<JwElectricity> jwElectricitys = jwElectricityMapper.selectMultiByExample(exa);
		return jwElectricitys;
	}
	
	/**
	 * 查询排序值
	 * @param type
	 * @return
	 */
	public int getNextOrderId(int type){
		int orderId = 0;
		if(type == 1){
			JwWaterExample example = new JwWaterExample();
			int sum = jwWaterMapper.countByExample(example);
			orderId = sum+1;
		}else{
			JwElectricityExample example = new JwElectricityExample();
			int sum = jwElectricityMapper.countByExample(example);
			orderId = sum+1;
		}
		return orderId;
	}
	

	/**
	 * 数据导入
	 * @param filepath
	 * @param deptId
	 * @param type
	 */
	@ApiDescription("数据导入")
	@Transactional
	public Map<String, Object> importLifeData(String filepath, String deptId, Integer type, String uid, String yearMonth) throws Exception{
		Integer code = Constants.API_CODE_SUCCESS;
		String msg = null;
		Map<String, Object> result = new TreeMap<String, Object>();
		String pyear = yearMonth.split("-")[0];
		String pmonth = yearMonth.split("-")[1];
		ReadExcelUtils excelReader = new ReadExcelUtils(filepath);
		Map<Integer, Map<Integer, Object>> map = excelReader.readExcelContent();
		Map<Integer, Map<Integer, Object>> dataMap = new TreeMap<Integer, Map<Integer, Object>>();
		int row = 1;
		Date dd = new Date();
		int orderId = getNextOrderId(type);
		Iterator<Integer> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			int i = iterator.next();
			row++;
			Map<Integer, Object> data = map.get(i);
			//分析数据如有异常数据则返回对应行和列信息
			String year = String.valueOf(data.get(0));
			year = ReadExcelUtils.removeZeroCellConvert(year);
			String month = String.valueOf(data.get(1));
			month = ReadExcelUtils.prefixAddZeroCellConvert(month);
			String userno = String.valueOf(data.get(2));
			String username = String.valueOf(data.get(3));
			String telphone = String.valueOf(data.get(4));
			String address = String.valueOf(data.get(5));
			String consumption = String.valueOf(data.get(6));
			if(StringUtils.isBlank(year)
					&& StringUtils.isBlank(month)
					&& StringUtils.isBlank(userno)
					&& StringUtils.isBlank(username)
					&& StringUtils.isBlank(telphone)
					&& StringUtils.isBlank(address)
					&& StringUtils.isBlank(consumption)){
				continue;
			}
			if(!pyear.equals(year)){
				msg = "第"+row+"行年份数据不正确，请修改后重试";
				code = Constants.API_CODE_FAIL;
				result.put("msg", msg);
				result.put("code", code);
				return result;
			}
			if(!pmonth.equals(month)){
				msg = "第"+row+"行月份数据不正确，请修改后重试";
				code = Constants.API_CODE_FAIL;
				result.put("msg", msg);
				result.put("code", code);
				return result;
			}
			if(StringUtils.isEmpty(userno) && userno.length() > 32){
				msg = "第"+row+"行户号超出32个字符范围，请修改后重试";
				code = Constants.API_CODE_FAIL;
				result.put("msg", msg);
				result.put("code", code);
				return result;
			}
			if(StringUtils.isNotBlank(username) && username.length() > 64){
				msg = "第"+row+"行户名超出最大64个字符范围，请修改后重试";
				code = Constants.API_CODE_FAIL;
				result.put("msg", msg);
				result.put("code", code);
				return result;
			}
			if(StringUtils.isNotBlank(telphone) && telphone.length() != 11 
					&& !telphone.startsWith("1")){
				msg = "第"+row+"行手机号格式不正确，请修改后重试";
				code = Constants.API_CODE_FAIL;
				result.put("msg", msg);
				result.put("code", code);
				return result;
			}
			if(StringUtils.isNotBlank(address) && address.length() > 256){
				msg = "第"+row+"行住址超出256个字符范围，请修改后重试";
				code = Constants.API_CODE_FAIL;
				result.put("msg", msg);
				result.put("code", code);
				return result;
			}
			if(StringUtils.isBlank(consumption) || ReadExcelUtils.doubleToIntCellConvert(consumption) <0){
				if(type.intValue() == 1){
					msg = "第"+row+"行用水量数据不正确，请修改后重试";
					code = Constants.API_CODE_FAIL;
					result.put("msg", msg);
					result.put("code", code);
					return result;
				}else{
					msg = "第"+row+"行用电量数据不正确，请修改后重试";
					code = Constants.API_CODE_FAIL;
					result.put("msg", msg);
					result.put("code", code);
					return result;
				}
			}
			data.put(7, orderId);
			dataMap.put(row, data);
			orderId++;
		}
		//删除并插入，有异常则回滚
		List<JwWater> jwWaters = new ArrayList<JwWater>();
		List<JwElectricity> jwElectricitys = new ArrayList<JwElectricity>();
		iterator = dataMap.keySet().iterator();
		while (iterator.hasNext()) {
			int i = iterator.next();
			Map<Integer, Object> data = dataMap.get(i);
			if(type.intValue() == 1){
				JwWater jwWater = new JwWater();
				jwWater.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				jwWater.setCreateTime(dd);
				jwWater.setYear(ReadExcelUtils.removeZeroCellConvert(String.valueOf(data.get(0))));
				jwWater.setMonth(ReadExcelUtils.prefixAddZeroCellConvert(String.valueOf(data.get(1))));
				jwWater.setWateNo(ReadExcelUtils.removeZeroCellConvert(String.valueOf(data.get(2))));
				jwWater.setUserName(String.valueOf(data.get(3)));
				jwWater.setTelphone(String.valueOf(data.get(4)));
				jwWater.setAddress(String.valueOf(data.get(5)));
				jwWater.setConsumption(ReadExcelUtils.doubleToIntCellConvert(String.valueOf(data.get(6))));
				jwWater.setCreatorId(uid);
				jwWater.setDeptId(deptId);
				jwWater.setUpdaterId(uid);
				jwWater.setUpdateTime(dd);
				jwWater.setOrderId((Integer)data.get(7));
				jwWaters.add(jwWater);
			}else{
				JwElectricity jwElectricity = new JwElectricity();
				jwElectricity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				jwElectricity.setCreateTime(dd);
				jwElectricity.setYear(ReadExcelUtils.removeZeroCellConvert(String.valueOf(data.get(0))));
				jwElectricity.setMonth(ReadExcelUtils.prefixAddZeroCellConvert(String.valueOf(data.get(1))));
				jwElectricity.setElectricityNo(ReadExcelUtils.removeZeroCellConvert(String.valueOf(data.get(2))));
				jwElectricity.setUserName(String.valueOf(data.get(3)));
				jwElectricity.setTelphone(String.valueOf(data.get(4)));
				jwElectricity.setAddress(String.valueOf(data.get(5)));
				jwElectricity.setConsumption(ReadExcelUtils.doubleToIntCellConvert(String.valueOf(data.get(6))));
				jwElectricity.setCreatorId(uid);
				jwElectricity.setDeptId(deptId);
				jwElectricity.setUpdaterId(uid);
				jwElectricity.setUpdateTime(dd);
				jwElectricity.setOrderId((Integer)data.get(7));
				jwElectricitys.add(jwElectricity);
			}
		}
		int count = 0;
		try {
			if(type.intValue() == 1){
				JwWaterExample example = new JwWaterExample();
				example.createCriteria()
					.andYearEqualTo(pyear)
					.andMonthEqualTo(pmonth)
					.andDeptIdEqualTo(deptId);
				jwWaterMapper.deleteByExample(example);
				//插入
				count = addLifeData(jwWaters, type.intValue());
			}else{
				JwElectricityExample example = new JwElectricityExample();
				example.createCriteria()
					.andYearEqualTo(pyear)
					.andMonthEqualTo(pmonth)
					.andDeptIdEqualTo(deptId);
				jwElectricityMapper.deleteByExample(example);
				//插入
				count = addLifeData(jwElectricitys, type.intValue());
			}
		} catch (Exception e) {
			LOG.error("执行导入失败", e);
			msg = "操作失败，请联系管理员";
			code = Constants.API_CODE_FAIL;
			result.put("msg", msg);
			result.put("code", code);
			return result;
		}
		msg = "操作成功，共导入了"+count+"条记录";
		code = Constants.API_CODE_SUCCESS;
		result.put("msg", msg);
		result.put("code", code);
		return result;
	}
	
	/**
	 * 分批插入
	 * @param num 条数
	 */
	public int addLifeData(List lifeList, int type){
		int insertNum = 0;
		if(lifeList.size() < NUM){
			if(type == 1){
				insertNum = jwWaterMapper.addWaterRecordBatch(lifeList);
			}else if(type == 2){
				insertNum = jwElectricityMapper.addJwElectricityRecordBatch(lifeList);
			}
		}else{
			int count = lifeList.size()/NUM +1;//插入的次数
			int index = 0;
			int start = 0;
			int end = 0;
			while(index < count){
				start = index*NUM;
				end = (index+1)*NUM;
				if(type == 1){
					if(end > lifeList.size()){
						end = lifeList.size();
					}
					insertNum += jwWaterMapper.addWaterRecordBatch(lifeList.subList(start, end));
				}else if(type == 2){
					if(end > lifeList.size()){
						end = lifeList.size();
					}
					insertNum += jwElectricityMapper.addJwElectricityRecordBatch(lifeList.subList(start, end));
				}
				index++;
			}
		}
		return insertNum;
	}
}
