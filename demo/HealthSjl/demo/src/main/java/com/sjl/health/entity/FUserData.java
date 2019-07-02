package com.sjl.health.entity;

import java.util.Date;

public class FUserData {
    private Integer id;

    private String userId;

    private String clinicIndex;

    private String userType;

    private String userLogin;

    private String userFdsPassportNum;

    private String flowNo;

    private Long flowBatchId;

    private Integer flowPointId;

    private Short servicePointId;

    private String fieldName;

    private String fieldValue;

    private Date recordTime;

    private Integer status;

    private String modifyUserId;

    private Date modifyTime;

    private Integer createUserId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getClinicIndex() {
        return clinicIndex;
    }

    public void setClinicIndex(String clinicIndex) {
        this.clinicIndex = clinicIndex == null ? null : clinicIndex.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin == null ? null : userLogin.trim();
    }

    public String getUserFdsPassportNum() {
        return userFdsPassportNum;
    }

    public void setUserFdsPassportNum(String userFdsPassportNum) {
        this.userFdsPassportNum = userFdsPassportNum == null ? null : userFdsPassportNum.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public Long getFlowBatchId() {
        return flowBatchId;
    }

    public void setFlowBatchId(Long flowBatchId) {
        this.flowBatchId = flowBatchId;
    }

    public Integer getFlowPointId() {
        return flowPointId;
    }

    public void setFlowPointId(Integer flowPointId) {
        this.flowPointId = flowPointId;
    }

    public Short getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(Short servicePointId) {
        this.servicePointId = servicePointId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue == null ? null : fieldValue.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}