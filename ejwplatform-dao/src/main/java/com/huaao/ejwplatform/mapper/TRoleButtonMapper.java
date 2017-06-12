package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.TRoleButtonExample;
import com.huaao.ejwplatform.dao.TRoleButtonKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleButtonMapper {
    int countByExample(TRoleButtonExample example);

    int deleteByExample(TRoleButtonExample example);

    int deleteByPrimaryKey(TRoleButtonKey key);

    int insert(TRoleButtonKey record);

    int insertSelective(TRoleButtonKey record);

    List<TRoleButtonKey> selectByExample(TRoleButtonExample example);

    int updateByExampleSelective(@Param("record") TRoleButtonKey record, @Param("example") TRoleButtonExample example);

    int updateByExample(@Param("record") TRoleButtonKey record, @Param("example") TRoleButtonExample example);
}