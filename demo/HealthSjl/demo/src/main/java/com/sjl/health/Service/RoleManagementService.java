package com.sjl.health.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjl.health.entity.BFlow;
import com.sjl.health.entity.BFlowPoint;
import com.sjl.health.entity.BFlowRole;
import com.sjl.health.entity.BPersonal;
import com.sjl.health.entity.Result;
import com.sjl.health.mapper.BFlowMapper;
import com.sjl.health.mapper.BFlowPointMapper;
import com.sjl.health.mapper.BFlowPointRoleMapper;
import com.sjl.health.mapper.BFlowRoleMapper;
import com.sjl.health.mapper.BPersonalMapper;

@Service
public class RoleManagementService {
	
	@Autowired
	BPersonalMapper bPersonalMapper;
	
	@Autowired
	BFlowRoleMapper bFlowRoleMapper;
	
	@Autowired
	BFlowMapper bFlowMapper;
	
	@Autowired
	GetUserRoleService getUserRoleService;
	
	@Autowired
	BFlowPointMapper bFlowPointMapper;
	
	@Autowired
	BFlowPointRoleMapper bFlowPointRoleMapper;
	
	public Result<List<BFlow>> getMenuList(String userName,String bId) throws Exception{
		BPersonal bPersonal = null;
		Result<List<BFlow>> resultList = new Result<List<BFlow>>();
		List<BFlowRole> bFlowRoleList = null;
		List<BFlow> bFlowList = null;
		if (userName != null && bId != null && !userName.equals("") && !bId.equals("")) {
			//获取用户角色对应的角色
			bPersonal = new BPersonal();
			bPersonal = bPersonalMapper.getRoleByUserName(userName,bId);
			if (bPersonal != null) {
				if (bPersonal.getbFlowRoleList() != null && bPersonal.getbFlowRoleList().size() > 0) {
					bFlowRoleList = bPersonal.getbFlowRoleList();
				}
				//获取FlowNO对象
				bFlowList = bFlowMapper.getBFlowListByBFlowRole(bFlowRoleList);
			}
		}
		if (bFlowList != null && bFlowList.size() > 0) { 
			resultList.setData(bFlowList);
			resultList.setErr_Code("0000");
		}else {
			resultList.setErr_Code("0001");
			resultList.setErr_Code("该角色没有对应的流程信息");
		}
		return resultList;
	}
	
	
	public Result<List<BFlowPoint>> getTabList(String userName,String bId,String flowNo) throws Exception{
		BPersonal bPersonal = null;
		List<BFlowPoint> bFlowPointList = null;
		Result<List<BFlowPoint>> resultList = new Result<List<BFlowPoint>>();
		List<BFlowRole> bFlowRoleList = null;
		List<BFlow> bFlowList = null;
		List<BFlowPoint> bFlowPointResultList = new ArrayList<BFlowPoint>();
		if (userName != null && bId != null && flowNo != null && !userName.equals("") && !bId.equals("") && !flowNo.equals("")) {
			//获取用户角色
			bPersonal = getUserRoleService.getUserRole(userName, bId);
			//获取流程点列表
			if (bPersonal != null && bPersonal.getRoleIndex() != null) {
				Integer personalRole = bPersonal.getRoleIndex();
				//先校验用户的角色getFlowPointByFlowNo
				bFlowPointList = bFlowPointMapper.getFlowPointByFlowNo(bId, flowNo);
				//获取流程点
				if (bFlowPointList != null && bFlowPointList.size() > 0) {
					for (int i = 0; i < bFlowPointList.size(); i ++) {
						if (bFlowPointList.get(i).getbFlowPointRole().getRoleIndex() != null 
								&& bFlowPointList.get(i).getbFlowPointRole().getRoleIndex().equals(personalRole)) {
							bFlowPointResultList.add(bFlowPointList.get(i));
						}
					}
					if (bFlowPointResultList != null && bFlowPointResultList.size() > 0) {
						resultList.setData(bFlowPointResultList);
						resultList.setErr_Code("0000");
					}
				}else {
					//该角色没有flowPoind
					resultList.setData(null);
					resultList.setErr_Code("0001");
				}
			}
		}
		return resultList;
	}

}
