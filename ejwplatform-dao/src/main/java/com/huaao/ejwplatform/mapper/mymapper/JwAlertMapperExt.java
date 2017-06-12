package com.huaao.ejwplatform.mapper.mymapper;

import java.util.List;
import java.util.Map;

import com.huaao.ejwplatform.dao.JwAlertExampleExt;

public interface JwAlertMapperExt {
	int countByCriteria(JwAlertExampleExt example);
	
	List<Map<String, String>> selectCreatorIdToInputerId();
}
