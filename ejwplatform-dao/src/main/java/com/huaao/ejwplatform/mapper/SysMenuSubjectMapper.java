package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysMenuSubject;
import com.huaao.ejwplatform.dao.SysMenuSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuSubjectMapper {
    int countByExample(SysMenuSubjectExample example);

    int deleteByExample(SysMenuSubjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysMenuSubject record);

    int insertSelective(SysMenuSubject record);

    List<SysMenuSubject> selectByExample(SysMenuSubjectExample example);

    SysMenuSubject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMenuSubject record, @Param("example") SysMenuSubjectExample example);

    int updateByExample(@Param("record") SysMenuSubject record, @Param("example") SysMenuSubjectExample example);

    int updateByPrimaryKeySelective(SysMenuSubject record);

    int updateByPrimaryKey(SysMenuSubject record);
}