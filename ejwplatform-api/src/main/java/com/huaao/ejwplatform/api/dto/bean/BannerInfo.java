package com.huaao.ejwplatform.api.dto.bean;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class BannerInfo {

	@ApiDescription("")
	@ApiDemoData(DemoData.ID)
	private String id;
	
	@ApiDescription("图片")
	@ApiDemoData(DemoData.IMAGE)
	private String imgs;
	
	@ApiDescription("")
	@ApiDemoData(DemoData.LINK)
	private String link;
	
	@ApiDescription("标题")
	@ApiDemoData("XXX")
	private String title;
	
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

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
