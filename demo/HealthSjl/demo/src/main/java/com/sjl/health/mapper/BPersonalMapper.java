package com.sjl.health.mapper;

import org.apache.ibatis.annotations.Param;

import com.sjl.health.entity.BPersonal;

public interface BPersonalMapper {
    int deleteByPrimaryKey(String personnelId);

    int insert(BPersonal record);

    int insertSelective(BPersonal record);

    BPersonal selectByPrimaryKey(String personnelId);

    int updateByPrimaryKeySelective(BPersonal record);

    int updateByPrimaryKey(BPersonal record);
    
    BPersonal selectByloginName(String loginName);
    
    BPersonal getRoleByUserName(@Param("userName") String userName,@Param("clinicIndex")String clinicIndex);
}