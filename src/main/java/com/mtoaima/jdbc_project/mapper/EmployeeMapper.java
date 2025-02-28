package com.mtoaima.jdbc_project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mtoaima.jdbc_project.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Employee(rs.getLong("id"), rs.getString("name"), rs.getDouble("salary"));
	}
}
