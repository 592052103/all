package com.sjl.health.entity;


import java.io.Serializable;
import java.util.Date;

public class Personnel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6056480111990461178L;

	private String personnelId;

    private String clinicId;

    private Integer departmentId;

    private Integer roleId;

    private Integer personnelIndex;

    private String superior;

    private String personnelName;

    private String loginName;

    private String loginPasswd;

    private String email;

    private String personnelMobile;

    private Date birthDate;

    private Integer gender;

    private Integer educationBackgroundId;

    private String graduationSchool;

    private Double workYear;

    private Integer jobsId;

    private Integer nationalId;

    private Integer status;

    private String modifyUserId;

    private Date modifyTime;

    private String createUserId;

    private Date createTime;

    private String note;
    
    private BClinic bclinic;

    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId == null ? null : personnelId.trim();
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId == null ? null : clinicId.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPersonnelIndex() {
        return personnelIndex;
    }

    public void setPersonnelIndex(Integer personnelIndex) {
        this.personnelIndex = personnelIndex;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior == null ? null : superior.trim();
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getEducationBackgroundId() {
        return educationBackgroundId;
    }

    public void setEducationBackgroundId(Integer educationBackgroundId) {
        this.educationBackgroundId = educationBackgroundId;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool == null ? null : graduationSchool.trim();
    }

    public Double getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Double workYear) {
        this.workYear = workYear;
    }

    public Integer getJobsId() {
        return jobsId;
    }

    public void setJobsId(Integer jobsId) {
        this.jobsId = jobsId;
    }

    public Integer getNationalId() {
        return nationalId;
    }

    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
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

	public BClinic getBclinic() {
		return bclinic;
	}

	public void setBclinic(BClinic bclinic) {
		this.bclinic = bclinic;
	}
    
}