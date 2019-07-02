package com.sjl.health.Service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;

public class TokenInvalidService {
	
	@Autowired
	TokenService tokenService;
	
	/**
	 * 创建token 保存token至session
	 * @param request
	 * @param tokenServerKey
	 */
	public void createToken (HttpServletRequest request,String tokenServerKey) {
		try {
			String token = tokenService.createToken(request.getParameter("bid"),
					request.getParameter("userName"), request.getParameter("password"));
			request.getSession().setAttribute(tokenServerKey, token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 移除token
	 * @param request
	 * @param tokenServerKey
	 */
	public void removeToken(HttpServletRequest request,String tokenServerKey) {
		request.getSession().removeAttribute(tokenServerKey);
	}
	
	
	/**
	 * 判断token是否有效
	 * @param request
	 * @param tokenClientKey
	 * @param tokenServerKey
	 * @return
	 */
	public boolean judgeTokenIsEqual(HttpServletRequest request,String tokenClientKey,String tokenServerKey) {
		String tokenClient = request.getParameter(tokenClientKey);
		if (StringUtils.isEmpty(tokenClient)) {
			return false;
		}
		String tokenServer = request.getParameter(tokenServerKey);
		if (StringUtils.isEmpty(tokenServer)) {
			return false;
		}
		if (!tokenServer.equals(tokenClient)) {
			return false;
		}
		return true;
	}
}
