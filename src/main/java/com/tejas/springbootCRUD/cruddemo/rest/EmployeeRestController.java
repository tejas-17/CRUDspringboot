package com.tejas.springbootCRUD.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.springbootCRUD.cruddemo.entity.Employee;
import com.tejas.springbootCRUD.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService eService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		eService=theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	
	@GetMapping("/employees")
	public List<Employee> findall(){
		return eService.findAll();
		}
	
	
	//add mapping for GET/employee by employeeid
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee=eService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("employee id not found-"+employeeId);
		}
		return theEmployee;
	}
	
	
	
	//add mappping for POST /employees add a newemplyee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		eService.save(theEmployee);
		return theEmployee;
		
	}
	
	
	
	
	//add PUT mapping for updating existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		eService.save(theEmployee);
		
		return theEmployee;
	}
	
	//deleting employee /employees/{employeeId} -delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee temp=eService.findById(employeeId);
		
		//check and throw exception if null
		if(temp==null) {
		throw new RuntimeException("Emmployee is null and not found "+employeeId);
		
		}
		eService.deleteById(employeeId);
		return "Delted employee id-"+employeeId;
			
	}	
			
		
	
	
}
