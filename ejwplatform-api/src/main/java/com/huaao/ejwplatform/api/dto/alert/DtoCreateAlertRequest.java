package com.huaao.ejwplatform.api.dto.alert;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

@ApiDescription("警情添加接口请求参数")
public class DtoCreateAlertRequest extends DtoPublicRequest{
	
	@ApiDescription("警情ID")
	@ApiDemoData("03fc86e759c64b029563da4037989df7")
	private String alertId;

	@ApiDescription("报警内容")
	@ApiDemoData("华中科技大学发生一起自行车被盗事件...")
	private String description;

	@ApiDescription("图片,多个以逗号分隔")
	@ApiDemoData("/upload/images/x.png,/upload/images/x.png")
	private String imgs;//多个以逗号分隔

	@ApiDescription("语音")
	@ApiDemoData("/upload/voices/x.amr,/upload/voices/x.amr")
	private String voices;//多个以逗号分隔

	@ApiDescription("视频")
	@ApiDemoData("/upload/voices/x.3gp,/upload/voices/x.3gp")
	private String videos;//多个以逗号分隔

	@ApiDescription("报警类型1-一键报警2-随手记3-举报")
	@ApiDemoData("1")
	private Integer type; //1-一键报警 ,2-随手记 ,3-举报

	@ApiDescription("报警地址")
	@ApiDemoData("湖北省武汉市洪山区珞瑜东路1037号华中科技大学")
	private String address; //报警地址

	@ApiDescription("经纬度")
	@ApiDemoData("30.739108,120.804508")
	private String location; //经纬度

	@ApiDescription("语音录入时间长度(单位秒)")
	@ApiDemoData("120,30")
	private String voicesTime ;

	@ApiDescription("视频录入时间长度(单位秒)")
	@ApiDemoData("120,30")
	private String videosTime ;
	
	@ApiDescription("是否保存，1 是  ， 其他 否")
	@ApiDemoData("1")
	private Integer saveFlag;
	
	@ApiDescription("报警类型分类 : 群众求助1 ,举报线索2 ,投诉监督3 ,治安事件4 ,交通事件5 ,抢险救援6 ,刑事案件7")
	@ApiDemoData("1")
	private Integer classify;  
	
	
	public String getVoicesTime() {
		return voicesTime;
	}

	public void setVoicesTime(String voicesTime) {
		this.voicesTime = voicesTime;
	}

	public String getVideosTime() {
		return videosTime;
	}

	public void setVideosTime(String videosTime) {
		this.videosTime = videosTime;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getVoices() {
		return voices;
	}

	public void setVoices(String voices) {
		this.voices = voices;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(Integer saveFlag) {
		this.saveFlag = saveFlag;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

 
	
}
