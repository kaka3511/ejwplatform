package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysDeptExample;
import com.huaao.ejwplatform.dao.SysUserLog;
import com.huaao.ejwplatform.dao.SysUserLogExample;
import com.huaao.ejwplatform.dao.SysUserLogExampleExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserLogMapper {
    int countByExample(SysUserLogExample example);

    int deleteByExample(SysUserLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUserLog record);

    int insertSelective(SysUserLog record);

    List<SysUserLog> selectByExample(SysUserLogExample example);

    SysUserLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUserLog record, @Param("example") SysUserLogExample example);

    int updateByExample(@Param("record") SysUserLog record, @Param("example") SysUserLogExample example);

    int updateByPrimaryKeySelective(SysUserLog record);

    int updateByPrimaryKey(SysUserLog record);
    
    int countByCriteria(@Param("record") SysUserLogExampleExt record, @Param("example") SysUserLogExample example);
}