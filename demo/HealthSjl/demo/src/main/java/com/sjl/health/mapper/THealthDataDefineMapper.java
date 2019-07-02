package com.sjl.health.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sjl.health.entity.THealthDataDefine;

public interface THealthDataDefineMapper {
	
    int deleteByPrimaryKey(Long defineId);

    int insert(THealthDataDefine record);

    int insertSelective(THealthDataDefine record);

    THealthDataDefine selectByPrimaryKey(Long defineId);

    int updateByPrimaryKeySelective(THealthDataDefine record);

    int updateByPrimaryKey(THealthDataDefine record);
    
    List<THealthDataDefine> getFlowPointFieldsSearchMenu(@Param("flowNo") String flowNo, @Param("flowPointId") String flowPointId);
    
    List<THealthDataDefine> getFlowPointFieldsTitle(@Param("flowNo") String flowNo, @Param("flowPointId") String flowPointId);
    
}