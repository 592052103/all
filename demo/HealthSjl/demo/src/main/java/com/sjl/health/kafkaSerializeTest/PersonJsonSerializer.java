package com.sjl.health.kafkaSerializeTest;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 序列化实现personJsonSerializer
 * @author Administrator
 *
 */
@Component
public class PersonJsonSerializer implements Serializer<Person> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String topic, Person data) {
		// TODO Auto-generated method stub
		return JSON.toJSONBytes(data);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}



}
