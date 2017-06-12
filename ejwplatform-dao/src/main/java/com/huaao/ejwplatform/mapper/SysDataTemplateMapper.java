package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysDataTemplate;
import com.huaao.ejwplatform.dao.SysDataTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDataTemplateMapper {
    int countByExample(SysDataTemplateExample example);

    int deleteByExample(SysDataTemplateExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysDataTemplate record);

    int insertSelective(SysDataTemplate record);

    List<SysDataTemplate> selectByExample(SysDataTemplateExample example);

    SysDataTemplate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysDataTemplate record, @Param("example") SysDataTemplateExample example);

    int updateByExample(@Param("record") SysDataTemplate record, @Param("example") SysDataTemplateExample example);

    int updateByPrimaryKeySelective(SysDataTemplate record);

    int updateByPrimaryKey(SysDataTemplate record);
}