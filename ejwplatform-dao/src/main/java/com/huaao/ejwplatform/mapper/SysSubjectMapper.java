package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysSubject;
import com.huaao.ejwplatform.dao.SysSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSubjectMapper {
    int countByExample(SysSubjectExample example);

    int deleteByExample(SysSubjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysSubject record);

    int insertSelective(SysSubject record);

    List<SysSubject> selectByExample(SysSubjectExample example);

    SysSubject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysSubject record, @Param("example") SysSubjectExample example);

    int updateByExample(@Param("record") SysSubject record, @Param("example") SysSubjectExample example);

    int updateByPrimaryKeySelective(SysSubject record);

    int updateByPrimaryKey(SysSubject record);
}