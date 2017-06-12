package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwComment;
import com.huaao.ejwplatform.dao.JwCommentExample;
import com.huaao.ejwplatform.dao.JwCommentWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwCommentMapper {
    int countByExample(JwCommentExample example);

    int deleteByExample(JwCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwCommentWithBLOBs record);

    int insertSelective(JwCommentWithBLOBs record);

    List<JwCommentWithBLOBs> selectByExampleWithBLOBs(JwCommentExample example);

    List<JwComment> selectByExample(JwCommentExample example);

    JwCommentWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwCommentWithBLOBs record, @Param("example") JwCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") JwCommentWithBLOBs record, @Param("example") JwCommentExample example);

    int updateByExample(@Param("record") JwComment record, @Param("example") JwCommentExample example);

    int updateByPrimaryKeySelective(JwCommentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(JwCommentWithBLOBs record);

    int updateByPrimaryKey(JwComment record);
}