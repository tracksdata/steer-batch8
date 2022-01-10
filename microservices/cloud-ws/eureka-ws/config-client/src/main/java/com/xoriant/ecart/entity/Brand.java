package com.xoriant.ecart.entity;

public class Brand {

	private int brandId;
	private String brandTitle;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandTitle=" + brandTitle + "]";
	}

}
