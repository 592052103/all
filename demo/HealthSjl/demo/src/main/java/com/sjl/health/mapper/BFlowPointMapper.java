package com.sjl.health.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sjl.health.entity.BFlowPoint;

public interface BFlowPointMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BFlowPoint record);

    int insertSelective(BFlowPoint record);

    BFlowPoint selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BFlowPoint record);

    int updateByPrimaryKey(BFlowPoint record);
    
    List<BFlowPoint> getFlowPointByFlowNo(@Param("bId")String bId,@Param("flowNo")String flowNo);
}