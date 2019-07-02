package com.sjl.health.kafkaSerializeTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;


@Component
public class PersonJsonDeserializer implements Deserializer<Person>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		return JSON.parseObject(data,Person.class);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}



}
