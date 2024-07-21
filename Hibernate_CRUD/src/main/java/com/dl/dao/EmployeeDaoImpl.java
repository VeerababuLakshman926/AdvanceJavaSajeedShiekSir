package com.dl.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private SessionFactory sessionFactory;
	
	public EmployeeDaoImpl() {
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Employee findById(Long id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id);
		session.close();
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		//session.save(employee); --> deprecated
		session.persist(employee);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//session.update(employee); --> deprecated
		session.merge(employee);
		tx.commit();
		session.close();
	
		
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Employee employee = session.get(Employee.class, id);
		
		if(employee != null) {
			//session.delete(employee); --> deprecated
			session.remove(employee);
			tx.commit();
			System.out.println("Employee Deleted successfully");
		} else {
			System.out.println("No data found based on the Id provided");
			
		}
		
		session.close();
	}

}
