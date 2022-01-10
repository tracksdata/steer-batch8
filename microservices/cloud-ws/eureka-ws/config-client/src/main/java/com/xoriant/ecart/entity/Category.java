package com.xoriant.ecart.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int catId;
	private String catTitle;

	List<Brand> brands = new ArrayList<>();

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

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catTitle=" + catTitle + "]";
	}

}
