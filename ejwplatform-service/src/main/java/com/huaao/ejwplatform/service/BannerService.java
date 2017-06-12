package com.huaao.ejwplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.dao.JwDeptBanner;
import com.huaao.ejwplatform.dao.JwDeptBannerExample;
import com.huaao.ejwplatform.mapper.JwDeptBannerMapper;

@Service
public class BannerService {

	@Autowired
	private JwDeptBannerMapper bannerMapper;
	
	public List<JwDeptBanner> queryBanner(Integer status ,String sortBy){
		JwDeptBannerExample example = new JwDeptBannerExample();
		example.createCriteria()
		.andStatusEqualTo(status);
		if(sortBy == null){
			example.setOrderByClause("sort ");
		}else{
			example.setOrderByClause(sortBy);
		}
		example.setOffset(0);
		example.setLimit(5);
		return bannerMapper.selectByExample(example);
	}

	public List<JwDeptBanner> queryDeptBanner(String deptId, Integer status, String sortBy, String type) throws Exception{
		JwDeptBannerExample example = new JwDeptBannerExample();
		example.createCriteria().andStatusEqualTo(status).andDeptIdEqualTo(deptId);
		if(type != null){
			example.getOredCriteria().get(0).andTypeEqualTo(Integer.parseInt(type));
		}
		if(sortBy == null){
			example.setOrderByClause("sort ");
		}else{
			example.setOrderByClause(sortBy);
		}
		return bannerMapper.selectByExample(example);
	}
}
