package com.sjl.health.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sjl.health.Service.LoginManagementService;
import com.sjl.health.entity.LoginUser;
import com.sjl.health.entity.Result;
import com.sjl.health.entity.Token;

@RequestMapping("/fcb/api/v1/")
@RestController
public class LonginManagement {
	
	private final static Logger logger = LoggerFactory.getLogger(LonginManagement.class);
	
	@Autowired
	LoginManagementService loginManagementService;
	
	//超级管理员可以进B端
	String admin ="admin";
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json")
	public Result<Token> loginService(@RequestBody LoginUser userInfo) {
		Result<Token> result = new Result<Token>();
		Token token = new Token();
		if (((userInfo.getbId() == null && userInfo.getUserName() == null) || (userInfo.getbId() == null && userInfo.getPassword() == null)) ||
				userInfo.getbId() == null && userInfo.getUserName() == null && userInfo.getPassword() == null ) {
			try {
				result.setErr_Code("0001");
				result.setErr_Msg("输入信息不能为空");
				result.setData(null);
				throw new Exception("输入信息不能为空");
			}catch(Exception e){
				logger.info(e.getMessage());
				e.printStackTrace();
				return result;
			}
		}
		
		//1。当bId为空时
		if (userInfo.getbId() == null && userInfo.getUserName() != null && userInfo.getPassword() != null) {
			try {
				String bId = null;
				result = loginManagementService.loginBackPortCalibService(bId,userInfo.getUserName(),userInfo.getPassword());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//2.当bId不为空时
		else if (userInfo.getbId().equals("admin") && userInfo.getUserName() != null && userInfo.getPassword() != null) {
			try {
				result = loginManagementService.loginBackPortCalibService(userInfo.getbId(),userInfo.getUserName(), userInfo.getPassword());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (userInfo.getbId() != null && userInfo.getUserName() != null && userInfo.getPassword() != null) {
			try {
				result = loginManagementService.loginBPortCalibService(userInfo.getbId(),userInfo.getUserName(), userInfo.getPassword());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
