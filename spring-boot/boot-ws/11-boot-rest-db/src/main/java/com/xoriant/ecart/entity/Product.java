package com.xoriant.ecart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="products")
public class Product {
	
	@Id
	@GeneratedValue
	private int productId;
	private String productTitle;
	private double productPrice;
	private int productQty;
	private String productKeywords;
	private String productImage;
	private String productDesc;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
	@JoinColumn(name="product_cat")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
	@JoinColumn(name="product_brand")
	private Brand brand;
	
	
	
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public String getProductKeywords() {
		return productKeywords;
	}
	public void setProductKeywords(String productKeywords) {
		this.productKeywords = productKeywords;
	}
	
	
	

}
