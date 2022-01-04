package com.xoriant.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Product;
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	List<Product> findByProductPriceGreaterThanEqual(double price);
	List<Product> findByProductPriceBetween(double start,double end);

	List<Product> findByBrand_BrandTitleEquals(String brandTitle);

}
