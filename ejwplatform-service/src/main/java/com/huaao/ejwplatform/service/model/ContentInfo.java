package com.huaao.ejwplatform.service.model;

import java.util.Date;

public class ContentInfo extends AbstractJsonModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 18192831930123L;
	
	public String id;
	public String title;
	public String link;
	public long time;
	
	public ContentInfo(String id, String title, String link){
		this.id = id;
		this.title = title;
		this.link = link;
		this.time = (new Date()).getTime();
	}
	

	public ContentInfo(String id, String title, String link, long time){
		this.id = id;
		this.title = title;
		this.link = link;
		this.time = time;
	}

}
