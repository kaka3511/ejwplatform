package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.TRoleJobsExample;
import com.huaao.ejwplatform.dao.TRoleJobsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleJobsMapper {
    int countByExample(TRoleJobsExample example);

    int deleteByExample(TRoleJobsExample example);

    int deleteByPrimaryKey(TRoleJobsKey key);

    int insert(TRoleJobsKey record);

    int insertSelective(TRoleJobsKey record);

    List<TRoleJobsKey> selectByExample(TRoleJobsExample example);

    int updateByExampleSelective(@Param("record") TRoleJobsKey record, @Param("example") TRoleJobsExample example);

    int updateByExample(@Param("record") TRoleJobsKey record, @Param("example") TRoleJobsExample example);
}