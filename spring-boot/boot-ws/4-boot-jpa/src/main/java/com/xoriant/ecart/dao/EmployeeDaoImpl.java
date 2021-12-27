package com.xoriant.ecart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xoriant.ecart.entity.Employee;


@Repository
public class EmployeeDaoImpl {
	@PersistenceContext
	private EntityManager em;
	
	public List<?> listAll(){
		Query qry = em.createQuery("from Employee");
		List<?> employees = qry.getResultList();
		return employees;
	}
	
	
	public Employee findById(int id) {
		Employee employee = em.find(Employee.class, id);
		if(employee!=null) {
			return employee;
		}
		return null;
	}
	
	
	
	
	

}
