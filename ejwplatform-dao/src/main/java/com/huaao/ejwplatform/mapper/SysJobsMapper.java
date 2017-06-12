package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysJobs;
import com.huaao.ejwplatform.dao.SysJobsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysJobsMapper {
    int countByExample(SysJobsExample example);

    int deleteByExample(SysJobsExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysJobs record);

    int insertSelective(SysJobs record);

    List<SysJobs> selectByExample(SysJobsExample example);

    SysJobs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysJobs record, @Param("example") SysJobsExample example);

    int updateByExample(@Param("record") SysJobs record, @Param("example") SysJobsExample example);

    int updateByPrimaryKeySelective(SysJobs record);

    int updateByPrimaryKey(SysJobs record);
}