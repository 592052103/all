package com.sjl.health.entity;

import java.util.Date;

public class THealthDataDefine {
    private Long defineId;

    private Short fieldSeq;

    private String fieldName;

    private String classfyId;

    private String fieldDesc;

    private String fieldType;

    private String specialType;

    private Short fieldLenth;

    private Short fieldDec;

    private String defultValue;

    private String codeType;

    private String relatedField;

    private String parentField;

    private Short flag;

    private String modifyUserId;

    private Date modifyTime;

    private String createUserId;

    private Date createTime;

    public Long getDefineId() {
        return defineId;
    }

    public void setDefineId(Long defineId) {
        this.defineId = defineId;
    }

    public Short getFieldSeq() {
        return fieldSeq;
    }

    public void setFieldSeq(Short fieldSeq) {
        this.fieldSeq = fieldSeq;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getClassfyId() {
        return classfyId;
    }

    public void setClassfyId(String classfyId) {
        this.classfyId = classfyId == null ? null : classfyId.trim();
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc == null ? null : fieldDesc.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType == null ? null : specialType.trim();
    }

    public Short getFieldLenth() {
        return fieldLenth;
    }

    public void setFieldLenth(Short fieldLenth) {
        this.fieldLenth = fieldLenth;
    }

    public Short getFieldDec() {
        return fieldDec;
    }

    public void setFieldDec(Short fieldDec) {
        this.fieldDec = fieldDec;
    }

    public String getDefultValue() {
        return defultValue;
    }

    public void setDefultValue(String defultValue) {
        this.defultValue = defultValue == null ? null : defultValue.trim();
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    public String getRelatedField() {
        return relatedField;
    }

    public void setRelatedField(String relatedField) {
        this.relatedField = relatedField == null ? null : relatedField.trim();
    }

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField == null ? null : parentField.trim();
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
}