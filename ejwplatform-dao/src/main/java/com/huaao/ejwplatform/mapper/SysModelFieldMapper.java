package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysModelField;
import com.huaao.ejwplatform.dao.SysModelFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelFieldMapper {
    int countByExample(SysModelFieldExample example);

    int deleteByExample(SysModelFieldExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysModelField record);

    int insertSelective(SysModelField record);

    List<SysModelField> selectByExample(SysModelFieldExample example);

    SysModelField selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysModelField record, @Param("example") SysModelFieldExample example);

    int updateByExample(@Param("record") SysModelField record, @Param("example") SysModelFieldExample example);

    int updateByPrimaryKeySelective(SysModelField record);

    int updateByPrimaryKey(SysModelField record);
}