package com.sjl.health.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.sjl.health.entity.Department;

@Mapper
@Component(value = "departmentMapper")
public interface DepartmentMapper {
	
    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    List<Department> getPageOfDepartment(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    
	/* int updateDepartmentById(Integer departmentId); */
    
    
}