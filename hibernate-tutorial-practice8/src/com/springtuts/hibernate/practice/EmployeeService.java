package com.springtuts.hibernate.practice;

import java.util.List;

import com.springtuts.hibernate.practice.entity.Employee;

public interface EmployeeService {

	public void addAnEmployee(Employee employee);
	
	public Employee searchEmployeeById(int id);
	
	public void updateEmployeeById(int id);
	
	public List<Employee> searchEmployeesByCompanyName(String company);
	
	public int  deleteAnEmployee(int id);
	
	public List<Employee> showAllEmployees();
	
}
