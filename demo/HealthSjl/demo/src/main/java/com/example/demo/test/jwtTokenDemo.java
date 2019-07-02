package com.example.demo.test;

import java.util.Map;

import com.auth0.jwt.interfaces.Claim;

public class jwtTokenDemo {
	
	public static void main(String[] arg) throws Exception {
		
		String token = jwtToken.createToken();
		
		System.out.println("Token:" + token);
		
		Map<String,Claim> claims = jwtToken.verifyToken(token);
		System.out.println(claims.get("name").asString());
		System.out.println(claims.get("age").asString());
		System.out.println(claims.get("org") == null ? null : claims.get("org").asString());
		
		String tokenExpire = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiRnJlZeeggeWGnCIsImV4cCI6MTU1MzA2OTk1MCwiYWdlIjoiMjgifQ.1J_2eJjhoXnT2g_QKHGeYJnOBhPiQtl0KLmfrZVCIWE";
		
		Map<String,Claim> claimExpire = jwtToken.verifyToken(tokenExpire);
		
	}

}
