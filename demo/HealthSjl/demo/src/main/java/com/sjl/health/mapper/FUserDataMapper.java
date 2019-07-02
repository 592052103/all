package com.sjl.health.mapper;

import java.util.List;

import com.sjl.health.entity.FUserData;
import com.sjl.health.entity.THealthDataDefine;

public interface FUserDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FUserData record);

    int insertSelective(FUserData record);

    FUserData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FUserData record);

    int updateByPrimaryKey(FUserData record);
    
    List<FUserData> getFlowPointFieldsValue(List<THealthDataDefine> THealthDataDefineList);
}