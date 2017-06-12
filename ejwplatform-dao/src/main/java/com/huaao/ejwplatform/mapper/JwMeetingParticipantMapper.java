package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwMeetingParticipant;
import com.huaao.ejwplatform.dao.JwMeetingParticipantExample;
import com.huaao.ejwplatform.dao.JwMeetingParticipantKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwMeetingParticipantMapper {
    int countByExample(JwMeetingParticipantExample example);

    int deleteByExample(JwMeetingParticipantExample example);

    int deleteByPrimaryKey(JwMeetingParticipantKey key);

    int insert(JwMeetingParticipant record);

    int insertSelective(JwMeetingParticipant record);

    List<JwMeetingParticipant> selectByExample(JwMeetingParticipantExample example);

    JwMeetingParticipant selectByPrimaryKey(JwMeetingParticipantKey key);

    int updateByExampleSelective(@Param("record") JwMeetingParticipant record, @Param("example") JwMeetingParticipantExample example);

    int updateByExample(@Param("record") JwMeetingParticipant record, @Param("example") JwMeetingParticipantExample example);

    int updateByPrimaryKeySelective(JwMeetingParticipant record);

    int updateByPrimaryKey(JwMeetingParticipant record);
}