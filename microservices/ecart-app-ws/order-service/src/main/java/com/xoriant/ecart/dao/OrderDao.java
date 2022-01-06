package com.xoriant.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

	
	
	
}
