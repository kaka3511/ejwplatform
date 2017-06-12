package com.huaao.ejwplatform.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.huaao.ejwplatform.dao.SysMessage;
import com.huaao.ejwplatform.dao.SysMessageExample;
import com.huaao.ejwplatform.dao.SysMessageExampleExt;
import com.huaao.ejwplatform.dao.SysMessageExt;

public interface SysMessageMapper {
    int countByExample(SysMessageExample example);
    
    
    int deleteByExample(SysMessageExample example);


    int deleteByPrimaryKey(String id);

   
    int insert(SysMessage record);

    
    int insertSelective(SysMessage record);

   
    List<SysMessage> selectByExample(SysMessageExample example);

    
    SysMessage selectByPrimaryKey(String id);

   
    int updateByExampleSelective(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

   
    int updateByExample(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

  
    int updateByPrimaryKeySelective(SysMessage record);

   
    int updateByPrimaryKey(SysMessage record);
    
    int countByExampleExt(SysMessageExampleExt example);
    
    List<SysMessageExt> selectPageByExample(SysMessageExampleExt example);
    
    //根据消息id查询
    List<SysMessageExt> selectByMessIds(@Param("list") List<String> ids);
}