package com.xoriant.ecart.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;


@Controller
public class Sender {
	
	@Autowired
	private RabbitTemplate rt; // it is used to write data to rabbit-mq server
	
	// Create Queue if not already exits
	
	 @Bean
	 public Queue f1() {
		return new Queue("TestQ1", false);
	 }
	 
	 @Bean
	 public Queue f2() {
		return new Queue("TestQ2", false);
	 }
	 
	 // send data to Queue
	 @Bean
	 public void sendMessage() {
		 
		 Map<String, Object> orderDetails=new HashMap<String, Object>();
		 orderDetails.put("ORDER_ID", "ABC9347937");
		 orderDetails.put("ORDER_DATE", LocalDateTime.now());
		 orderDetails.put("TXT_ID", "TXN10320823");
		 orderDetails.put("USER_ID", "Praveem1234");
		 orderDetails.put("TOTAL", 56000);
		 
		 rt.convertAndSend("TestQ1","Message V3");
		 rt.convertAndSend("TestQ2",orderDetails);
	 }
	 
	 
	 
	 
	 
	

}
