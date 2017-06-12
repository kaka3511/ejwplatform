package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysApplyRecord;
import com.huaao.ejwplatform.dao.SysApplyRecordExample;
import com.huaao.ejwplatform.dao.SysApplyRecordExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysApplyRecordMapper {
    int countByExample(SysApplyRecordExample example);

    int deleteByExample(SysApplyRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysApplyRecord record);

    int insertSelective(SysApplyRecord record);

    List<SysApplyRecord> selectByExample(SysApplyRecordExample example);

    SysApplyRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysApplyRecord record, @Param("example") SysApplyRecordExample example);

    int updateByExample(@Param("record") SysApplyRecord record, @Param("example") SysApplyRecordExample example);

    int updateByPrimaryKeySelective(SysApplyRecord record);

    int updateByPrimaryKey(SysApplyRecord record);

	List<SysApplyRecordExt> selectByRecordId(String recordId);
}