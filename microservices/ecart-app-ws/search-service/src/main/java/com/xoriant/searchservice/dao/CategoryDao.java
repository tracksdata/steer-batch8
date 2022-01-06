package com.xoriant.searchservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.searchservice.entity.Category;


public interface CategoryDao extends JpaRepository<Category, Integer>{

}
