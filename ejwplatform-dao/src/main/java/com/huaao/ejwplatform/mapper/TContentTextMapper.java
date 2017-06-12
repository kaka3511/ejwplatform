package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.TContentText;
import com.huaao.ejwplatform.dao.TContentTextExample;
import com.huaao.ejwplatform.dao.TContentTextKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContentTextMapper {
    int countByExample(TContentTextExample example);

    int deleteByExample(TContentTextExample example);

    int deleteByPrimaryKey(TContentTextKey key);

    int insert(TContentText record);

    int insertSelective(TContentText record);

    List<TContentText> selectByExampleWithBLOBs(TContentTextExample example);

    List<TContentText> selectByExample(TContentTextExample example);

    TContentText selectByPrimaryKey(TContentTextKey key);

    int updateByExampleSelective(@Param("record") TContentText record, @Param("example") TContentTextExample example);

    int updateByExampleWithBLOBs(@Param("record") TContentText record, @Param("example") TContentTextExample example);

    int updateByExample(@Param("record") TContentText record, @Param("example") TContentTextExample example);

    int updateByPrimaryKeySelective(TContentText record);

    int updateByPrimaryKeyWithBLOBs(TContentText record);
}