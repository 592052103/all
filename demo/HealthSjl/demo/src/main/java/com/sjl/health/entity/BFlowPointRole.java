package com.sjl.health.entity;

public class BFlowPointRole {
    private Long id;

    private String clinicIndex;

    private String flowNo;

    private Integer flowPointId;

    private Integer roleIndex;

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

    public Integer getFlowPointId() {
        return flowPointId;
    }

    public void setFlowPointId(Integer flowPointId) {
        this.flowPointId = flowPointId;
    }

	public Integer getRoleIndex() {
		return roleIndex;
	}

	public void setRoleIndex(Integer roleIndex) {
		this.roleIndex = roleIndex;
	}
}