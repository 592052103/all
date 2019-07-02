package com.sjl.health.entity;

import java.util.Date;

public class BFlowPoint {
    private Long id;

    private String clinicIndex;

    private String flowNo;

    private Short flowPointId;

    private Short flowPointSeq;

    private String flowPointName;

    private String flowPointType;

    private Short interfaceType;

    private String interfaceIndex;

    private Short isFlowFinish;

    private Short flag;

    private String modifyUserId;

    private Date modifyTime;

    private String createUserId;

    private Date createTime;
    
    private BFlowPointRole bFlowPointRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClinicIndex() {
        return clinicIndex;
    }

    public void setClinicIndex(String clinicIndex) {
        this.clinicIndex = clinicIndex == null ? null : clinicIndex.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public Short getFlowPointId() {
        return flowPointId;
    }

    public void setFlowPointId(Short flowPointId) {
        this.flowPointId = flowPointId;
    }

    public Short getFlowPointSeq() {
        return flowPointSeq;
    }

    public void setFlowPointSeq(Short flowPointSeq) {
        this.flowPointSeq = flowPointSeq;
    }

    public String getFlowPointName() {
        return flowPointName;
    }

    public void setFlowPointName(String flowPointName) {
        this.flowPointName = flowPointName == null ? null : flowPointName.trim();
    }

    public String getFlowPointType() {
        return flowPointType;
    }

    public void setFlowPointType(String flowPointType) {
        this.flowPointType = flowPointType == null ? null : flowPointType.trim();
    }

    public Short getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Short interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceIndex() {
        return interfaceIndex;
    }

    public void setInterfaceIndex(String interfaceIndex) {
        this.interfaceIndex = interfaceIndex == null ? null : interfaceIndex.trim();
    }

    public Short getIsFlowFinish() {
        return isFlowFinish;
    }

    public void setIsFlowFinish(Short isFlowFinish) {
        this.isFlowFinish = isFlowFinish;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public BFlowPointRole getbFlowPointRole() {
		return bFlowPointRole;
	}

	public void setbFlowPointRole(BFlowPointRole bFlowPointRole) {
		this.bFlowPointRole = bFlowPointRole;
	}
    
}