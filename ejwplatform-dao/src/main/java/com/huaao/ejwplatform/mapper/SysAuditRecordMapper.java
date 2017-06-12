package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.SysAuditRecord;
import com.huaao.ejwplatform.dao.SysAuditRecordExample;
import com.huaao.ejwplatform.dao.SysAuditRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuditRecordMapper {
    int countByExample(SysAuditRecordExample example);

    int deleteByExample(SysAuditRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysAuditRecordWithBLOBs record);

    int insertSelective(SysAuditRecordWithBLOBs record);

    List<SysAuditRecordWithBLOBs> selectByExampleWithBLOBs(SysAuditRecordExample example);

    List<SysAuditRecord> selectByExample(SysAuditRecordExample example);

    SysAuditRecordWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysAuditRecordWithBLOBs record, @Param("example") SysAuditRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") SysAuditRecordWithBLOBs record, @Param("example") SysAuditRecordExample example);

    int updateByExample(@Param("record") SysAuditRecord record, @Param("example") SysAuditRecordExample example);

    int updateByPrimaryKeySelective(SysAuditRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysAuditRecordWithBLOBs record);

    int updateByPrimaryKey(SysAuditRecord record);
}