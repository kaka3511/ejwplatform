package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysQuestionRecord;
import com.huaao.ejwplatform.dao.SysQuestionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysQuestionRecordMapper {
    int countByExample(SysQuestionRecordExample example);

    int deleteByExample(SysQuestionRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysQuestionRecord record);

    int insertSelective(SysQuestionRecord record);

    List<SysQuestionRecord> selectByExample(SysQuestionRecordExample example);

    SysQuestionRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysQuestionRecord record, @Param("example") SysQuestionRecordExample example);

    int updateByExample(@Param("record") SysQuestionRecord record, @Param("example") SysQuestionRecordExample example);

    int updateByPrimaryKeySelective(SysQuestionRecord record);

    int updateByPrimaryKey(SysQuestionRecord record);
}