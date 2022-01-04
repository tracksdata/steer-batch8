package com.xoriant.ecart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue
	private int catId;
	private String catTitle;
	
	@OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
	@JoinTable(name = "brands_info",joinColumns = {@JoinColumn(name="cat_id")},
	inverseJoinColumns =@JoinColumn(name="brand_id"))
	private List<Brand> brands=new ArrayList<>();
	
	
	
	public List<Brand> getBrands() {
		return brands;
	}
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatTitle() {
		return catTitle;
	}
	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}
	
	

}
