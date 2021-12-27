package com.xoriant.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{   }
