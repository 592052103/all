package com.sjl.health.entity;


public class BFlowPointFields {
    private Integer id;

    private String clinicIndex;

    private String flowNo;

    private String flowPointId;

    private String seq;

    private String fieldName;

    private String isSearchField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getFlowPointId() {
        return flowPointId;
    }

    public void setFlowPointId(String flowPointId) {
        this.flowPointId = flowPointId == null ? null : flowPointId.trim();
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getIsSearchField() {
        return isSearchField;
    }

    public void setIsSearchField(String isSearchField) {
        this.isSearchField = isSearchField == null ? null : isSearchField.trim();
    }
}