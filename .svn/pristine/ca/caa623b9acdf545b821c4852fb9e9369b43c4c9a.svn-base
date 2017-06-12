package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwMeetingRoom;
import com.huaao.ejwplatform.dao.JwMeetingRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwMeetingRoomMapper {
    int countByExample(JwMeetingRoomExample example);

    int deleteByExample(JwMeetingRoomExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwMeetingRoom record);

    int insertSelective(JwMeetingRoom record);

    List<JwMeetingRoom> selectByExample(JwMeetingRoomExample example);

    JwMeetingRoom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwMeetingRoom record, @Param("example") JwMeetingRoomExample example);

    int updateByExample(@Param("record") JwMeetingRoom record, @Param("example") JwMeetingRoomExample example);

    int updateByPrimaryKeySelective(JwMeetingRoom record);

    int updateByPrimaryKey(JwMeetingRoom record);
}