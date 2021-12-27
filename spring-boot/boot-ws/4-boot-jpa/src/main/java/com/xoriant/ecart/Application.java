package com.xoriant.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.xoriant.ecart.dao.EmployeeDaoImpl;
import com.xoriant.ecart.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		
		EmployeeDaoImpl empDao = ac.getBean(EmployeeDaoImpl.class);
		
		//empDao.listAll().forEach(System.out::println);
		
		Employee emp = empDao.findById(5);
		System.out.println(emp);
	}

}
