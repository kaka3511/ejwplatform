package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwEmsPayResult;
import com.huaao.ejwplatform.dao.JwEmsPayResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwEmsPayResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int countByExample(JwEmsPayResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int deleteByExample(JwEmsPayResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int insert(JwEmsPayResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int insertSelective(JwEmsPayResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    List<JwEmsPayResult> selectByExample(JwEmsPayResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    JwEmsPayResult selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int updateByExampleSelective(@Param("record") JwEmsPayResult record, @Param("example") JwEmsPayResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int updateByExample(@Param("record") JwEmsPayResult record, @Param("example") JwEmsPayResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int updateByPrimaryKeySelective(JwEmsPayResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_ems_pay_result
     *
     * @mbggenerated Wed Apr 19 16:37:59 CST 2017
     */
    int updateByPrimaryKey(JwEmsPayResult record);
}