package com.huaao.ejwplatform.api.control;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.lifeData.DtoImportLifeDataRequest;
import com.huaao.ejwplatform.api.dto.lifeData.DtoQueryLifeDataRequest;
import com.huaao.ejwplatform.api.dto.lifeData.DtoQueryLifeDataResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwElectricity;
import com.huaao.ejwplatform.dao.JwWater;
import com.huaao.ejwplatform.service.LifeDataService;

@ApiDescription("用水用电")
@Controller
@RequestMapping("api/lifeData")
public class LifeDataController {
	private static final Logger LOG = LoggerFactory.getLogger(LifeDataController.class);
	
	@Autowired
	private LifeDataService lifeDataService;
	
	public static final String YEAR_MONTH = "yyyy-MM"; 
	
	 
	@Value("${uploadPath}")
	private String uploadPath;
	
	@ApiDescription("用水用电数据查询;负责人：hongli")
	@RequestMapping("getLifeData")
	@ResponseBody
	public DtoPublicResponsePager<DtoQueryLifeDataResponse> getLifeData(@Valid DtoQueryLifeDataRequest dtoRequest) {
		DtoPublicResponsePager<DtoQueryLifeDataResponse> dtoResponse = new DtoPublicResponsePager<DtoQueryLifeDataResponse>();
		try{
			if(dtoRequest.getType() == null || dtoRequest.getType().intValue() == 0){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg("类型必需输入");
				return dtoResponse;
			}
			List<DtoQueryLifeDataResponse> lifeDatas = new ArrayList<DtoQueryLifeDataResponse>();
			Page page = new Page(dtoRequest.getPage(), dtoRequest.getPageSize());
			String orderby = StringUtils.isBlank(dtoRequest.getSortby()) ? " order_id "
					: dtoRequest.getSortby();
			if(dtoRequest.getType().intValue() == 1){//用水
				List<JwWater> jwWaters = lifeDataService.queryWaterList(page, dtoRequest.getStartMonth(), dtoRequest.getEndMonth(), 
						orderby , dtoRequest.getKeyword(), dtoRequest.getDeptId());
				if(jwWaters != null){
					for(JwWater jwWater:jwWaters){
						DtoQueryLifeDataResponse lifeData = new DtoQueryLifeDataResponse();
						BeanUtils.copyProperties(jwWater, lifeData);
						lifeData.setUserNo(jwWater.getWateNo());
						lifeDatas.add(lifeData);
					}
				}
			}else if(dtoRequest.getType().intValue() == 2){//用电
				List<JwElectricity> jwElectricitys = lifeDataService.queryElectricityList(page, dtoRequest.getStartMonth(), dtoRequest.getEndMonth(), 
						orderby, dtoRequest.getKeyword(), dtoRequest.getDeptId());
				if(jwElectricitys != null){
					for(JwElectricity jwElectricity:jwElectricitys){
						DtoQueryLifeDataResponse lifeData = new DtoQueryLifeDataResponse();
						BeanUtils.copyProperties(jwElectricity, lifeData);
						lifeData.setUserNo(jwElectricity.getElectricityNo());
						lifeDatas.add(lifeData);
					}
				}
			}
			dtoResponse.setData(lifeDatas);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
			dtoResponse.setRecords(page.getTotalCount());
			dtoResponse.setPage(dtoRequest.getPage());
			dtoResponse.setPageSize(dtoRequest.getPageSize());
		} catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("用水用电数据查询接口失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	@ApiDescription("用水用电数据导入;负责人：hongli")
	@RequestMapping("importLifeData")
	@ResponseBody
	public DtoPublicResponse importLifeData(@Valid DtoImportLifeDataRequest dtoRequest) {
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			String filepath = uploadPath+dtoRequest.getFilepath();
			File f = new File(filepath);
			if(!f.exists()){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg("文件不存在");
				LOG.error("用水用电数据导入失败，"+filepath+"文件不存在");
				return dtoResponse;
			}
			SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(YEAR_MONTH);  
	        String month = localSimpleDateFormat.format(new Date());
	        
	        if (dtoRequest.getMonth().compareTo(month) >= 1){
	        	dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg("不允许操作导入超过当前月份的数据");
				LOG.error("不允许操作导入超过当前月份的数据");
				return dtoResponse;
	        }
	        
			Map<String , Object> result = lifeDataService.importLifeData(filepath, dtoRequest.getDeptId(), 
					dtoRequest.getType(), dtoRequest.getUid(), dtoRequest.getMonth());
			dtoResponse.setCode((Integer)result.get("code"));
			dtoResponse.setMsg((String)result.get("msg"));
		}catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("用水用电数据导入接口失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
}
