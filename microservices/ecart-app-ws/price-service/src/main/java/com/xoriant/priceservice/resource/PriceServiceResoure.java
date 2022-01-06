package com.xoriant.priceservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.priceservice.service.PriceService;

@RestController
@RequestMapping("/api/price")
@CrossOrigin
public class PriceServiceResoure {
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/{productId}")
	public double getProductPrice(@PathVariable int productId) {
		return priceService.getPrice(productId);
	}
	
}
