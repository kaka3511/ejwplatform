package com.huaao.ejwplatform.dao;

public class SysApplyRecordExt extends SysApplyRecord {
    private String realname;

	private String img;

    public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	private static final long serialVersionUID = 1L;
}