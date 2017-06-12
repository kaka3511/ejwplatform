package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.TNoticeUser;
import com.huaao.ejwplatform.dao.TNoticeUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TNoticeUserMapper {
    int countByExample(TNoticeUserExample example);

    int deleteByExample(TNoticeUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TNoticeUser record);

    int insertSelective(TNoticeUser record);

    List<TNoticeUser> selectByExample(TNoticeUserExample example);

    TNoticeUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TNoticeUser record, @Param("example") TNoticeUserExample example);

    int updateByExample(@Param("record") TNoticeUser record, @Param("example") TNoticeUserExample example);

    int updateByPrimaryKeySelective(TNoticeUser record);

    int updateByPrimaryKey(TNoticeUser record);
}