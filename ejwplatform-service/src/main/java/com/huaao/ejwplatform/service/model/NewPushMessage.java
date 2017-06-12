package com.huaao.ejwplatform.service.model;

import java.util.List;

public class NewPushMessage {

	private String title;
	
	private String text;
	
	private PushMessage message;
	
	private List<String> uids;
	//msg_id
	private String id;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PushMessage getMessage() {
		return message;
	}

	public void setMessage(PushMessage message) {
		this.message = message;
	}

	public List<String> getUids() {
		return uids;
	}

	public void setUids(List<String> uids) {
		this.uids = uids;
	}
}
