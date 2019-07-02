package com.sjl.health.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sjl.health.kafkaSerializeTest.Person;
import com.sjl.health.kafkaSerializeTest.PersonJsonDeserializer;
import com.sjl.health.kafkaSerializeTest.PersonJsonSerializer;


@Service
public class KafkaProducer {
	
	@SuppressWarnings("all")
	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Autowired
	private PersonJsonSerializer personJsonSerializer;
	
	@Autowired
	private PersonJsonDeserializer personJsonDeserializer; 
	
	@SuppressWarnings("unchecked")
	public void sendTest() {

		Person person = new Person();
		person.setId(1);
		person.setName("kafka");
		person.setAge(18);
		System.out.println(personJsonSerializer.serialize("testB", person));
		byte[] personByte = personJsonSerializer.serialize("testB", person);
		Person personDesir = personJsonDeserializer.deserialize("testB", personByte);
		System.out.println(personDesir.getName());
		//kafkaTemplate.send("testB","key"  + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
		kafkaTemplate.send("testB",personByte);
		/*kafkaTemplate.send("testB",personJsonSerializer.serialize("testB", person));*/
		
	}
}
