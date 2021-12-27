package com.xoriant.ecart;

import java.util.List;

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
		
		
		
		
		//empDao.findAll().forEach(System.out::println);
		
		//Employee employee = empDao.findById(4).get();
		
		
		//System.out.println(employee);
		
		
		//List<Employee> emps = empDao.findByEmpIdGreaterThanEqual(4);
		//List<Employee> emps = empDao.findByEmpNameLike("%a%");
		List<Employee> emps = empDao.findByEmpNameLikeAndEmpIdGreaterThanEqual("%a%", 4);
		
		emps.forEach(System.out::println);
		
		
		
		
		
		
	}

}
