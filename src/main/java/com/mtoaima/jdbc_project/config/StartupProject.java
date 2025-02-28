package com.mtoaima.jdbc_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mtoaima.jdbc_project.model.Employee;
import com.mtoaima.jdbc_project.repository.EmployeeRepo;

@Component
public class StartupProject implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	@Qualifier("employeeNamedParameterJDBCRepo")
	private EmployeeRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		jdbc.execute("DROP TABLE IF EXISTS employees");
	
		jdbc.execute("CREATE TABLE employees(id SERIAL, name VARCHAR(255), salary NUMERIC(15,2))");
		
		if(repo.count() == 0) {		
			repo.insert(new Employee(20L, "Mostafa", 15000.0));
			repo.insert(new Employee(30L, "Mahmiud", 52201.0));
			repo.insert(new Employee(40L, "Mohamed", 82281.0));
		}
	}

}
