package com.sjl.health.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class TokenService {
	
	/*公共密钥，保存在服务器*/
	public static String SECRET = "healthChain";
	
	public String createToken(String bid,String userName,String password) throws Exception {
		
		//后台管理员进来Bid为1
		if (bid == null) {
			bid = "1";
		}
		
		//过期时间 - 1分钟过期
		Calendar nowTime = Calendar.getInstance();
		nowTime.set(2019, 2, 20, 16, 18, 10);
		System.out.println(nowTime.getTime());
		nowTime.add(Calendar.SECOND, 60);
		System.out.println(nowTime.getTime());
		Date expiresDate = nowTime.getTime();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("type", "JWT");
		String token = JWT.create()
					   .withHeader(map)//header
					   .withClaim("name", userName)//payload
					   .withClaim("age", password)
					   .withClaim("org", bid)
					   .withExpiresAt(expiresDate)//设置过期时间，过期时间要大于签发时间
					   .sign(Algorithm.HMAC256(SECRET));	
		return token;
	}
	
	public static Map<String,Claim> verifyToken(String token) throws Exception{
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
		DecodedJWT jwt = null;
		try {
			jwt = verifier.verify(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("登录凭证已过期，请重新登陆");
		}	
		return jwt.getClaims();	
	}
}
