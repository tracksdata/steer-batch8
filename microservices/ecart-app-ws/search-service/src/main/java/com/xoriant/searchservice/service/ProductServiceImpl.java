package com.xoriant.searchservice.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.searchservice.controller.Receiver;
import com.xoriant.searchservice.dao.ProductDao;
import com.xoriant.searchservice.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	
	// Inventory Update
	
	public void updateInventory(int productId,int qty) {
		
		Product product = productDao.findById(productId).orElse(null);
		product.setProductQty(product.getProductQty()-qty);
		productDao.save(product);
		System.out.println("SEARCH SERVICE::: Product Updated: "+product);

	}
	
	
	@Override
	public Product findById(int id) {
		return productDao.findById(id).orElse(null);
	}
	
	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}
	@Override
	public void deleteById(int id) {
		productDao.deleteById(id);
	}
	
	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}

	@Override
	public List<Product> findByCategory_CatTitleEquals(String s1) {
		return productDao.findByCategory_CatTitleEquals(s1);
	}

	@Override
	public List<Product> findByProductPriceGreaterThanEqual(double price) {
		return productDao.findByProductPriceGreaterThanEqual(price);
	}

	@Override
	public List<Product> findByProductPriceBetween(double start, double end) {
		return productDao.findByProductPriceBetween(start, end);
	}

	@Override
	public List<Product> findByProductTitleLike(String productTitle) {
		return productDao.findByProductTitleLike(productTitle);
	}

	@Override
	public List<Product> findByBrand_BrandTitleEquals(String brandTitle) {
		return productDao.findByBrand_BrandTitleEquals(brandTitle);
	}

	@Override
	public List<Product> findByProductKeywordsLike(String keywords) {
		return productDao.findByProductKeywordsLike(keywords);
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findProductsByBrandId(int brandId) {

		Stream<Product> products = productDao.findAll().stream();

		return products.filter(product -> product.getBrand().getBrandId() == brandId).collect(Collectors.toList());

	}

}
