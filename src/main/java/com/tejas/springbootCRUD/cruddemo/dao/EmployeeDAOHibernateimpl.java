package com.tejas.springbootCRUD.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tejas.springbootCRUD.cruddemo.entity.Employee;

@Repository //@Repository annotation to indicate that the class provides the mechanism for storage,
//retrieval, update, delete and search operation on objects.
public class EmployeeDAOHibernateimpl implements EmployeeDAO {
	
	
	//define field for entitymanager
	
	private EntityManager entityManager;
	//set up constructor injection

	
	@Autowired //ENtityManager is automaticially created by spingboot we can inject here using constructor injection
	public EmployeeDAOHibernateimpl(EntityManager theEntityManager) {
		
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		//get current hibernate session
		Session cr=entityManager.unwrap(Session.class);
		
		
		//create a query
		Query<Employee> theQuery=cr.createQuery("from Employee",Employee.class);
		
		//execute query
		List<Employee> employee=theQuery.getResultList();
		
		return employee; 
	}

	@Override
	public Employee findById(int id) {
		Session c1=entityManager.unwrap(Session.class);
		
		
		//get the employee
		Employee theEmployee=c1.get(Employee.class,id);
		
		//return the employee
		return theEmployee;
		
		
	}

	@Override
	public void save(Employee theEmployee) {
		
		
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		
		//save employee
		currentSession.saveOrUpdate(theEmployee);
		
		
	}

	@Override
	public void deleteById(int theId) {
	
		//get the current hbernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
