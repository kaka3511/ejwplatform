package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysVcode;
import com.huaao.ejwplatform.dao.SysVcodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysVcodeMapper {
    int countByExample(SysVcodeExample example);

    int deleteByExample(SysVcodeExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysVcode record);

    int insertSelective(SysVcode record);

    List<SysVcode> selectByExample(SysVcodeExample example);

    SysVcode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysVcode record, @Param("example") SysVcodeExample example);

    int updateByExample(@Param("record") SysVcode record, @Param("example") SysVcodeExample example);

    int updateByPrimaryKeySelective(SysVcode record);

    int updateByPrimaryKey(SysVcode record);
}