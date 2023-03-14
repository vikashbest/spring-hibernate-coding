package com.springtuts.springdemo.service;

import java.util.List;

import com.springtuts.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(int theSortField);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

}
