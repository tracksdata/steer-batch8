package com.xoriant.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.xoriant.ecart.dao.EmployeeDao;
import com.xoriant.ecart.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		EmployeeDao empDao = ac.getBean(EmployeeDao.class);
		
		
		//empDao.
		
		//empDao.findAll().forEach(System.out::println);
		
		Employee employee = empDao.findById(4).get();
		
		
		System.out.println(employee);
		
	}

}
