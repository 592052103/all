package com.sjl.health.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjl.health.entity.BPersonal;
import com.sjl.health.mapper.BPersonalMapper;

@Service
public class GetUserRoleService {
	
	@Autowired
	BPersonalMapper bPersonalMapper;
	
	public BPersonal getUserRole(String userName,String bId) throws Exception {
		BPersonal bPersonal = null;
		
		if (userName == null || bId == null) {
			throw new Exception("用户的登陆名或所在诊所Id不能未空");
		}
		
		else {
			bPersonal = new BPersonal();
			bPersonal = bPersonalMapper.getRoleByUserName(userName,bId);
			if (userName != null && !userName.equals("")) {
				bPersonal = new BPersonal();
				bPersonal = bPersonalMapper.getRoleByUserName(userName,bId);
			}
		}
		return bPersonal;
	}

}
