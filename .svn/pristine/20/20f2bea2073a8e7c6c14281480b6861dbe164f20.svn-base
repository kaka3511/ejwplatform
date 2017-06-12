package com.huaao.ejwplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaao.ejwplatform.dao.SysArea;
import com.huaao.ejwplatform.dao.SysAreaExample;
import com.huaao.ejwplatform.dao.SysAreaExt;

public interface SysAreaMapper {
    int countByExample(SysAreaExample example);

    int deleteByExample(SysAreaExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysArea record);

    int insertSelective(SysArea record);

    List<SysArea> selectByExample(SysAreaExample example);

    SysArea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysArea record, @Param("example") SysAreaExample example);

    int updateByExample(@Param("record") SysArea record, @Param("example") SysAreaExample example);

    int updateByPrimaryKeySelective(SysArea record);

    int updateByPrimaryKey(SysArea record);

	List<SysAreaExt> selectByExampleExt(SysAreaExample deptExample);
	
	SysAreaExt selectByPrimaryKeyExt(String id);
}