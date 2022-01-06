package com.xoriant.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{

	// DSL
	void deleteByUserIdEquals(int userId);
}
