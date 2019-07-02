package com.sjl.health.entity;

import java.io.Serializable;

public class LoginUser implements Serializable {
	//系统Id
	private String systemId;
	
	//企业Id
	private String bId;
	
	//登陆账号
	private String userName;
	
	//登陆密码
	private String password;
	
	private String calNo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCalNo() {
		return calNo;
	}

	public void setCalNo(String calNo) {
		this.calNo = calNo;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}
	
}
