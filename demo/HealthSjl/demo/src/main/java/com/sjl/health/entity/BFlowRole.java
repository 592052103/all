package com.sjl.health.entity;

import java.util.List;

public class BFlowRole {
    private Long id;

    private String clinicIndex;

    private String flowNo;

    private Integer roleIndex;
    
    private List<BFlow> bFlowList;

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

    public Integer getRoleIndex() {
        return roleIndex;
    }

    public void setRoleIndex(Integer roleIndex) {
        this.roleIndex = roleIndex;
    }

	public List<BFlow> getbFlowList() {
		return bFlowList;
	}

	public void setbFlowList(List<BFlow> bFlowList) {
		this.bFlowList = bFlowList;
	}
}