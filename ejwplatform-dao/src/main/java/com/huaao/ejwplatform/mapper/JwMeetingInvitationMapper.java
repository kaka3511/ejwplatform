package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwMeetingInvitation;
import com.huaao.ejwplatform.dao.JwMeetingInvitationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwMeetingInvitationMapper {
    int countByExample(JwMeetingInvitationExample example);

    int deleteByExample(JwMeetingInvitationExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwMeetingInvitation record);

    int insertSelective(JwMeetingInvitation record);

    List<JwMeetingInvitation> selectByExample(JwMeetingInvitationExample example);

    JwMeetingInvitation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwMeetingInvitation record, @Param("example") JwMeetingInvitationExample example);

    int updateByExample(@Param("record") JwMeetingInvitation record, @Param("example") JwMeetingInvitationExample example);

    int updateByPrimaryKeySelective(JwMeetingInvitation record);

    int updateByPrimaryKey(JwMeetingInvitation record);
}