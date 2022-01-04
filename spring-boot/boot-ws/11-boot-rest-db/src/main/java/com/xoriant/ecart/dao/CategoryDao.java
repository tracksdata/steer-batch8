package com.xoriant.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Brand;
import com.xoriant.ecart.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	
}
