package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.ReadExcelUtils;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwDeptInformation;
import com.huaao.ejwplatform.dao.JwDeptInformationExample;
import com.huaao.ejwplatform.mapper.JwDeptInformationMapper;

@Service
public class JwDeptInformationService {
	private static final Logger LOG = LoggerFactory.getLogger(JwDeptInformationService.class);

	@Autowired
	private JwDeptInformationMapper deptInformationMapper;
	
	
	public List<JwDeptInformation> queryDeptInformationList(String deptId, Page page){
		JwDeptInformationExample example = new JwDeptInformationExample();
		if(deptId != null)
			example.createCriteria().andDeptIdEqualTo(deptId);
		example.setOrderByClause(" dept_id,no ");
		
		int total = deptInformationMapper.countByExample(example);
		page.setTotalCount(total);
		example.setOffset(page.getOffset());
		example.setLimit(page.getPageSize());
		
		List<JwDeptInformation> list = deptInformationMapper.selectByExample(example);
		return list;
	}
	
	public List<JwDeptInformation> queryDeptDataInformation(String deptId){
		List<JwDeptInformation> list = new ArrayList<>();
		
		JwDeptInformationExample example = new JwDeptInformationExample();
		if(deptId != null)
			example.createCriteria().andDeptIdEqualTo(deptId);
		example.setOrderByClause(" dept_id,no ");
		list = deptInformationMapper.selectByExample(example);
		return list;
	}
	
	
	
	
	/**
	 * 数据导入
	 * @param filepath
	 * @param deptId
	 */
	@ApiDescription("数据导入")
	@Transactional
	public Map<String, Object> importDeptInformationData(String filepath, String deptId) throws Exception{
		Integer code = Constants.API_CODE_SUCCESS;
		String msg = null;
		Map<String, Object> result = new TreeMap<String, Object>();
		//删除数据库中原先存在的该部门的信息
		JwDeptInformationExample example = new JwDeptInformationExample();
		example.createCriteria().andDeptIdEqualTo(deptId);
		deptInformationMapper.deleteByExample(example);
		
		ReadExcelUtils excelReader = new ReadExcelUtils(filepath);
		Map<Integer, Map<Integer, Object>> map = excelReader.readExcelContent();
		Map<Integer, Map<Integer, Object>> dataMap = new TreeMap<Integer, Map<Integer, Object>>();
		int row = 1;
		Date dd = new Date();
		Iterator<Integer> iterator = map.keySet().iterator();
		int count = 0;
		while (iterator.hasNext()) {
			int i = iterator.next();
			row++;
			Map<Integer, Object> m = map.get(i);
			String catelog = String.valueOf(m.get(0));
			String no = String.valueOf(m.get(1));
			String title = String.valueOf(m.get(2));
			if(title.substring(title.length()-2, title.length()).equals(".0")) {
				title = title.substring(0, title.length()-2);
			}
			String data = String.valueOf(m.get(3));
			if(data.substring(data.length()-2, data.length()).equals(".0")) {
				data = data.substring(0, data.length()-2);
			}
			
			JwDeptInformation jwDeptInformation = new JwDeptInformation();
			jwDeptInformation.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			jwDeptInformation.setCatelog(catelog);
			jwDeptInformation.setCreateTime(dd);
			jwDeptInformation.setData(data);
			jwDeptInformation.setDeptId(deptId);
			jwDeptInformation.setNo(no);
			jwDeptInformation.setTitle(title);
			jwDeptInformation.setUpdateTime(dd);
			jwDeptInformation.setCreatorId(null);
			jwDeptInformation.setUpdaterId(null);
			dataMap.put(row, m);
			
			try {				
				deptInformationMapper.insertSelective(jwDeptInformation);
				count++;
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
		}		
		return result;
	}

}
