package com.xoriant.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xoriant.ecart.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	// DSL
	//List<Product> findByProdPriceGreaterThanEqual(double price);
	
	//@Query(name = "q1",value = "from Product as p where p.prodPrice>=20000")
	//List<Product> findByPrice(double price);
	
	//@Query(name = "q1",value = "from Product as p where p.prodPrice >= ?1")
	//List<Product> findByPrice(double price);
	
	
	@Query(name = "q1",value = "from Product as p where p.prodPrice >= :pp")
	List<Product> findByPrice(double pp);
	
	//@Query(name = "q1",value = "from Product as p where p.prodPrice >= :productPrice")
	//List<Product> findByPrice(@Param("productPrice") double pp);
	

}
