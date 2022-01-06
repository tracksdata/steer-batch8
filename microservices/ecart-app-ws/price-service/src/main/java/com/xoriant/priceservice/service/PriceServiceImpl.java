package com.xoriant.priceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.priceservice.dao.PriceDao;
import com.xoriant.priceservice.entity.Product;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceDao priceDao;
	
	@Override
	public double getPrice(int productId) {
		Product product = priceDao.findById(productId).orElse(null);
		return product.getProductPrice();
	}

}
