package com.tejas.springbootCRUD.cruddemo.dao;

import java.util.List;

import com.tejas.springbootCRUD.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee>  findAll();
	
	public Employee findById(int id);
	public void save (Employee theEmployee);
	public void deleteById(int theId);

}
