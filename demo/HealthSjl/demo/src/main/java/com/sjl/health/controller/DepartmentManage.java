package com.sjl.health.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sjl.health.Service.DepartmentManageService;
import com.sjl.health.entity.Department;
import com.sjl.health.entity.Result;

@RequestMapping("/department")
@RestController
public class DepartmentManage {
	
	@Autowired
	private DepartmentManageService departmentManageService;
	
	@RequestMapping(value="/addDepartment",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Result<?> addDepartment(@RequestBody Department department) {
		Result<?> result = new Result<Department>();
		
		if (department.getClinicId() == null) {
			try {
				throw new Exception("诊所Id不能为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				result.setError(e.getMessage());
				e.printStackTrace();
				return result;
				//e.printStackTrace();
			}
		}
		
		try {
			result = departmentManageService.addDepartment(department);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
        }
		return result;
    }
	
	
	@RequestMapping(value="/getPageOfDepartment",method=RequestMethod.GET,produces="application/json")
	public Result<List<Department>> getPageOfDepartment(@Param("start") Integer start,@Param("pageSize")Integer pageSize) {
		List<Department> departmentList = new ArrayList<Department>();
		Result<List<Department>> result = new Result<List<Department>>();
		if (start != null && pageSize == null || start == null && pageSize != null) {
			try {
				throw new Exception("您输入的查询信息有误");
			}catch (Exception e) {
//				result.setError(e.getMessage());
				e.printStackTrace();
				return result;
			}
		}
		try {
			departmentList = departmentManageService.getPageOfDepartment(start, pageSize);
			result.setData(departmentList);
		}catch (RuntimeException e) {
//			result.setError(e.getMessage());
			e.printStackTrace();
			return result;
        }
//		if (result.getError() == null) {
//			result.setSuccess(true);
//		}
		return result;
    }

	
	@RequestMapping(value="/updateDepartment",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Result<Integer> updateDepartment(@RequestBody Department department) {
		Result<Integer> result = new Result<Integer>();
		
		if (department.getDepartmentId() == null) {
			try {
				throw new Exception("请输入需要修改的部门ID编号");
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				result.setError(e.getMessage());
				e.printStackTrace();
				return result;
				//e.printStackTrace();
			}
		}
		
		try {
			result = departmentManageService.updateDepartment(department);
		}catch (RuntimeException e) {
//			result.setError(e.getMessage());
			e.printStackTrace();
			return result;
        }
		return result;
    }
	
	
}
