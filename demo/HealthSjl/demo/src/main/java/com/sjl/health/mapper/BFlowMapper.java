package com.sjl.health.mapper;

import java.util.List;

import com.sjl.health.entity.BFlow;
import com.sjl.health.entity.BFlowRole;

public interface BFlowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BFlow record);

    int insertSelective(BFlow record);

    BFlow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BFlow record);

    int updateByPrimaryKey(BFlow record);
    
    List<BFlow> getBFlowListByBFlowRole (List<BFlowRole> bFlowRoleList);
}