package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.AreaItem;
import com.huaao.ejwplatform.api.dto.bean.CourseItem;
import com.huaao.ejwplatform.api.dto.bean.CourseItemHelper;
import com.huaao.ejwplatform.api.dto.bean.DeptInformationInfo;
import com.huaao.ejwplatform.api.dto.bean.DeptInformationInfoHelper;
import com.huaao.ejwplatform.api.dto.bean.EnterpriseItem;
import com.huaao.ejwplatform.api.dto.bean.EnterpriseItemHelper;
import com.huaao.ejwplatform.api.dto.bean.HotItem;
import com.huaao.ejwplatform.api.dto.bean.PopulationItem;
import com.huaao.ejwplatform.api.dto.bean.PopulationItemHelper;
import com.huaao.ejwplatform.api.dto.bean.UserItem;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptCourse;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptCourseItem;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptHot;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptHotData;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptInfoWrap;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptInfomationItem;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptInfomationItemData;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptInformationQueryRequest;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptInstitution;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptInstitutionItem;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptPopulation;
import com.huaao.ejwplatform.api.dto.deptinformation.DeptPopulationData;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwDeptInformation;
import com.huaao.ejwplatform.mapper.SysDeptMapper;
import com.huaao.ejwplatform.mapper.SysUserMapper;
import com.huaao.ejwplatform.service.JwDeptInformationService;

