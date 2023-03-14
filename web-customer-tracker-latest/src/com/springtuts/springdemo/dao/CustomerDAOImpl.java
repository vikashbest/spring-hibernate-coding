package com.springtuts.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springtuts.springdemo.entity.Customer;
import com.springtuts.springdemo.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int theSortField) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// determine the sort field
		String theFieldName = null;
		switch(theSortField) {
			case SortUtils.FIRST_NAME: theFieldName = "firstName";
										break;
			case SortUtils.LAST_NAME: theFieldName = "lastName";
										break;
			case SortUtils.EMAIL: theFieldName = "email";
										break;
			default: //If nothing matches the default to sort by lastName
						theFieldName = "lastName";
		}
		
		// create a query
		String queryString = "from Customer order by "+theFieldName;
		
		Query<Customer> query = session.createQuery(queryString, Customer.class);
		
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

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			
			// search for firstName or lastName ...  case insensitive
			query = session.createQuery("from Customer where lower(firstName) like :theName"+
											" or lower(lastName) like :theName", Customer.class);
			query.setParameter("theName", "%"+theSearchName.toLowerCase()+"%");
		}else {
			// theSearchName is empty ...  so just get all of the customers
			query = session.createQuery("from Customer", Customer.class);
		}
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return the results
		return customers;
	}

}
