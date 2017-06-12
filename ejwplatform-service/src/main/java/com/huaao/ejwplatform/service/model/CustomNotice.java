package com.huaao.ejwplatform.service.model;

import java.util.Date;

public class CustomNotice extends AbstractJsonModel{

	private static final long serialVersionUID = -889436118126441477L;
   
    public String id;
    public String title;
    public Date updateTime;
    public Integer infoType;
    public String link;
    public String updaterDeptName;
    
    public CustomNotice(String id, String title, Date updateTime,int infoType, String link,String updaterDeptName){
		this.id = id;
		this.title = title;
		this.updateTime = updateTime;
		this.infoType = infoType;
		this.link = link;
		this.updaterDeptName = updaterDeptName;
	}
}
