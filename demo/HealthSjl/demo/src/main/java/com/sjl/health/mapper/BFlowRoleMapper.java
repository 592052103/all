package com.sjl.health.mapper;

import org.apache.ibatis.annotations.Param;

import com.sjl.health.entity.BFlowRole;

public interface BFlowRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BFlowRole record);

    int insertSelective(BFlowRole record);

    BFlowRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BFlowRole record);

    int updateByPrimaryKey(BFlowRole record);
    
    BFlowRole getBFlowRoleByFlowNO(@Param("clinicIndex") String clinicIndex,@Param("flowNO")String flowNO);
}