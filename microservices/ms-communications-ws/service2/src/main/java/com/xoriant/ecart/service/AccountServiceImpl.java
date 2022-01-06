package com.xoriant.ecart.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountServiceImpl {
	
	private RestTemplate rt=new RestTemplate();
	
	public String getUserName() {
		
		System.out.println(">>>>> SERVICE-2 ::: ");
		String userName = rt.getForObject("http://localhost:8081/api/service1", String.class);
		return userName;
	}

}
