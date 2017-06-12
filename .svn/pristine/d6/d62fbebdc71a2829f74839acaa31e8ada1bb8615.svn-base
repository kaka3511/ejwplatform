package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysLogs;
import com.huaao.ejwplatform.dao.SysLogsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogsMapper {
    int countByExample(SysLogsExample example);

    int deleteByExample(SysLogsExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysLogs record);

    int insertSelective(SysLogs record);

    List<SysLogs> selectByExample(SysLogsExample example);

    SysLogs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysLogs record, @Param("example") SysLogsExample example);

    int updateByExample(@Param("record") SysLogs record, @Param("example") SysLogsExample example);

    int updateByPrimaryKeySelective(SysLogs record);

    int updateByPrimaryKey(SysLogs record);
}