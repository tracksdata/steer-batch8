package com.xoriant.searchservice.controller;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.xoriant.searchservice.service.ProductService;

@Controller
public class Receiver {
	
	@Autowired
	private RabbitTemplate rt;
	
	
	@Autowired
	private ProductService prodService;
	
	@Bean
	public Queue f2() {
		return new Queue("InventoryQ", false);
	}
	
	@RabbitListener(queues = "InventoryQ")
	public void updateInventory(Map<String, Object> orderInfo) {
		
		int productId=(int)orderInfo.get("PRODUCT_ID");
		int qty=(int)orderInfo.get("QTY");
		
		prodService.updateInventory(productId, qty);
		
				
	}
	
	

}
