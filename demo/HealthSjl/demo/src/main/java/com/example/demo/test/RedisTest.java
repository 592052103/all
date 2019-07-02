package com.example.demo.test;

import com.sjl.health.redisUtil.RedisUtil;

public class RedisTest {
	
	
	public static void main(String[] arg) {
		RedisUtil redisUtil =  new RedisUtil();
		String key = "testDesc";
		Object obj = new Object();
		obj = "helloRedis";
		if (redisUtil != null) {
			redisUtil.set(key, "helloRedis");
			//System.out.println(redisUtil.desc(key, 1));
			//System.out.println(redisUtil.get(key));
		}
	}

}
