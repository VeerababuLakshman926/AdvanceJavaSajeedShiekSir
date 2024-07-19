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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee employee) {
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		//session.save(employee);
		session.persist(employee);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//session.update(employee);
		session.merge(employee);
		tx.commit();
		session.close();
	
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
