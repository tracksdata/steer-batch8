package com.xoriant.ecart.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service1")
public class ProductServiceResource {
	
	@GetMapping
	public String f1() {
		String userName="Praveen";
		return userName;
	}

}
