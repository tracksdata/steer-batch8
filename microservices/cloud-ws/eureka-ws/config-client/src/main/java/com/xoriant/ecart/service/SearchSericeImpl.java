package com.xoriant.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.entity.Product;


@Service
@EnableFeignClients
public class SearchSericeImpl {
	
	
	@Autowired
	private SearchServicveProxy searchProxy;
	
	//private RestTemplate rt = new RestTemplate();

	public List<?> findAllProducts() {
		
		List<?> products = searchProxy.findAll();
		
		//List<?> products = rt.getForObject("http://localhost:8082/api/search", List.class);
		System.out.println(">>>>> SERICE <<<<<");
		products.forEach(System.out::println);
		System.out.println(">>>>> SERICE <<<<<");
		return products;
	}
	
	public Product findById(int productId) {
		return searchProxy.findById(productId);
		
		//return rt.getForObject("http://localhost:8082/api/search/"+productId, Product.class);
	}
	
	
	
	
	

}
