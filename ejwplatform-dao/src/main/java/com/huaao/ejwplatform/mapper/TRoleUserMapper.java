package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.TRoleUserExample;
import com.huaao.ejwplatform.dao.TRoleUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleUserMapper {
    int countByExample(TRoleUserExample example);

    int deleteByExample(TRoleUserExample example);

    int deleteByPrimaryKey(TRoleUserKey key);

    int insert(TRoleUserKey record);

    int insertSelective(TRoleUserKey record);

    List<TRoleUserKey> selectByExample(TRoleUserExample example);

    int updateByExampleSelective(@Param("record") TRoleUserKey record, @Param("example") TRoleUserExample example);

    int updateByExample(@Param("record") TRoleUserKey record, @Param("example") TRoleUserExample example);
}