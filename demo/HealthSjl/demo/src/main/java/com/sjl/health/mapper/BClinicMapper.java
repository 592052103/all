package com.sjl.health.mapper;

import com.sjl.health.entity.BClinic;


public interface BClinicMapper {
    int deleteByPrimaryKey(Integer clinicId);

    int insert(BClinic record);

    int insertSelective(BClinic record);

    BClinic selectByPrimaryKey(Integer clinicId);

    int updateByPrimaryKeySelective(BClinic record);

    int updateByPrimaryKey(BClinic record);
}