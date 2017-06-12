package com.huaao.ejwplatform.api.util;

import java.util.Comparator;

import com.huaao.ejwplatform.dao.JwContent;

public class ContentComparator implements Comparator<JwContent> {

	@Override
	public int compare(JwContent o1, JwContent o2) {
		if(o1.getUpdateTime() != null && o2.getUpdateTime() != null){
		    if(o1.getUpdateTime().getTime() < o2.getUpdateTime().getTime()) {
		    	return 1;
		    }
		    return -1;
		}
		return 0;
	}
}
