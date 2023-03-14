package com.springtuts.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springtuts.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// save/update the customer ... finally LOL
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// delete the object with primary key
		Query query = session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", theId);
		
		query.executeUpdate();
	}

}
