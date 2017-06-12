package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysContent;
import com.huaao.ejwplatform.dao.SysContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysContentMapper {
    int countByExample(SysContentExample example);

    int deleteByExample(SysContentExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysContent record);

    int insertSelective(SysContent record);

    List<SysContent> selectByExampleWithBLOBs(SysContentExample example);

    List<SysContent> selectByExample(SysContentExample example);

    SysContent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysContent record, @Param("example") SysContentExample example);

    int updateByExampleWithBLOBs(@Param("record") SysContent record, @Param("example") SysContentExample example);

    int updateByExample(@Param("record") SysContent record, @Param("example") SysContentExample example);

    int updateByPrimaryKeySelective(SysContent record);

    int updateByPrimaryKeyWithBLOBs(SysContent record);

    int updateByPrimaryKey(SysContent record);
}