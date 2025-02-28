package com.mtoaima.jdbc_project.repository.impl;

import com.mtoaima.jdbc_project.mapper.EmployeeMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.mtoaima.jdbc_project.model.Employee;
import com.mtoaima.jdbc_project.repository.EmployeeRepo;

@Component
@Qualifier("employeeNamedParameterJDBCRepo")
public class EmployeeNamedParameterJDBCRepo implements EmployeeRepo {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcNamedTemplate;

	@Override
	public int count() {
	    return jdbcNamedTemplate.queryForObject("select count(*) from employees", new MapSqlParameterSource(), Integer.class);
	}

	
	@Override
	public Employee findById(Long id) {
		return jdbcNamedTemplate.queryForObject("select id, name, salary from employees where id= :id",
				new MapSqlParameterSource("id", id), 
				new EmployeeMapper()); 
	}

	@Override
	public List<Employee> findAll() {
		return jdbcNamedTemplate.query("select id, name, salary from employees", new MapSqlParameterSource(), new EmployeeMapper()); 
	}

	@Override
	public int insert(Employee employee) {
		return jdbcNamedTemplate.update("insert into employees (id,name,salary) values (:employeeId, :name, :salary)", 
				new BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int update(Employee employee) {	
		return jdbcNamedTemplate.update("update employees set name = :name, salary = :salary",
				new BeanPropertySqlParameterSource(employee));
	}
	
	@Override
	public int delete(Long id) {
		return jdbcNamedTemplate.update("delete from employees where id = :id", 
				new MapSqlParameterSource("id", id));
	}

	@Override
	public List<Employee> findByNameAndSalary(String name , Double salary) {
		MapSqlParameterSource mapParam = new MapSqlParameterSource();
		mapParam.addValue("name", name);
		mapParam.addValue("salary", salary);
		
		return jdbcNamedTemplate.query("select id, name, salary from employees where name = :name and salary = :salary", 
                mapParam, 
                new EmployeeMapper());	}

		
	
	

}
