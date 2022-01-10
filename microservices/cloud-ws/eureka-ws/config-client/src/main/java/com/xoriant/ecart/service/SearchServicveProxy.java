package com.xoriant.ecart.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.ecart.entity.Product;

@FeignClient(name = "search-service",url = "http://localhost:8082/api/search")
public interface SearchServicveProxy {

	@GetMapping
	List<Product> findAll();
	
	@GetMapping("/{productId}")
	Product findById(@PathVariable int productId);
	
}
