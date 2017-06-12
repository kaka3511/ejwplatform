package com.huaao.ejwplatform.api.dto.bean;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.huaao.ejwplatform.api.dto.criminal.DtoUserInfoForQueryCriminalResponse;
import com.huaao.ejwplatform.api.dto.ems.DtoQueryEmsInfoResponse;
import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class CriminalInfo {
	@ApiDescription("记录ID")
	@ApiDemoData(DemoData.ID)
	private String id;

	@ApiDescription("申请人ID")
	@ApiDemoData(DemoData.ID)
	private String userId;

	@ApiDescription("身份证号码")
	@ApiDemoData(DemoData.ID_CARD)
    private String idcardNo;

	@ApiDescription("姓名")
	@ApiDemoData(DemoData.NAME)
    private String name;

	@ApiDescription("单位名称")
	@ApiDemoData("单位名称")
    private String unitName;

	@ApiDescription("证明用途")
	@ApiDemoData("证明用途")
    private String target;

	@ApiDescription("创建时间")
	@ApiDemoData(DemoData.STMAP)
    private Date createTime;

	@ApiDescription("创建时间")
	@ApiDemoData(DemoData.TIME)
    private String createTimeStr;
	
	@ApiDescription("审核人ID")
	@ApiDemoData("")
    private String policeId;

	@ApiDescription("审核人姓名")
	@ApiDemoData("")
    private String policeName;

	@ApiDescription("审核人电话")
	@ApiDemoData("")
    private String policePhone;

	@ApiDescription("开据时间,点击自行领取或邮寄的时间")
	@ApiDemoData(DemoData.STMAP)
    private Date finishTime;

	@ApiDescription("开据时间,点击自行领取或邮寄的时间")
	@ApiDemoData(DemoData.TIME)
    private String finishTimeStr;
	
	@ApiDescription("用户电话")
	@ApiDemoData("")
    private String userPhone;

	@ApiDescription("打印状态 0 未打印 1 成功 2 失败")
	@ApiDemoData("")
    private Integer status;

	@ApiDescription("打印时间")
	@ApiDemoData("")
    private Date printTime;

	@ApiDescription("打印时间")
	@ApiDemoData("")
    private String printTimeStr;
	
	@ApiDescription("现居地")
	@ApiDemoData("")
    private String address;

	@ApiDescription("审核状态,见上面接口说明")
	@ApiDemoData("")
    private Integer authStatus;

	@ApiDescription("是否有犯罪记录 0 未知， 1 没有 ， 2 有")
	@ApiDemoData("")
    private Integer hasRecord;

	@ApiDescription("审核拒绝原因")
	@ApiDemoData("")
    private String authDesc;

	@ApiDescription("户籍地")
	@ApiDemoData("")
    private String resAddress;

	@ApiDescription("身份证正面照片地址")
	@ApiDemoData("")
    private String idcardImg1;

	@ApiDescription("身份证反面照片地址")
	@ApiDemoData("")
    private String idcardImg2;

	@ApiDescription("公函照片地址")
	@ApiDemoData("")
    private String attachment;

	@ApiDescription("受理单位ID")
	@ApiDemoData("")
    private String deptId;
	
	@ApiDescription("受理单位名称")
	@ApiDemoData("XX派出所")
    private String deptName;

	@ApiDescription("类型 0 自己 1 代办")
	@ApiDemoData("0")
    private Integer type;

	@ApiDescription("更新时间")
	@ApiDemoData("")
    private Date updateTime;

	@ApiDescription("更新时间")
	@ApiDemoData(DemoData.TIME)
    private String updateTimeStr;
	
	@ApiDescription("用户接受方式,默认0， 1 自取 2 EMS")
	@ApiDemoData("")
    private Integer recieveType;
	
	@ApiDescription("领取人身份证号")
	@ApiDemoData("")
	private String printIdcrad;

	@ApiDescription("EMS运单相关信息")
	private EmsBean ems;
	
	@ApiDescription("审核记录相关信息")
	private List<ApplyRecordInfo> applyRecords;
	
	@ApiDescription("申请人")
	@ApiDemoData("")
	private DtoUserInfoForQueryCriminalResponse user;
	
	@ApiDescription("快递签收时间")
	@ApiDemoData("")
	private Date emsRecieveTime;

	@ApiDescription("物流订单信息")
	@ApiDemoData("")
	private DtoQueryEmsInfoResponse emsInfo;

	@ApiDescription("二维码图片地址")
	@ApiDemoData("")	
	private String qrcode;

	@ApiDescription("失效时间")
	@ApiDemoData("")
	private Date invalidTime;
	
	@ApiDescription("失效剩余天数")
	@ApiDemoData("")
	private Integer invalidSurplusDays;
	
	@ApiDescription("审核时间")
	@ApiDemoData(DemoData.STMAP)
	private Date auditTime;
	
	@ApiDescription("审核时间")
	@ApiDemoData(DemoData.TIME)
    private String auditTimeStr;

	@ApiDescription("所属类别")
	@ApiDemoData("onlineService")
    private String category;

	
	public String getAuditTimeStr() {
		return auditTimeStr;
	}

	public void setAuditTimeStr(String auditTimeStr) {
		this.auditTimeStr = auditTimeStr;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
		this.auditTimeStr = DateTool.formatDateTime(auditTime);
	}

	public Integer getInvalidSurplusDays() {
		return invalidSurplusDays;
	}

	public void setInvalidSurplusDays(Integer invalidSurplusDays) {
		this.invalidSurplusDays = invalidSurplusDays;
	}

	public Date getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(Date invalidTime) {
		this.invalidTime = invalidTime;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public DtoQueryEmsInfoResponse getEmsInfo() {
		return emsInfo;
	}

	public void setEmsInfo(DtoQueryEmsInfoResponse emsInfo) {
		this.emsInfo = emsInfo;
	}

	public String getPrintIdcrad() {
		return printIdcrad;
	}

	public void setPrintIdcrad(String printIdcrad) {
		this.printIdcrad = printIdcrad;
	}

	public Date getEmsRecieveTime() {
		return emsRecieveTime;
	}

	public void setEmsRecieveTime(Date emsRecieveTime) {
		this.emsRecieveTime = emsRecieveTime;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public DtoUserInfoForQueryCriminalResponse getUser() {
		return user;
	}

	public void setUser(DtoUserInfoForQueryCriminalResponse user) {
		this.user = user;
	}

	public List<ApplyRecordInfo> getApplyRecords() {
		return applyRecords;
	}

	public void setApplyRecords(List<ApplyRecordInfo> applyRecords) {
		this.applyRecords = applyRecords;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		category="onlineService";
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		this.createTimeStr = DateTool.formatDateTime(createTime);
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getPoliceName() {
		return policeName;
	}

	public void setPoliceName(String policeName) {
		this.policeName = policeName;
	}

	public String getPolicePhone() {
		return policePhone;
	}

	public void setPolicePhone(String policePhone) {
		this.policePhone = policePhone;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
		this.finishTimeStr = DateTool.formatDateTime(finishTime);
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
		this.printTimeStr = DateTool.formatDateTime(printTime);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	public Integer getHasRecord() {
		return hasRecord;
	}

	public void setHasRecord(Integer hasRecord) {
		this.hasRecord = hasRecord;
	}

	public String getAuthDesc() {
		return authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		this.updateTimeStr = DateTool.formatDateTime(updateTime);
	}

	public Integer getRecieveType() {
		return recieveType;
	}

	public void setRecieveType(Integer recieveType) {
		this.recieveType = recieveType;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getFinishTimeStr() {
		return finishTimeStr;
	}

	public void setFinishTimeStr(String finishTimeStr) {
		this.finishTimeStr = finishTimeStr;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public EmsBean getEms() {
		return ems;
	}

	public void setEms(EmsBean ems) {
		this.ems = ems;
	}

	public String getPrintTimeStr() {
		return printTimeStr;
	}

	public void setPrintTimeStr(String printTimeStr) {
		this.printTimeStr = printTimeStr;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		
	}
    
}
