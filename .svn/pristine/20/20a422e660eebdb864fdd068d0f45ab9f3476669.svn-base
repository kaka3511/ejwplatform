package com.huaao.ejwplatform.api.dto.bean;

import java.io.Serializable;
import java.util.Date;

import com.huaao.ejwplatform.common.DemoData;
import com.huaao.ejwplatform.common.web.ApiDemoData;
import com.huaao.ejwplatform.common.web.ApiDescription;

public class ApplyRecordInfo implements Serializable {
	@ApiDescription("ID")
	@ApiDemoData(DemoData.ID)
    private String id;

	@ApiDescription("类型,1无犯罪记录证明")
	@ApiDemoData("1")
    private Integer type;

	@ApiDescription("无犯罪记录申请工单ID")
	@ApiDemoData(DemoData.ID)
    private String recordId;

	@ApiDescription("无犯罪记录申请人ID")
	@ApiDemoData(DemoData.ID)
    private String userId;
	
	@ApiDescription("无犯罪记录申请人姓名")
	@ApiDemoData(DemoData.NAME)
	private String realname;

	@ApiDescription("无犯罪记录申请人头像")
	@ApiDemoData(DemoData.IMAGE)
	private String img;
	
	@ApiDescription("描述")
	@ApiDemoData("已审核")
    private String desc;

	@ApiDescription("操作时间")
	@ApiDemoData(DemoData.STMAP)
    private Date createTime;

	@ApiDescription("审批状态")
	@ApiDemoData("1")
	private Integer status;
	
	@ApiDescription("审批意见")
	@ApiDemoData("审批通过")
	private String remark;
	
	@ApiDescription("处理速度")
	@ApiDemoData("5")
	private Integer turningSpeed;  
	
	@ApiDescription("处理效率")
	@ApiDemoData("5")
	private Integer processingEfficiency;
	
	@ApiDescription("反馈结果")
	@ApiDemoData("5")
	private Integer feedbackResult;
	
	@ApiDescription("总评价 1 好评，2 中评 ， 3 差评")
	@ApiDemoData("1")
	private Integer rate;
 
	
	private static final long serialVersionUID = 1L;

	public Integer getTurningSpeed() {
		return turningSpeed;
	}

	public void setTurningSpeed(Integer turningSpeed) {
		this.turningSpeed = turningSpeed;
	}

	public Integer getProcessingEfficiency() {
		return processingEfficiency;
	}

	public void setProcessingEfficiency(Integer processingEfficiency) {
		this.processingEfficiency = processingEfficiency;
	}

	public Integer getFeedbackResult() {
		return feedbackResult;
	}

	public void setFeedbackResult(Integer feedbackResult) {
		this.feedbackResult = feedbackResult;
	}
    
	

    public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

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

	public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}