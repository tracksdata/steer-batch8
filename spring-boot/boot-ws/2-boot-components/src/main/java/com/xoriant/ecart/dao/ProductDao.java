package com.xoriant.ecart.dao;

import java.util.List;

import com.xoriant.ecart.model.Product;

public interface ProductDao {

	void save(Product product);

	Product findById(int id);

	List<Product> findAll();

}