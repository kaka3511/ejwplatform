package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwAppVersion;
import com.huaao.ejwplatform.dao.JwAppVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwAppVersionMapper {
    int countByExample(JwAppVersionExample example);

    int deleteByExample(JwAppVersionExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwAppVersion record);

    int insertSelective(JwAppVersion record);

    List<JwAppVersion> selectByExample(JwAppVersionExample example);

    JwAppVersion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwAppVersion record, @Param("example") JwAppVersionExample example);

    int updateByExample(@Param("record") JwAppVersion record, @Param("example") JwAppVersionExample example);

    int updateByPrimaryKeySelective(JwAppVersion record);

    int updateByPrimaryKey(JwAppVersion record);

	JwAppVersion queryLatestVersoin(JwAppVersionExample example);
}