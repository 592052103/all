package com.sjl.health.entity;

import java.util.Date;

public class BClinic {
	
    private Integer clinicId;

    private String clinicIndex;

    private String clinicName;

    private String systemName;

    private String country;

    private String province;

    private String city;

    private String district;

    private String clinicAddress;

    private Integer status;

    private String clinicTel;

    private String clinicHead;

    private String clinicHeadMobile;

    private String clinicContact;

    private String clinicContactMobile;

    private String clinicParentId;

    private Integer energyMoney;

    private String superAdminId;

    private String modifyUserId;

    private Date modifyTime;

    private String createUserId;

    private Date createTime;

    private String note;

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicIndex() {
        return clinicIndex;
    }

    public void setClinicIndex(String clinicIndex) {
        this.clinicIndex = clinicIndex == null ? null : clinicIndex.trim();
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName == null ? null : clinicName.trim();
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress == null ? null : clinicAddress.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClinicTel() {
        return clinicTel;
    }

    public void setClinicTel(String clinicTel) {
        this.clinicTel = clinicTel == null ? null : clinicTel.trim();
    }

    public String getClinicHead() {
        return clinicHead;
    }

    public void setClinicHead(String clinicHead) {
        this.clinicHead = clinicHead == null ? null : clinicHead.trim();
    }

    public String getClinicHeadMobile() {
        return clinicHeadMobile;
    }

    public void setClinicHeadMobile(String clinicHeadMobile) {
        this.clinicHeadMobile = clinicHeadMobile == null ? null : clinicHeadMobile.trim();
    }

    public String getClinicContact() {
        return clinicContact;
    }

    public void setClinicContact(String clinicContact) {
        this.clinicContact = clinicContact == null ? null : clinicContact.trim();
    }

    public String getClinicContactMobile() {
        return clinicContactMobile;
    }

    public void setClinicContactMobile(String clinicContactMobile) {
        this.clinicContactMobile = clinicContactMobile == null ? null : clinicContactMobile.trim();
    }

    public String getClinicParentId() {
        return clinicParentId;
    }

    public void setClinicParentId(String clinicParentId) {
        this.clinicParentId = clinicParentId == null ? null : clinicParentId.trim();
    }

    public Integer getEnergyMoney() {
        return energyMoney;
    }

    public void setEnergyMoney(Integer energyMoney) {
        this.energyMoney = energyMoney;
    }

    public String getSuperAdminId() {
        return superAdminId;
    }

    public void setSuperAdminId(String superAdminId) {
        this.superAdminId = superAdminId == null ? null : superAdminId.trim();
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
}