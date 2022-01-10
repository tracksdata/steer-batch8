package com.xoriant.ecart.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/products")
@CrossOrigin
@RefreshScope
public class ProductServiceResource {
	
	@Value("${msg}")
	private String message;
	
	
	@GetMapping
	public String f1() {
		return "Mesage from aserver:: "+message;
	}

	
}
