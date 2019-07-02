package com.sjl.health.mapper;

import com.sjl.health.entity.BFlowPointFields;
import com.sjl.health.entity.THealthDataDefine;

public interface BFlowPointFieldsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BFlowPointFields record);

    int insertSelective(BFlowPointFields record);

    BFlowPointFields selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BFlowPointFields record);

    int updateByPrimaryKey(BFlowPointFields record);

}