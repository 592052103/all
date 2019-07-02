package com.example.demo.mapper;
import com.example.demo.entity.DemoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "demoInfoMapper")
public interface DemoInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DemoInfo record);

    int insertSelective(DemoInfo record);

    DemoInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemoInfo record);

    int updateByPrimaryKey(DemoInfo record);
    
    
}