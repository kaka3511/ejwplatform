package com.huaao.ejwplatform.dao;

/**
 * 
* @Title: SysAreaExt.java
* @Package com.huaao.ejwplatform.dao
* @Description: 区域扩展类
* @author hongli  
* @date 2017年3月15日 下午5:41:05
 */
public class SysAreaExt extends SysArea{
	
	private static final long serialVersionUID = 1680338358167951169L;
	
	private SysAreaExt parent;
	
	public SysAreaExt getParent() {
		return parent;
	}

	public void setParent(SysAreaExt parent) {
		this.parent = parent;
	}
}
