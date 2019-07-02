package com.sjl.health.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sjl.health.entity.Department;
import com.sjl.health.entity.Result;
import com.sjl.health.mapper.DepartmentMapper;

@Service
public class DepartmentManageService {
	
	@Autowired
	private DepartmentMapper departmentmapper;

	public Result<?> addDepartment(Department department) {
		//定义添加部门信息是否成功 1:添加成功 0:添加失败
		int i = 0;
		Result<?> result = new Result<Department>();
		try {
			if (department.getClinicId() != null) {
				i = departmentmapper.insertSelective(department);
			}
//			if (i != 0) {
//				 result.setSuccess(true);
//			}else {
//				result.setError("failure");
//			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
		// TODO Auto-generated method stub
		return result;
	}
	
	public List<Department> getPageOfDepartment(Integer start, Integer pageSize) {
		//定义添加部门信息是否成功 1:添加成功 0:添加失败
		List<Department> departmentList = new ArrayList<Department>();
		try {
			if (start != null && pageSize != null) {
				start = (start - 1) * pageSize;
			}
			departmentList = departmentmapper.getPageOfDepartment(start, pageSize);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
		// TODO Auto-generated method stub
		return departmentList;
	}
	
	//java虚拟机内核
	public Result<Integer> updateDepartment(Department department) {
		//定义修改部门是否成功，不等0修改成功，0修改失败
		int i = 0;
		Result<Integer> result = new Result<Integer>();
		try {
			if (department != null) {
				i = departmentmapper.updateByPrimaryKeySelective(department);
			}
			if (i != 0) {
				result.setData(i);
//				result.setSuccess(true);
			}
		}catch (RuntimeException e) {
//			result.setError(e.getMessage());
			e.printStackTrace();
			return result;
		}
		return result;
		
	}
}
