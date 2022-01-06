package com.xoriant.ecart.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dao.CategoryDao;
import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.entity.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductServiceResource {
	
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@GetMapping
	public List<Product> findAll(){
		return productDao.findAll();
	}
	
	@GetMapping("/{productId}")
	public Product findById(@PathVariable int productId) {
		return productDao.findById(productId).orElse(null);
	}
	
	// list all products grater than given range
	@GetMapping("/filter/price/{price}")
	public List<Product> findByPrice(@PathVariable double price){
		return productDao.findByProductPriceGreaterThanEqual(price);
	}
	
	@GetMapping("/filter/price/{start}/{end}")
	List<Product> findProductsByPriceRange(@PathVariable double start,@PathVariable double end){
		return productDao.findByProductPriceBetween(start, end);
	}
	
	@GetMapping("/filter/brand/{brandTitle}")
	List<Product> findByBrandTitle(@PathVariable String brandTitle){
		return productDao.findByBrand_BrandTitleEquals(brandTitle);
	}
	
	@GetMapping("/filter/category/{categoryTitle}")
	List<?> findBrandsByCategoryTitle(@PathVariable String categoryTitle){
		System.out.println(">>>>>> "+categoryTitle+"<<<<<<<<<<");
	    return categoryDao.findAll().stream().filter(category->category.getCatTitle().equals(categoryTitle)).collect(Collectors.toList());
	}
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		productDao.save(product);
		return product;
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productDao.save(product);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
		
		productDao.deleteById(productId);
		
		return new ResponseEntity<>("Product ID "+productId+" deleted from db",HttpStatus.OK);
	}
	
	@PatchMapping
	public String f5() {
		return "PATCH :: Request";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
