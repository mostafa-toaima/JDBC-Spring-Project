package com.mtoaima.jdbc_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtoaima.jdbc_project.model.Employee;
import com.mtoaima.jdbc_project.repository.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeNamedParameterJDBCRepo") 
	private EmployeeRepo repo;
	
	
	@GetMapping("/count")
	private int countEmployees() {
		return repo.count();
	}
	
	@GetMapping("/id/{id}")
	private Employee findById(@PathVariable("id") Long id) {
		return repo.findById(id);
	}
	
	@GetMapping("/allEmployees")
	private List<Employee> findAll() {
		return repo.findAll();
	}

	
}
