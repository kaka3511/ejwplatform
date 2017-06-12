package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwQuestion;
import com.huaao.ejwplatform.dao.JwQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwQuestionMapper {
    int countByExample(JwQuestionExample example);

    int deleteByExample(JwQuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwQuestion record);

    int insertSelective(JwQuestion record);

    List<JwQuestion> selectByExample(JwQuestionExample example);

    JwQuestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwQuestion record, @Param("example") JwQuestionExample example);

    int updateByExample(@Param("record") JwQuestion record, @Param("example") JwQuestionExample example);

    int updateByPrimaryKeySelective(JwQuestion record);

    int updateByPrimaryKey(JwQuestion record);
}