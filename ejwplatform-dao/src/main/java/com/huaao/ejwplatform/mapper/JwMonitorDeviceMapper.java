package com.huaao.ejwplatform.mapper;

import com.huaao.ejwplatform.dao.JwMonitorDevice;
import com.huaao.ejwplatform.dao.JwMonitorDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JwMonitorDeviceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int countByExample(JwMonitorDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int deleteByExample(JwMonitorDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int insert(JwMonitorDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int insertSelective(JwMonitorDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    List<JwMonitorDevice> selectByExample(JwMonitorDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    JwMonitorDevice selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int updateByExampleSelective(@Param("record") JwMonitorDevice record, @Param("example") JwMonitorDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int updateByExample(@Param("record") JwMonitorDevice record, @Param("example") JwMonitorDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int updateByPrimaryKeySelective(JwMonitorDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jw_monitor_device
     *
     * @mbggenerated Tue May 09 15:46:01 CST 2017
     */
    int updateByPrimaryKey(JwMonitorDevice record);
}