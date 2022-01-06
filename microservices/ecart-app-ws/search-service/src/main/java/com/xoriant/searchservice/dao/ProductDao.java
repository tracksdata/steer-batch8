package com.xoriant.searchservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.searchservice.entity.Product;


public interface ProductDao extends JpaRepository<Product, Integer>{
	
	// DSL
	List<Product> findByCategory_CatTitleEquals(String s1);
	List<Product> findByProductPriceGreaterThanEqual(double price);
	List<Product> findByProductPriceBetween(double start,double end);
	List<Product> findByProductTitleLike(String productTitle);
	List<Product> findByBrand_BrandTitleEquals(String brandTitle);
	List<Product> findByProductKeywordsLike(String keywords);
}
