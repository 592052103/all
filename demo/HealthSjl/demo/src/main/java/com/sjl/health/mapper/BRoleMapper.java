package com.sjl.health.mapper;

import com.sjl.health.entity.BRole;

public interface BRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(BRole record);

    int insertSelective(BRole record);

    BRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(BRole record);

    int updateByPrimaryKey(BRole record);
}