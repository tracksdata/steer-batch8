package com.xoriant.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao prodDao;
	@Value("${discount-code}")
	private String code;
	
	@Autowired
	private Environment env;
	
	@Override
	public void save(Product product) {
		System.out.println("Service: saving product");
		System.out.println("Code: "+code);
		System.out.println("Code-V2: "+env.getProperty("discount-code"));
		System.out.println("Name: "+env.getProperty("name"));
		prodDao.save(product);
	}
	
	

}
