package com.example.demo.test;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TestMainJWT {
	
	public static void main(String[] arg) {
		
		TestMainJWT test = new TestMainJWT();
		String jwt = test.createJWT("3133", "13dsdda", "afrefsa", 20171252);
		System.out.println(jwt);
		/* test.parseJWT(jwt); */
		
	}
	
	@SuppressWarnings("unused")
	private String createJWT(String id, String issuer, String subject, long ttlMillis) {
		
		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		System.out.println(nowMillis);
		Date now = new Date(nowMillis);
		
		//We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(/* "4234dfasdfqdd" */"123123");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		 //Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id)
										   .setIssuedAt(now)
										   .setSubject(subject)
										   .setIssuer(issuer)
										   .signWith(signatureAlgorithm, signingKey);
		
		//if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(exp);
			builder.setExpiration(exp);
			
		}
		
		//Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
		
	}
	
	private void parseJWT(String jwt) {
		
		//This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(/* "4234dfasdfqdd" */"123123"))
		  .parseClaimsJws(jwt).getBody();
		System.out.println("ID: " + claims.getId());	
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());

	}
	
	

}
