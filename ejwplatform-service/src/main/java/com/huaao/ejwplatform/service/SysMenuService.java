package com.huaao.ejwplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.dao.MenuDto;
import com.huaao.ejwplatform.dao.SysMenu;
import com.huaao.ejwplatform.mapper.SysMenuMapper;

@Service
public class SysMenuService {

	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	public List<MenuDto> getUserMenu(String userId){
		return sysMenuMapper.getUserMenu(userId);
	}
	
}
