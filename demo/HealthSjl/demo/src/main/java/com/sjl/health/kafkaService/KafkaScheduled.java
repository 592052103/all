package com.sjl.health.kafkaService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaScheduled {
	
	protected static Logger logger=LoggerFactory.getLogger(KafkaScheduled.class); 
	
	@Autowired
	private KafkaProducer kafkaSender;
	
	//每间隔一分钟执行一次
	@Scheduled(fixedRate = 1000 * 20)
	public void testKafka() throws Exception{
		logger.info("KafkaScheduled...start");
		kafkaSender.sendTest();
	}
	
	
	

}
