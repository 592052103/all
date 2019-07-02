package com.sjl.health.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sjl.health.Service.BPortManagementService;
import com.sjl.health.entity.Department;
import com.sjl.health.entity.Result;
import com.sjl.health.entity.THealthDataDefine;

@RequestMapping("/fcb/api/v1/")
@RestController
public class BPortManagement {
	
	@Autowired
	BPortManagementService bPortManagementService;
	
	private final static Logger logger = LoggerFactory.getLogger(BPortManagementService.class);
	
	@RequestMapping(value="/getdatalist",method=RequestMethod.GET,produces="application/json")
	public Result<?> getdataList(@Param("userId") String userId,@Param("flowNo")String flowNo,@Param("flowPointId")String flowPointId,
						@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize,@Param("params")String params) {
		Result<?> result = new Result<Department>();
		List<THealthDataDefine> tHealthDataDefine = null;
		
		if (flowNo != null && flowPointId != null) {
			try {
				throw new Exception("流程编码与流程Id不能为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
//				result.setError("0001");
//				result.setMsg("流程编码与流程Id不能为空");
				e.printStackTrace();
				return result;
			}
		}
		
		if (flowNo != null && flowPointId != null) {
			try {
				//tHealthDataDefine = bPortManagementService.getFlowPointFieldsSearchMenu(flowNo, flowPointId);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;

	}	
}
