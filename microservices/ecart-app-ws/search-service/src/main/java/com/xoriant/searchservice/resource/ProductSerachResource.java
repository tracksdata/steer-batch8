package com.xoriant.searchservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xoriant.searchservice.entity.Product;
import com.xoriant.searchservice.service.ProductService;

@RestController
@RequestMapping("/api/search")
@CrossOrigin
public class ProductSerachResource {
	
	@Autowired
	private ProductService productService;

		
		// list all products
		@GetMapping
		public List<Product> findAll(){
			return productService.findAllProducts();
		}
		
		//List all products by category title
		@GetMapping("/filter/category/{title}")
		public List<Product> findByCategory_CatTitleEquals(@PathVariable String title){
			return productService.findByCategory_CatTitleEquals(title);
		}
		
		//List all products by price greater than
		@GetMapping("/filter/price/{price}")
		public List<Product> findByProductPriceGreaterThanEqual(@PathVariable double price){
			return productService.findByProductPriceGreaterThanEqual(price);
		}
		
		//List all products by price range
		@GetMapping("/filter/pricerange/{start}/{end}")
		public 	List<Product> findByProductPriceBetween(@PathVariable double start,@PathVariable double end){
			return productService.findByProductPriceBetween(start, end);
		}
		
		//List all products by product name
		@GetMapping("/filter/title/{productTitle}")
		public List<Product> findByProductTitleLike(@PathVariable String productTitle){
			return productService.findByProductTitleLike("%"+productTitle+"%");
		}


		//List all products by Brand Name
		@GetMapping("/filter/brandtitle/{brandTitle}")
		public List<Product> findByBrand_BrandTitleEquals(@PathVariable String brandTitle){
			return productService.findByBrand_BrandTitleEquals(brandTitle);
		}

		// List all products by product keywords
		@GetMapping("/filter/keywords/{keywords}")
		public List<Product> findByProductKeywordsLike(@PathVariable String keywords){
			return productService.findByProductKeywordsLike("%"+keywords+"%");
		}
		
		// find product by id
		@GetMapping("/{id}")
		public Product findById(@PathVariable int id) {
			return productService.findById(id);
		}
		
		
	
	
	

}