@ApiDescription("微信息")
@Controller
@RequestMapping("api/deptInformation")
public class DeptInformationController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JwDeptInformationService deptInformationService;
	@Autowired
	private SysDeptMapper deptMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@ApiDescription("微信息数据查询;负责人:lihao")
	@RequestMapping("queryData")
	@ResponseBody
	public DtoPublicResponseObj<DeptInfoWrap> queryData(@Valid DtoPublicRequest dtoRequest) throws Exception {
		DtoPublicResponseObj<DeptInfoWrap> dtoResponse = new DtoPublicResponseObj();
		String deptId = userMapper.selectByPrimaryKey(dtoRequest.getUid()).getDeptId();
		List<JwDeptInformation> deptInformations = deptInformationService.queryDeptDataInformation(deptId);
		DeptInfoWrap target = new DeptInfoWrap();
		target.setName(deptMapper.selectByPrimaryKey(deptId).getName());
		
		DeptInfomationItem deptinformation = new DeptInfomationItem();
		List<DeptInfomationItemData> listDeptInformation = new ArrayList<>();
		
		DeptPopulation population = new DeptPopulation();
		List<DeptPopulationData> listDeptPopulation1 = new ArrayList<>();
		List<DeptPopulationData> listDeptPopulation2 = new ArrayList<>();
		
		DeptInstitution institution = new DeptInstitution();
		List<DeptInstitutionItem> listInstitution = new ArrayList<>();
		
		
		DeptHot hot = new DeptHot();
		List<DeptHotData> listHot = new ArrayList<>();
		
		DeptCourse course = new DeptCourse();
		List<DeptCourseItem> listCourse = new ArrayList<>();
		
		
		for (JwDeptInformation jw: deptInformations) {		
			//辖区信息
			if (jw.getNo().startsWith("2")) {
				if(jw.getNo().toCharArray()[2] == '1'){
					deptinformation.setDescription(jw.getData());
				}
				else{
					DeptInfomationItemData deData = new DeptInfomationItemData();
					deData.setName(jw.getTitle());
					deData.setNum(jw.getData());
					listDeptInformation.add(deData);
				}				
			}
			
			
			//人口数据
			if(jw.getNo().startsWith("3")){
				if(jw.getNo().toCharArray()[2] == '1')
					population.setDescription(jw.getData());
				else if(jw.getNo().toCharArray()[2] == '2')
					population.setTotal(jw.getData());
				else{
					if(jw.getNo().toCharArray()[2] == '3'){
						DeptPopulationData populationData = new DeptPopulationData();
						populationData.setName(jw.getTitle());
						populationData.setValue(jw.getData());
						listDeptPopulation1.add(populationData);
					}
					if(jw.getNo().toCharArray().length >= 3){
						if(jw.getNo().toCharArray()[2] == '4'){
						DeptPopulationData populationData = new DeptPopulationData();
						populationData.setName(jw.getTitle());
						populationData.setValue(jw.getData());
						listDeptPopulation2.add(populationData);
					}
					}
				}
			}
			
			//企业信息
			if(jw.getNo().startsWith("4")){
				if(jw.getNo().toCharArray()[2] == '1'){
					institution.setDescription(jw.getData());
				}
				else{
					DeptInstitutionItem institutionData = new DeptInstitutionItem();
					institutionData.setType(jw.getTitle());
					institutionData.setNumber(jw.getData());
					listInstitution.add(institutionData);
				}
			}
			
			
			//焦点信息
			if(jw.getNo().startsWith("5")){
				if(jw.getNo().toCharArray()[2] == '1')
					hot.setDescription(jw.getData());
				else{
					DeptHotData hotData = new DeptHotData();
					hotData.setKeyword(jw.getTitle());
					hotData.setDescription(jw.getData());
					listHot.add(hotData);
				}		
			}
			
			//发展历程
			if(jw.getNo().startsWith("1")){
				char[] iii = jw.getNo().toCharArray();
				if(jw.getNo().toCharArray()[2] == '1')
					course.setDescription(jw.getData());
				else{
					DeptCourseItem courseData = new DeptCourseItem();
					courseData.setYear(jw.getTitle());
					courseData.setEvent(jw.getData());
					listCourse.add(courseData);
				}
			}
			
			
		}
		
		deptinformation.setData(listDeptInformation);
		population.setData1(listDeptPopulation1);
		population.setData2(listDeptPopulation2);
		institution.setData(listInstitution);
		hot.setKeywords(listHot);
		course.setData(listCourse);
		
		target.setInformation(deptinformation);
		target.setPopulation(population);
		target.setInstitution(institution);
		target.setHot(hot);
		target.setCourse(course);
			
		dtoResponse.setData(target);
	
		return dtoResponse;
	}
	
	
	@ApiDescription("微信息查询;负责人：fuwei")
	@RequestMapping("query")
	@ResponseBody
	public DtoPublicResponsePager<DeptInformationInfo> query(@Valid DeptInformationQueryRequest dtoRequest){
		DtoPublicResponsePager<DeptInformationInfo> dtoResponse = new DtoPublicResponsePager<DeptInformationInfo>();
		Page page = ApiTool.convert(dtoRequest);	
		List<JwDeptInformation> list = deptInformationService.queryDeptInformationList(dtoRequest.getDeptId(), page);
		List<DeptInformationInfo> result = new ArrayList<DeptInformationInfo>();

		String startDeptId = null;
		for(JwDeptInformation item:list){
			if(StringUtils.equals(item.getDeptId(), startDeptId))
				continue;
			DeptInformationInfo o = new DeptInformationInfo();
//			o.setId(item.getId());
			o.setDeptId(item.getDeptId());
			o.setCreateTime(item.getCreateTime());
			o.setUpdateTime(item.getUpdateTime());
			o.setCreator(FuncTool.copyPropertiesClass(userMapper.selectByPrimaryKey(item.getCreatorId()), UserItem.class));
			o.setUpdater(FuncTool.copyPropertiesClass(userMapper.selectByPrimaryKey(item.getUpdaterId()), UserItem.class));
			result.add(o);
			startDeptId = item.getDeptId();
		}
		
		List<List<String>> helps = new ArrayList<List<String>>();
		for(JwDeptInformation item:list){
			List<String> l = new ArrayList<String>();
			l.add(item.getCatelog());
			l.add(item.getNo());
			l.add(item.getTitle());
			l.add(item.getData());
			helps.add(l);
		}
		
		//将数据存进result
		int i=0;
		for(DeptInformationInfo item:result){
			
			CourseItem courseItem = new CourseItem();
			AreaItem areaItem = new AreaItem();
			PopulationItem populationItem = new PopulationItem();
			EnterpriseItem enterpriseItem = new EnterpriseItem();
			HotItem hotItem = new HotItem();
			
			//发展历程
			DeptInformationInfoHelper helper1 = new DeptInformationInfoHelper();
			CourseItemHelper courseHelper = new CourseItemHelper();
			helper1.setTitle(helps.get(i).get(2));
			helper1.setData(helps.get(i++).get(3));
			courseItem.setCourse0(helper1);
			
			helper1 = new DeptInformationInfoHelper();
			helper1.setTitle(helps.get(i).get(2));
			helper1.setData(helps.get(i++).get(3));
			courseItem.setCourse1(helper1);
						
			helper1 = new DeptInformationInfoHelper();
			helper1.setTitle(helps.get(i).get(2));
			helper1.setData(helps.get(i++).get(3));
			courseHelper.setCourse2(helper1);

			
			helper1 = new DeptInformationInfoHelper();
			helper1.setTitle(helps.get(i).get(2));
			helper1.setData(helps.get(i++).get(3));
			courseHelper.setCourse3(helper1);

			
			helper1 = new DeptInformationInfoHelper();
			helper1.setTitle(helps.get(i).get(2));
			helper1.setData(helps.get(i++).get(3));
			courseHelper.setCourse4(helper1);

			courseItem.setCourse22(courseHelper);
			
			
			//辖区信息
			DeptInformationInfoHelper helper2 = new DeptInformationInfoHelper();
			helper2.setTitle(helps.get(i).get(2));
			helper2.setData(helps.get(i++).get(3));
			areaItem.setArea0(helper2);
			
			helper2 = new DeptInformationInfoHelper();
			helper2.setTitle(helps.get(i).get(2));
			helper2.setData(helps.get(i++).get(3));
			areaItem.setArea1(helper2);
			
			helper2 = new DeptInformationInfoHelper();
			helper2.setTitle(helps.get(i).get(2));
			helper2.setData(helps.get(i++).get(3));
			areaItem.setArea2(helper2);
			
			helper2 = new DeptInformationInfoHelper();
			helper2.setTitle(helps.get(i).get(2));
			helper2.setData(helps.get(i++).get(3));
			areaItem.setArea3(helper2);
			
			helper2 = new DeptInformationInfoHelper();
			helper2.setTitle(helps.get(i).get(2));
			helper2.setData(helps.get(i++).get(3));
			areaItem.setArea4(helper2);
			
			helper2 = new DeptInformationInfoHelper();
			helper2.setTitle(helps.get(i).get(2));
			helper2.setData(helps.get(i++).get(3));
			areaItem.setArea5(helper2);
			
			helper2 = new DeptInformationInfoHelper();
			helper2.setTitle(helps.get(i).get(2));
			helper2.setData(helps.get(i++).get(3));
			areaItem.setArea6(helper2);
			
			
			//人口数据
			DeptInformationInfoHelper helper3 = new DeptInformationInfoHelper();
			PopulationItemHelper populationHelper = new PopulationItemHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationItem.setPopulation0(helper3);
			
			helper3 = new DeptInformationInfoHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationItem.setPopulation1(helper3);
			
			helper3 = new DeptInformationInfoHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationHelper.setPopulation2(helper3);
			
			helper3 = new DeptInformationInfoHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationHelper.setPopulation3(helper3);
			
			helper3 = new DeptInformationInfoHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationHelper.setPopulation4(helper3);
			populationItem.setPopulation22(populationHelper);
			
			helper3 = new DeptInformationInfoHelper();
			populationHelper = new PopulationItemHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationHelper.setPopulation2(helper3);
			
			helper3 = new DeptInformationInfoHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationHelper.setPopulation3(helper3);
			
			helper3 = new DeptInformationInfoHelper();
			helper3.setTitle(helps.get(i).get(2));
			helper3.setData(helps.get(i++).get(3));
			populationHelper.setPopulation4(helper3);
			populationItem.setPopulation33(populationHelper);
			
			
			//企业机构
			DeptInformationInfoHelper helper4 = new DeptInformationInfoHelper();
			EnterpriseItemHelper enterpriseHelper = new EnterpriseItemHelper();
			helper4.setTitle(helps.get(i).get(2));
			helper4.setData(helps.get(i++).get(3));
			enterpriseItem.setEnterprise0(helper4);
			
			helper4 = new DeptInformationInfoHelper();
			enterpriseHelper = new EnterpriseItemHelper();
			helper4.setTitle(helps.get(i).get(2));
			helper4.setData(helps.get(i++).get(3));
			enterpriseHelper.setEnterprise1(helper4);
			
			helper4 = new DeptInformationInfoHelper();
			helper4.setTitle(helps.get(i).get(2));
			helper4.setData(helps.get(i++).get(3));
			enterpriseHelper.setEnterprise2(helper4);
			enterpriseItem.setEnterprise11(enterpriseHelper);
			
			helper4 = new DeptInformationInfoHelper();
			enterpriseHelper = new EnterpriseItemHelper();
			helper4.setTitle(helps.get(i).get(2));
			helper4.setData(helps.get(i++).get(3));
			enterpriseHelper.setEnterprise1(helper4);
			
			helper4 = new DeptInformationInfoHelper();
			helper4.setTitle(helps.get(i).get(2));
			helper4.setData(helps.get(i++).get(3));
			enterpriseHelper.setEnterprise2(helper4);
			enterpriseItem.setEnterprise22(enterpriseHelper);
			
			helper4 = new DeptInformationInfoHelper();
			enterpriseHelper = new EnterpriseItemHelper();
			helper4.setTitle(helps.get(i).get(2));
			helper4.setData(helps.get(i++).get(3));
			enterpriseHelper.setEnterprise1(helper4);
			
			helper4 = new DeptInformationInfoHelper();
			helper4.setTitle(helps.get(i).get(2));
			helper4.setData(helps.get(i++).get(3));
			enterpriseHelper.setEnterprise2(helper4);
			enterpriseItem.setEnterprise33(enterpriseHelper);
			
			
			//焦点信息
			DeptInformationInfoHelper helper5 = new DeptInformationInfoHelper();
			helper5.setTitle(helps.get(i).get(2));
			helper5.setData(helps.get(i++).get(3));
			hotItem.setHot0(helper5);
			
			helper5 = new DeptInformationInfoHelper();
			helper5.setTitle(helps.get(i).get(2));
			helper5.setData(helps.get(i++).get(3));
			hotItem.setHot1(helper5);
			
			helper5 = new DeptInformationInfoHelper();
			helper5.setTitle(helps.get(i).get(2));
			helper5.setData(helps.get(i++).get(3));
			hotItem.setHot2(helper5);
			
			helper5 = new DeptInformationInfoHelper();
			helper5.setTitle(helps.get(i).get(2));
			helper5.setData(helps.get(i++).get(3));
			hotItem.setHot3(helper5);
			
			helper5 = new DeptInformationInfoHelper();
			helper5.setTitle(helps.get(i).get(2));
			helper5.setData(helps.get(i++).get(3));
			hotItem.setHot4(helper5);
			
			helper5 = new DeptInformationInfoHelper();
			helper5.setTitle(helps.get(i).get(2));
			helper5.setData(helps.get(i++).get(3));
			hotItem.setHot5(helper5);

			
						
			
			item.setCourseItem(courseItem);
			item.setAreaItem(areaItem);
			item.setPopulationItem(populationItem);
			item.setEnterpriseItem(enterpriseItem);
			item.setHotItem(hotItem);
		}
		
		dtoResponse.setData(result);
		
		
		return dtoResponse;
	}
	
}
