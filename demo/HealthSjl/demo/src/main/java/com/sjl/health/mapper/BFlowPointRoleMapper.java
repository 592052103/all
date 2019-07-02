package com.sjl.health.mapper;

import com.sjl.health.entity.BFlowPointRole;

public interface BFlowPointRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BFlowPointRole record);

    int insertSelective(BFlowPointRole record);

    BFlowPointRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BFlowPointRole record);

    int updateByPrimaryKey(BFlowPointRole record);
    
}