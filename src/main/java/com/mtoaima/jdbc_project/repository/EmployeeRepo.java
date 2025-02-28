package com.mtoaima.jdbc_project.repository;

import java.util.List;

import com.mtoaima.jdbc_project.model.Employee;

public interface EmployeeRepo {

	int count();
	
	Employee findById(Long id);
	
	List<Employee> findAll();
	
	List<Employee> findByNameAndSalary(String name, Double salary);

	
	int insert(Employee employee);
	
	int update(Employee employee);
	
	int delete(Long id);

}
