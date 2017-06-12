package com.huaao.ejwplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaao.ejwplatform.dao.JwContent;
import com.huaao.ejwplatform.dao.JwContentExample;
import com.huaao.ejwplatform.dao.JwContentExampleExt;

public interface JwContentMapper {
    int countByExample(JwContentExample example);

    int deleteByExample(JwContentExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwContent record);

    int insertSelective(JwContent record);

    List<JwContent> selectByExampleWithBLOBs(JwContentExample example);

    List<JwContent> selectByExample(JwContentExample example);

    JwContent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwContent record, @Param("example") JwContentExample example);

    int updateByExampleWithBLOBs(@Param("record") JwContent record, @Param("example") JwContentExample example);

    int updateByExample(@Param("record") JwContent record, @Param("example") JwContentExample example);

    int updateByPrimaryKeySelective(JwContent record);

    int updateByPrimaryKeyWithBLOBs(JwContent record);

    int updateByPrimaryKey(JwContent record);
    
    int updateMsgStatusByPrimaryKey(JwContent record);
    
    List<JwContent> selectMultiByExample(JwContentExampleExt example);
    
    int countMultiByExample(JwContentExampleExt example);

    int countMultiByExampleExt(JwContentExampleExt example);
    
    List<JwContent> selectMultiByExampleExt(JwContentExampleExt example);

	int countUptopsByExample(JwContentExampleExt exa);

	void updateUptopInfoByPrimaryKey(JwContent jwContent);
	
	String selectUpdaterDeptNameByUpdaterId(String updaterId);

	int countZhengCheXueXiByExample(JwContentExampleExt example);

	List<JwContent> selectZhengCheXueXiByExample(JwContentExampleExt example);
	
	List<JwContent> selectMultiByIds(@Param("list") List<String> ids);
	
	
}