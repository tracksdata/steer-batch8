package com.xoriant.searchservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.searchservice.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>{
	List<Brand> findByBrandTitleLike(String brandName);
}
