package com.xoriant.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	

}
