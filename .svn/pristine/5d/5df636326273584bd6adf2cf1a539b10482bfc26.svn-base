package com.huaao.ejwplatform.api.dto.criminal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class DtoCreateCriminalRequest extends DtoPublicRequest{
 
	@ApiDescription("犯罪证明ID，不为空时为更新")
	@ApiDemoData(DemoData.ID)
    private String criminalId;
	
	@ApiDescription("身份证号码")
	@ApiDemoData(DemoData.ID_CARD)
	@NotBlank(message="请填写身份证号码")
    private String idcardNo;

	@ApiDescription("姓名")
	@ApiDemoData(DemoData.NAME)
	@NotBlank(message="请填写姓名")
    private String name;

	@ApiDescription("单位名称")
	@ApiDemoData("单位名称")
	@NotBlank(message="请填写要求出具证明单位")
    private String unitName;

	@ApiDescription("证明用途")
	@ApiDemoData("证明用途")
	@NotBlank(message="请填写用途")
    private String target;
 
	
	@ApiDescription("用户电话")
	@ApiDemoData("")
	@NotBlank(message="请填写手机号")
    private String userPhone;
 

	@ApiDescription("现居地")
	@ApiDemoData("")
	@NotBlank(message="请填写现住址")
    private String address;
 

	@ApiDescription("户籍地")
	@ApiDemoData("")
	@NotBlank(message="请填写户籍地址")
    private String resAddress;

	@ApiDescription("身份证正面照片地址")
	@ApiDemoData("")
    private String idcardImg1;

	@ApiDescription("身份证反面照片地址")
	@ApiDemoData("")
    private String idcardImg2;

	@ApiDescription("公函照片地址")
	@ApiDemoData("")
	@NotBlank(message="请上传公函")
    private String attachment;

	@ApiDescription("受理单位ID")
	@ApiDemoData("")
	@NotBlank(message="请选择办理单位")
    private String deptId;

	@ApiDescription("类型 0 自己 1 代办")
	@ApiDemoData("")
	@NotNull(message="类型不能为空")
    private Integer type;

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getIdcardImg1() {
		return idcardImg1;
	}

	public void setIdcardImg1(String idcardImg1) {
		this.idcardImg1 = idcardImg1;
	}

	public String getIdcardImg2() {
		return idcardImg2;
	}

	public void setIdcardImg2(String idcardImg2) {
		this.idcardImg2 = idcardImg2;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(String criminalId) {
		this.criminalId = criminalId;
	}
 
 
}
