package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwEmsInfo;
import com.huaao.ejwplatform.dao.JwEmsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwEmsInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int countByExample(JwEmsInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int deleteByExample(JwEmsInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int deleteByPrimaryKey(String recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int insert(JwEmsInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int insertSelective(JwEmsInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    List<JwEmsInfo> selectByExample(JwEmsInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    JwEmsInfo selectByPrimaryKey(String recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int updateByExampleSelective(@Param("record") JwEmsInfo record, @Param("example") JwEmsInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int updateByExample(@Param("record") JwEmsInfo record, @Param("example") JwEmsInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int updateByPrimaryKeySelective(JwEmsInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_info
     *
     * @mbggenerated Wed Mar 29 14:54:40 CST 2017
     */
    int updateByPrimaryKey(JwEmsInfo record);
}