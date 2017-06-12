package com.huaao.ejwplatform.api.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.CoordConvert;
import com.huaao.ejwplatform.dao.JwEntity;
import com.huaao.ejwplatform.dao.JwEntityExample;
import com.huaao.ejwplatform.dao.SysDept;
import com.huaao.ejwplatform.dao.SysDeptExample;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.mapper.JwEntityMapper;
import com.huaao.ejwplatform.mapper.SysDeptMapper;

/**
 * 将 sys_dept , sys_entity表中的百度坐标数据转换为 高得坐标数据
 * @author lihao
 *
 */
public class ConvertLocationData {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = getContext(); 
//        SysDeptMapper deptMapper = context.getBean(SysDeptMapper.class);
//        SysDeptExample sde = new SysDeptExample();
//        sde.setOrderByClause(" code ");
//        List<SysDeptWithBLOBs> list = deptMapper.selectByExampleWithBLOBs(sde);
//        for(SysDeptWithBLOBs item : list){
//        	System.out.println(item.getId());
//        	
//        	SysDeptWithBLOBs sdwb = new SysDeptWithBLOBs();
//        	boolean changeFlag = false;
//        	if(!StringUtils.isBlank(item.getXyz()) ){
//        		changeFlag = true;
//        		sdwb.setXyzGd(CoordConvert.batchBaidu2Amap(item.getXyz()).replace(";", "|"));
//        	}
//        	if(!StringUtils.isBlank(item.getLocation()) ){
//        		changeFlag = true;
//        		sdwb.setLocationGd(CoordConvert.batchBaidu2Amap(item.getLocation()).replace(";", "|"));
//        	}
//        	if(!StringUtils.isBlank(item.getBgImageSpot()) ){
//        		changeFlag = true;
//        		sdwb.setBgImageSpotGd(CoordConvert.batchBaidu2Amap(item.getBgImageSpot()).replace(";", "|"));
//        	}
//        	
//        	if(changeFlag){
//        		sdwb.setId(item.getId());
//            	deptMapper.updateByPrimaryKeySelective(sdwb);
//            	Thread.sleep(1000);
//        	}
//        }
        
//        JwEntityMapper jem = context.getBean(JwEntityMapper.class);
//        JwEntityExample jee = new JwEntityExample();
//        jee.setOrderByClause(" create_time ");
//        List<JwEntity> listEntity = jem.selectByExample(jee);
//        for(JwEntity item : listEntity){
//        	System.out.println(item.getId());
//        	JwEntity obj = new JwEntity();
//        	boolean changeFlag = false;
//        	if(!StringUtils.isBlank(item.getLocation())){
//        		obj.setLocationGd(CoordConvert.batchBaidu2Amap(item.getLocation()).replace(";", "|"));
//        		changeFlag = true;
//        	}
//        	if(changeFlag){
//        		obj.setId(item.getId());
//        		jem.updateByPrimaryKeySelective(obj);
//            	Thread.sleep(1000);
//        	}
//        }
	}
	
	public static void SysDeptBaidu2Gaode(String id){
		
		//Location转存
		ApplicationContext context = getContext(); 
        SysDeptMapper deptMapper = context.getBean(SysDeptMapper.class);
		SysDept dept = deptMapper.selectByPrimaryKey(id);
		SysDeptWithBLOBs bloBs = FuncTool.copyPropertiesClass(dept, SysDeptWithBLOBs.class);
		String location = bloBs.getLocation();
		if(!(location == null || StringUtils.equals(location, ""))){
			Double lon1 = Double.parseDouble(location.split(",")[0]);
			Double lat1 =Double.parseDouble(location.split(",")[1]);
			double[] gd_lat_lon1 = new double[2];
			gd_lat_lon1 = bdToGaoDe(lon1,lat1);
			double gd_lon1 = gd_lat_lon1[0];
			double gd_lat1 = gd_lat_lon1[1];
			bloBs.setLocationGd(""+gd_lon1+","+gd_lat1);		
		}
		
		//xyz转存
		String xyz = bloBs.getXyz();
		if(!(xyz == null || StringUtils.equals(xyz, ""))){
			String[] xyzStrs = xyz.split("\\|");	
			String[] xyzGd = new String[xyzStrs.length];
			for(int i=0;i < xyzStrs.length;i++){
				double lon2 = Double.parseDouble(xyzStrs[i].split(",")[0]);
				double lat2 = Double.parseDouble(xyzStrs[i].split(",")[1]);
				double[] gd_lat_lon2 = new double[2];
				gd_lat_lon2 = bdToGaoDe(lon2,lat2);
				xyzGd[i] = gd_lat_lon2[0]+","+gd_lat_lon2[1];
				if(i != xyzStrs.length - 1)
					xyzGd[i] = xyzGd[i] +"|";
			}
			String xyzGdStr = "";
			for(String o:xyzGd)
				xyzGdStr = xyzGdStr + o;
			xyzGdStr = xyzGdStr.substring(0, xyzGdStr.length()-1);	
			bloBs.setXyzGd(xyzGdStr);
		}
		
		//imgSpot转存
		String imgSpot = bloBs.getBgImageSpot();
		if(!(imgSpot == null || StringUtils.equals(imgSpot, ""))){
			String[] imgSpots = imgSpot.split("\\|");		
			String[] imgSpotsGd = new String[imgSpots.length];
			for(int i=0;i < imgSpots.length;i++){
				double lon3 = Double.parseDouble(imgSpots[i].split(",")[0]);
				double lat3 = Double.parseDouble(imgSpots[i].split(",")[1]);
				double[] gd_lat_lon3 = new double[2];
				gd_lat_lon3 = bdToGaoDe(lon3,lat3);
				imgSpotsGd[i] = gd_lat_lon3[0]+","+gd_lat_lon3[1];
				if(i != imgSpots.length - 1)
					imgSpotsGd[i] = imgSpotsGd[i] +"|";
			}
			String imgSpotsGdStr = "";
			for(String o:imgSpotsGd)
				imgSpotsGdStr = imgSpotsGdStr + o;
			imgSpotsGdStr = imgSpotsGdStr.substring(0, imgSpotsGdStr.length()-1);	
			bloBs.setBgImageSpotGd(imgSpotsGdStr);
		}
		deptMapper.updateByPrimaryKeyWithBLOBs(bloBs);		
	}
	
	public static void JwEntityBaidu2Gaode(String id){
//		convertJwEntityLocation(id);
		ApplicationContext context = getContext(); 
		JwEntityMapper entityMapper = context.getBean(JwEntityMapper.class);
		JwEntity entity = entityMapper.selectByPrimaryKey(id);
		String location = entity.getLocation();
		if(location == null || StringUtils.equals(location, "")){
			Double lon = Double.parseDouble(location.split(",")[0]);
			Double lat =Double.parseDouble(location.split(",")[1]);
			double[] gd_lat_lon = new double[2];
			gd_lat_lon = bdToGaoDe(lon,lat);
			double gd_lon = gd_lat_lon[0];
			double gd_lat = gd_lat_lon[1];
			entity.setLocationGd(""+gd_lon+","+gd_lat);
		}
		entityMapper.updateByPrimaryKey(entity);
	}	
	
	
	private double[] gaoDeToBaidu(double gd_lon, double gd_lat) {
	    double[] bd_lat_lon = new double[2];
	    double PI = 3.14159265358979324 * 3000.0 / 180.0;
	    double x = gd_lon, y = gd_lat;
	    double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * PI);
	    double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * PI);
	    bd_lat_lon[0] = z * Math.cos(theta) + 0.0065;
	    bd_lat_lon[1] = z * Math.sin(theta) + 0.006;
	    return bd_lat_lon;
	}
	
	private static double[] bdToGaoDe(double bd_lat, double bd_lon) {
	    double[] gd_lat_lon = new double[2];
	    double PI = 3.14159265358979324 * 3000.0 / 180.0;
	    double x = bd_lon - 0.0065, y = bd_lat - 0.006;
	    double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * PI);
	    double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * PI);
	    gd_lat_lon[0] = z * Math.sin(theta);
	    gd_lat_lon[1] = z * Math.cos(theta);
	    return gd_lat_lon;
	 }
	
	
	public static ApplicationContext getContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                new String[] {"run-main-context.xml"}); 
		return context;
	}
	
}

