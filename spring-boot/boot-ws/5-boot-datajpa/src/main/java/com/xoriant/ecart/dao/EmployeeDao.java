package com.xoriant.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.ecart.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	// 30 built in methods with JpaRepository interface 
	
	
	// DSL : Domain Specific Language
	
	// find all employees whose id is greater than equals to 4 
	List<Employee> findByEmpIdGreaterThanEqual(int empId);
	
	// final all employees whose name contains a letter 'a' or 'A'
	List<Employee> findByEmpNameLike(String empName);
	// final all employees whose name contains a letter 'a' or 'A'
	// and whose id is greater than equals to 4 
	
	List<Employee> findByEmpNameLikeAndEmpIdGreaterThanEqual(String s1,int id);

	
	
	
	
	
	
}
