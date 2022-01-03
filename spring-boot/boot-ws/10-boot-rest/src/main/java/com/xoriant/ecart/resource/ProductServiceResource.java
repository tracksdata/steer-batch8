package com.xoriant.ecart.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.Product;

@RestController
public class ProductServiceResource {
	
	
	@GetMapping
	public String f1() {
		return "Welcome to REST";
	}
	
	@GetMapping("/s1")
	public Product f2() {
		Product p1=new Product(10, "Laptop", 34000, 3);
		return p1; // JSON -> Java script object notation
	}
	
	@GetMapping("/s2")
	public String[] f3() {
		String[] names= {"Abc","Xyz","test","Bla"};
		return names; // JSON Array
	}
	
	@GetMapping("/s3")
	public List<Product> f4(){
		Product p1=new Product(10, "Laptop", 34000, 3);
		Product p2=new Product(11, "Pen", 32, 30);
		Product p3=new Product(12, "Book", 11, 21);
		
		return Arrays.asList(p1,p2,p3); // Array of JSON Object

	}

}
