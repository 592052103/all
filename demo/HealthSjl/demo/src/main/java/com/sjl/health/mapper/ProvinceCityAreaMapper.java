package com.sjl.health.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import com.sjl.health.entity.ProvinceCityArea;

@Mapper
@Component(value = "provinceCityAreaMapper")
public interface ProvinceCityAreaMapper {
	
    int deleteByPrimaryKey(Integer pcaId);

    int insert(ProvinceCityArea record);

    int insertSelective(ProvinceCityArea record);

    ProvinceCityArea selectByPrimaryKey(Integer pcaId);

    int updateByPrimaryKeySelective(ProvinceCityArea record);

    int updateByPrimaryKey(ProvinceCityArea record);
    
}