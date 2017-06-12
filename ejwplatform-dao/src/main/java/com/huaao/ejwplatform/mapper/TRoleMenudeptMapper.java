package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.TRoleMenudeptExample;
import com.huaao.ejwplatform.dao.TRoleMenudeptKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleMenudeptMapper {
    int countByExample(TRoleMenudeptExample example);

    int deleteByExample(TRoleMenudeptExample example);

    int deleteByPrimaryKey(TRoleMenudeptKey key);

    int insert(TRoleMenudeptKey record);

    int insertSelective(TRoleMenudeptKey record);

    List<TRoleMenudeptKey> selectByExample(TRoleMenudeptExample example);

    int updateByExampleSelective(@Param("record") TRoleMenudeptKey record, @Param("example") TRoleMenudeptExample example);

    int updateByExample(@Param("record") TRoleMenudeptKey record, @Param("example") TRoleMenudeptExample example);
}