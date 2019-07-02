package com.sjl.health.entity;

import java.util.Date;
import java.util.List;

public class BPersonal {
    private String personnelId;

    private String clinicIndex;

    private String personnelIndex;

    private Integer departmentIndex;

    private Integer roleIndex;

    private String superiorIndex;

    private String personnelName;

    private String loginName;

    private String loginPasswd;

    private String email;

    private String personnelMobile;

    private Date birthDate;

    private String gender;

    private String educationBackgroundId;

    private String graduationSchool;

    private Short workYear;

    private Integer status;

    private String modifyUserId;

    private Date modifyTime;

    private String createUserId;

    private Date createTime;

    private String note;
    
    private BClinic bClinic;
    
    private List<BFlowRole> bFlowRoleList;  


    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId == null ? null : personnelId.trim();
    }

    public String getClinicIndex() {
        return clinicIndex;
    }

    public void setClinicIndex(String clinicIndex) {
        this.clinicIndex = clinicIndex == null ? null : clinicIndex.trim();
    }

    public String getPersonnelIndex() {
        return personnelIndex;
    }

    public void setPersonnelIndex(String personnelIndex) {
        this.personnelIndex = personnelIndex == null ? null : personnelIndex.trim();
    }

    public Integer getDepartmentIndex() {
        return departmentIndex;
    }

    public void setDepartmentIndex(Integer departmentIndex) {
        this.departmentIndex = departmentIndex;
    }

    public Integer getRoleIndex() {
        return roleIndex;
    }

    public void setRoleIndex(Integer roleIndex) {
        this.roleIndex = roleIndex;
    }

    public String getSuperiorIndex() {
        return superiorIndex;
    }

    public void setSuperiorIndex(String superiorIndex) {
        this.superiorIndex = superiorIndex == null ? null : superiorIndex.trim();
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName == null ? null : personnelName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPasswd() {
        return loginPasswd;
    }

    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd == null ? null : loginPasswd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPersonnelMobile() {
        return personnelMobile;
    }

    public void setPersonnelMobile(String personnelMobile) {
        this.personnelMobile = personnelMobile == null ? null : personnelMobile.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEducationBackgroundId() {
        return educationBackgroundId;
    }

    public void setEducationBackgroundId(String educationBackgroundId) {
        this.educationBackgroundId = educationBackgroundId == null ? null : educationBackgroundId.trim();
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool == null ? null : graduationSchool.trim();
    }

    public Short getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Short workYear) {
        this.workYear = workYear;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public BClinic getbClinic() {
		return bClinic;
	}

	public void setbClinic(BClinic bClinic) {
		this.bClinic = bClinic;
	}

	public List<BFlowRole> getbFlowRoleList() {
		return bFlowRoleList;
	}

	public void setbFlowRoleList(List<BFlowRole> bFlowRoleList) {
		this.bFlowRoleList = bFlowRoleList;
	}
	
}