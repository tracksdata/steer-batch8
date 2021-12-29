package com.xoriant.ecart;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.entity.Product;

@SpringBootApplication
public class Application {
	
	
	/*
	 * 
	 * Hands on
	 * -------------
	 * 
	 * 1. List all Products
	 * 2. List all products by Brand Title
	 * 3. List all brands
	 * 4. List all categories
	 * 5. List all products by category name
	 * 6. List all products with in given price start and end range
	 * 7. List all products above given price range
	 * 8. List all orders of a given user id
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		ProductDao prodDao = ac.getBean(ProductDao.class);
		
		Product prod = prodDao.findById(14).orElse(null);
		
		/*
		System.out.println(prod.getProductId());
		System.out.println(prod.getProductTitle());
		System.out.println(prod.getProdPrice());
		
		System.out.println("Brand ID: "+prod.getBrand().getBrandId());
		System.out.println("Brand Name: "+prod.getBrand().getBrandTitle());
		System.out.println("Category ID: "+prod.getCategory().getCatId());
		System.out.println("Category Name: "+prod.getCategory().getCatTitle());
		*/
		
		//prodDao.findByProdPriceGreaterThanEqual(20000).forEach(System.out::println);
		prodDao.findByPrice(30000).forEach(System.out::println);
		
		
		
		
	}

}
