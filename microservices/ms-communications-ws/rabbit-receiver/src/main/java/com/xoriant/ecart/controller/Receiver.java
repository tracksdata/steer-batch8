package com.xoriant.ecart.controller;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {
	
	
	@RabbitListener(queues = {"TestQ1"})
	public void readMessage(String msg) {
		System.out.println("=============================");
		System.out.println(">>>> Message: "+msg);
		System.out.println("=============================");	
	}
	
	
	@RabbitListener(queues = "TestQ2")
	public void readOrderDetails(Map<String, Object> orderInfo) {
		System.out.println("=============================");
		System.out.println(orderInfo.get("ORDER_ID"));
		System.out.println(orderInfo.get("ORDER_DATE"));
		System.out.println(orderInfo.get("TXT_ID"));
		System.out.println(orderInfo.get("USER_ID"));
		System.out.println(orderInfo.get("TOTAL"));
		System.out.println("=============================");

	}

}
