package com.xoriant.ecart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	@GetMapping("/s1")
	public String f1() {
		System.out.println(">>> productController f1 method");
		return "sample";
	}

}
