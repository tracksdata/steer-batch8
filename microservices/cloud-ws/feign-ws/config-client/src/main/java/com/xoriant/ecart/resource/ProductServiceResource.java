package com.xoriant.ecart.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.entity.Product;
import com.xoriant.ecart.service.SearchSericeImpl;
@RestController
@RequestMapping("/api/products")
@CrossOrigin
@RefreshScope
public class ProductServiceResource {
	
	
	@Autowired
	private SearchSericeImpl ss;
	
	@GetMapping
	public List<?> findAll(){
		return ss.findAllProducts();
	}
	
	@GetMapping("/{productId}")
	public Product findByProductId(@PathVariable int productId) {
		return ss.findById(productId);
	}
	
	

	
	
}
