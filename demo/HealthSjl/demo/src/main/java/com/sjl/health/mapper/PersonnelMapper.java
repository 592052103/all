package com.sjl.health.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.sjl.health.entity.Personnel;

@Mapper
@Component(value = "personnelMapper")
public interface PersonnelMapper {
	
    int deleteByPrimaryKey(String personnelId);

    int insert(Personnel record);

    int insertSelective(Personnel record);

    Personnel selectByPrimaryKey(String personnelId);

    int updateByPrimaryKeySelective(Personnel record);

    int updateByPrimaryKey(Personnel record);
    
}