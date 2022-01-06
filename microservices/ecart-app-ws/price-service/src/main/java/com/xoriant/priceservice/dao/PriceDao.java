package com.xoriant.priceservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.priceservice.entity.Product;

public interface PriceDao extends JpaRepository<Product, Integer>{

}
