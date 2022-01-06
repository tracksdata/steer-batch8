package com.xoriant.ecart.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.service.AccountServiceImpl;

@RestController
@RequestMapping("/api/service2")
public class AccountServiceResource {
	
	@Autowired
	private AccountServiceImpl ac;
	
	
	@GetMapping
	public String getUser() {
		System.out.println(">>> SERVICE1:: ");
		return ac.getUserName();
	}

}
