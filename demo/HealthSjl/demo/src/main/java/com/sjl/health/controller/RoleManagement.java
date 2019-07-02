package com.sjl.health.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sjl.health.Service.RoleManagementService;
import com.sjl.health.entity.BFlow;
import com.sjl.health.entity.BFlowPoint;
import com.sjl.health.entity.Result;

@RequestMapping("/fcb/api/v1/")
@RestController
public class RoleManagement {
	
	@Autowired
	RoleManagementService roleManagementService;
	
	@RequestMapping(value="/menu_list",method=RequestMethod.GET,produces="application/json")
	public Result<List<BFlow>> getMenuList(@Param("User_name") String userName,@Param("B_id")String bId) {
		//设置Token校验位，如果校验位为1，则可以调用获取列表菜单服务
		int tokenFlag = 1;
		Result<List<BFlow>> resultList = new Result<List<BFlow>>();
		if (userName == null || bId == null || userName.equals("") || bId.equals("")) {
			try {
				throw new Exception("传入的信息有误,不能存在空值");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				resultList.setErr_Code("0001");
				resultList.setErr_Msg(e.getMessage());
				e.printStackTrace();
				return resultList;
			}
		}
		//1.通过用户名称获取用户角色
		if (tokenFlag == 1) {
			//调用获取菜单列表服务
			try {
				resultList = roleManagementService.getMenuList(userName, bId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				resultList.setErr_Code("0001");
				resultList.setErr_Msg(e.getMessage());
				e.printStackTrace();
				return resultList;
			}
		}
		return resultList;
    }
	
	@RequestMapping(value="/tab_list",method=RequestMethod.GET,produces="application/json")
	public Result<List<BFlowPoint>> getTalList(@Param("User_name") String userName,@Param("B_id")String bId,@Param("flowNo")String flowNo) {
		//设置Token校验位，如果校验位为1，则可以调用获取列表菜单服务
		int tokenFlag = 1;
		Result<List<BFlowPoint>> resultList = new Result<List<BFlowPoint>>();
		if (userName == null || bId == null || flowNo == null || userName.equals("") || bId.equals("") || flowNo.equals("")) {
			try {
				throw new Exception("传入的信息有误,不能存在空值");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				resultList.setErr_Code("0001");
				resultList.setErr_Msg(e.getMessage());
				e.printStackTrace();
				return resultList;
			}
		}
		//1.通过用户名称获取用户角色
		if (tokenFlag == 1) {
			//调用获取菜单列表服务
			try {
				resultList = roleManagementService.getTabList(userName, bId, flowNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				resultList.setErr_Code("0001");
				resultList.setErr_Msg(e.getMessage());
				e.printStackTrace();
				return resultList;
			}
		}
		return resultList;
    }
	
}
