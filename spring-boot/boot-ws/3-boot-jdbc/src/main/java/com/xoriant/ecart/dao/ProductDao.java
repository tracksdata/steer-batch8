package com.xoriant.ecart.dao;

import java.util.List;

import com.xoriant.ecart.model.Product;

public interface ProductDao {

	// List all Products using  queryForList method
	void findAllV1();

	List<Product> findAllV3();

	List<Product> findAllV4();

}