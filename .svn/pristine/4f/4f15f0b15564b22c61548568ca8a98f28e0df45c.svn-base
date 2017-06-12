package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysModel;
import com.huaao.ejwplatform.dao.SysModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelMapper {
    int countByExample(SysModelExample example);

    int deleteByExample(SysModelExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysModel record);

    int insertSelective(SysModel record);

    List<SysModel> selectByExample(SysModelExample example);

    SysModel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysModel record, @Param("example") SysModelExample example);

    int updateByExample(@Param("record") SysModel record, @Param("example") SysModelExample example);

    int updateByPrimaryKeySelective(SysModel record);

    int updateByPrimaryKey(SysModel record);
}