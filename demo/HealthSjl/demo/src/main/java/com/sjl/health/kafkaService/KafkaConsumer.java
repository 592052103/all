package com.sjl.health.kafkaService;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sjl.health.kafkaSerializeTest.Person;
import com.sjl.health.kafkaSerializeTest.PersonJsonDeserializer;

@Service
public class KafkaConsumer {
	
	protected static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	/**
	 * 监听test主题,有消息就读取
	 * @param message
	 */
	
	@Autowired
	private PersonJsonDeserializer personJsonDeserializer; 
	
	@KafkaListener(topics = {"testB"})
	public void consumer(ConsumerRecord<?, ?> consumer) {
		
		logger.info("{} - {}:{}" + "topic is" + consumer.topic() + "topic key is" + consumer.key() + "message is" + consumer.value());
		
		String kafkaStr = consumer.value().toString();
		
		System.out.println(kafkaStr);
		JSONObject person = JSON.parseObject(kafkaStr);
		Person p = JSON.toJavaObject(person, Person.class);
		//Person person = (Person) JSON.parse(kafkaStr);//personJsonDeserializer.kafkaStr
		System.out.println(p.getName());
		System.out.println(p.getAge());
//		byte[] personByte = (byte[]) consumer.value();
//		Person personDesir = personJsonDeserializer.deserialize("testB", personByte);
//		System.out.println(personDesir.getName());
		
//		int consumerSize = consumer.serializedValueSize();
//		
//		byte[] content = consumer.value().toString().getBytes();
//				
//		personJsonDeserializer.deserialize("testB", content);
		
		//System.out.println(person.getName());
	}
}
