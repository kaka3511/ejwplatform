package com.huaao.ejwplatform.api.dto.alert;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoPoliceInputRequest extends DtoPublicRequest{
	 
	@ApiDescription("报警人电话")
	@ApiDemoData(DemoData.CELL_PHONE)
	@NotBlank
	@Length(min=11,max = 15, message="手机号格式不正确")
	private String phone;
	
	@ApiDescription("报警人姓名")
	@ApiDemoData(DemoData.NAME)
	@NotBlank
	private String name;

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

	@ApiDescription("报警时间,2017-04-26 17:18:00")
	private String alertTime;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(String alertTime) {
		this.alertTime = alertTime;
	}
	
	
	
}
