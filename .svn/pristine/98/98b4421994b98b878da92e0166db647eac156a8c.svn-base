package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwContentDept;
import com.huaao.ejwplatform.dao.JwContentDeptExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JwContentDeptMapper {
    int countByExample(JwContentDeptExample example);

    int deleteByExample(JwContentDeptExample example);

    int deleteByPrimaryKey(String id);

    int insert(JwContentDept record);

    int insertSelective(JwContentDept record);

    List<JwContentDept> selectByExample(JwContentDeptExample example);

    JwContentDept selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JwContentDept record, @Param("example") JwContentDeptExample example);

    int updateByExample(@Param("record") JwContentDept record, @Param("example") JwContentDeptExample example);

    int updateByPrimaryKeySelective(JwContentDept record);

    int updateByPrimaryKey(JwContentDept record);
    
    List<JwContentDept> getDeptsByContentId(Map<String, Object> params);
}