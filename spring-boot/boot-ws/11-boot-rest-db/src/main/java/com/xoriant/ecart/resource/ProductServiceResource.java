package com.xoriant.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.entity.Product;

@RestController
public class ProductServiceResource {
	
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping
	public List<Product> findAll(){
		return productDao.findAll();
	}
	
	@PostMapping
	public String f2() {
		return "POST :: Request";
	}
	
	@PutMapping
	public String f3() {
		return "PUT :: Request";
	}
	
	@DeleteMapping
	public String f4() {
		return "DELETE :: Request";
	}
	
	@PatchMapping
	public String f5() {
		return "PATCH :: Request";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
