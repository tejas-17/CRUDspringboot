package com.tejas.springbootCRUD.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tejas.springbootCRUD.cruddemo.dao.EmployeeDAO;
import com.tejas.springbootCRUD.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//injecting Employee
	private EmployeeDAO employeeDAO;
	
    @Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
    	 employeeDAO=theEmployeeDAO;
     }
    
    //delegating call from service to employeeDAO
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id) ;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		employeeDAO.deleteById(theId);

	}

}
