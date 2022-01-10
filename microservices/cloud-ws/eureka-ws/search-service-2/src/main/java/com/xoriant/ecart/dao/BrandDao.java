package com.xoriant.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>{
	List<Brand> findByBrandTitleLike(String brandName);
}
