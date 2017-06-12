package com.huaao.ejwplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaao.ejwplatform.dao.JwLearnRecord;
import com.huaao.ejwplatform.dao.JwLearnRecordExample;
import com.huaao.ejwplatform.dao.JwLearnRecordExampleExt;
import com.huaao.ejwplatform.dao.JwLearnRecordExt;

public interface JwLearnRecordMapper {
    int countByExample(JwLearnRecordExample example);

    int deleteByExample(JwLearnRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwLearnRecord record);

    int insertSelective(JwLearnRecord record);

    List<JwLearnRecord> selectByExample(JwLearnRecordExample example);

    JwLearnRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwLearnRecord record, @Param("example") JwLearnRecordExample example);

    int updateByExample(@Param("record") JwLearnRecord record, @Param("example") JwLearnRecordExample example);

    int updateByPrimaryKeySelective(JwLearnRecord record);

    int updateByPrimaryKey(JwLearnRecord record);

	List<JwLearnRecordExt> selectExtByExample(JwLearnRecordExample recordExample);

	List<JwLearnRecordExt> selectReadUserList(JwLearnRecordExampleExt recordExample);
}