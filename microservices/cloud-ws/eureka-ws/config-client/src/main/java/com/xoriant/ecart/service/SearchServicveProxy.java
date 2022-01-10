package com.xoriant.ecart.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.ecart.entity.Product;

@FeignClient(name = "search-service") // http://search-service
public interface SearchServicveProxy {

	@GetMapping("/api/search")
	List<Product> findAll();
	
	@GetMapping("/api/search/{productId}")
	Product findById(@PathVariable int productId);
	
}
