package com.sjl.health.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjl.health.entity.BPersonal;
import com.sjl.health.entity.Result;
import com.sjl.health.entity.SysUser;
import com.sjl.health.entity.Token;
import com.sjl.health.mapper.BPersonalMapper;
import com.sjl.health.mapper.SysUserMapper;

@Service
public class LoginManagementService {
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	@Autowired
	BPersonalMapper bPersonalMapper;
	
	@Autowired
	TokenService tokenService;
	
	public Result<Token> loginBackPortCalibService(String bId,String userName,String userPassword) throws Exception {
		Result<Token> result = new Result<Token>();
		Token token = new Token();
		SysUser sysuser = null;
		String tokenString = null;
		try {
			if (userName != null) {
				sysuser = sysUserMapper.selectByUserName(userName);
			}
			if (sysuser != null && sysuser.getPassword() != null) {
				if (sysuser.getPassword().equals(userPassword)) {
					//判断用户密码正确后，在判断当前用户的状态是否有效
					if(sysuser.getStatus().equals(1)) {
						if (bId != null && bId.equals("admin")) {
							result.setErr_Code("0000");
							result.setErr_Msg("A端用户:超级管理员登陆成功");
							tokenString = tokenService.createToken("admin", userName, userPassword);
						}else {
							result.setErr_Code("0000");
							result.setErr_Msg("A端用户:普通用户登陆成功");
							tokenString = tokenService.createToken(null, userName, userPassword);
						}
						//用户登陆成功后,调用Token生成服务
						token.setToken(tokenString);
						result.setData(token);
					}else {
						result.setErr_Code("0001");
						result.setErr_Msg("用户暂已禁止使用");
					}
				}else {
					result.setErr_Code("0001");
					result.setErr_Msg("输入的用户密码 不正确");
				}
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
		// TODO Auto-generated method stub
		return result;
	}
	
	public Result<Token> loginBPortCalibService(String bId,String userName,String userPassword) throws Exception {
		Result<Token> result = new Result<Token>();
		Token token = new Token();
		BPersonal bPersonal = null;
		try {
			if (userName != null) {
				//通过用户账号查询用户信息是否存在
				bPersonal = bPersonalMapper.selectByloginName(userName);
			}
			if (bPersonal != null && bPersonal.getLoginPasswd() != null && bPersonal.getClinicIndex() != null) {
				if (bPersonal.getClinicIndex().equals(bId) && bPersonal.getLoginPasswd().equals(userPassword)) {
					//判断当前用户的状态是否可以使用
					if (bPersonal.getStatus().equals(0)) {
						if (bPersonal.getbClinic().getStatus().equals(0)) {
							result.setErr_Code("0000");
							result.setErr_Msg("用户:B端用户登陆成功");
							String tokenString = tokenService.createToken(bId, userName, userPassword);
							token.setToken(tokenString);
							result.setData(token);
						}else {
							result.setErr_Code("0001");
							result.setErr_Msg("用户:B端用户登陆成功");
						}
					}else {
						result.setErr_Code("0001");
						result.setErr_Msg("用户账户已暂禁止使用");
					}
				}else {
					result.setErr_Code("0001");
					result.setErr_Msg("输入的信息有误");
				}
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
		// TODO Auto-generated method stub
		return result;
	}

}
