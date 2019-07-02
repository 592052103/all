package com.sjl.health.entity;


import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7453141136029203655L;

	private Integer departmentId;

    private String clinicId;

    private String departmentIndex;

    private String departmentName;

    private Integer status;

    private Integer sort;

    private Integer departmentParentId;

    private String modifyUserId;

    private String createUserId;

    private Date createTime;

    private String note;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId == null ? null : clinicId.trim();
    }

    public String getDepartmentIndex() {
        return departmentIndex;
    }

    public void setDepartmentIndex(String departmentIndex) {
        this.departmentIndex = departmentIndex;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDepartmentParentId() {
        return departmentParentId;
    }

    public void setDepartmentParentId(Integer departmentParentId) {
        this.departmentParentId = departmentParentId;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
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
}