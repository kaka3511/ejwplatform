package com.huaao.ejwplatform.service.model;


import java.text.SimpleDateFormat;
import java.util.List;

import com.huaao.ejwplatform.dao.JwAlert;
import com.huaao.ejwplatform.dao.SysAuditRecordWithBLOBs;
import com.huaao.ejwplatform.dao.SysUser;

public final class AlertInfoHelper {

	public static AlertInfo convertCitizenAlert(JwAlert alert, List<AlertRecord> records,SysUser fui) {
		return convert(alert, records,fui);
	}
	
	public static AlertRecord convertRecord(SysAuditRecordWithBLOBs record,SysUser sui,String creatorId) {
		AlertRecord re=new AlertRecord();
		re.setUserId(record.getUserId());
		re.setUserName(sui.getPhone());
		re.setUserImg(sui.getImg());
		
		if (record.getCurStatus().intValue() == CommonDict.AUDIT_STATUS_ALERT_UNCHECK) {
			re.setTitle("报警");
		} else if (record.getCurStatus().intValue() == CommonDict.AUDIT_STATUS_ALERT_SOLVED
				|| record.getStatus().intValue() == CommonDict.AUDIT_STATUS_ALERT_APPRAISE) {
			re.setTitle("解除警情");
		} else if (record.getCurStatus().intValue() == CommonDict.AUDIT_STATUS_ALERT_HANDOVER) {
			re.setTitle("移交警情");
		} else if (record.getCurStatus().intValue() == CommonDict.AUDIT_STATUS_ALERT_DELEGATE) {
			re.setTitle("委派警情");
		}
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String str=sdf.format(record.getAuditTime()); 
		re.setCreateTime(str);
		re.setDescription(record.getRemark());
		re.setImgs(record.getResultImgs());
		re.setVoices(record.getResultVoices());
		re.setVideos(record.getResultVideos());
		re.setVideosTime(record.getResultVoices());
		re.setVideosTime(record.getResultVideos());
		re.setRealname(sui.getRealname());
		return re;
	}
	
	public static AlertInfo convert(JwAlert alert,List<AlertRecord> records,SysUser fui) {
		AlertInfo alertInfo = new AlertInfo();
		alertInfo.setAlertId(alert.getId());
		alertInfo.setLocation(alert.getLocation());
		alertInfo.setType(alert.getType());
	    alertInfo.setStatus(alert.getStatus()); 
	    alertInfo.setAlertUserId(alert.getCreatorId());
		return alertInfo;
		
	}
}
