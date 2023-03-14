package com.springtuts.hibernate.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springtuts.hibernate.practice.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class).buildSessionFactory();
	private static Scanner sc = new Scanner(System.in);
	
	@Override
	public void addAnEmployee(Employee employee) {
		try {
			// create a session
			Session session = factory.getCurrentSession();
			
			// start the transaction
			session.beginTransaction();
			
			// save the employee
			System.out.println("Adding Employee: "+employee);
			session.save(employee);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Employee Added Successfully !!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee searchEmployeeById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("Searching Employee By Id: "+id);
		Employee employee = session.get(Employee.class, id);
		
		session.getTransaction().commit();
		
		return employee;
	}

	@Override
	public void updateEmployeeById(int id) {

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, id);
			if(null != employee) {
				System.out.print("Enter First Name: ");
				employee.setFirstName(sc.nextLine());
				System.out.print("Enter Last Name: ");
				employee.setLastName(sc.nextLine());
				System.out.print("Enter Company Name: ");
				employee.setCompany(sc.nextLine());
				
				System.out.println("\nUpdating Employee: "+employee);
				session.getTransaction().commit();
				
				System.out.println("\nEmployee Details Updated !!");
			}else {
				System.out.println("\nEmployee with Id: "+id+" NOT found !!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> searchEmployeesByCompanyName(String company) {

		List<Employee> employees = new ArrayList<Employee>();
		try {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Fetching Employees from company: "+company);
			employees = session.createQuery("from Employee e where e.company='"+company+"'").getResultList();
			
			session.getTransaction().commit();
			return employees;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int deleteAnEmployee(int id) {
		int result = 0;
		try {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, id);
			if(null != employee) {
				System.out.println("\nDeleting Employee: "+employee);
				result = session.createQuery("delete from Employee e where e.id="+id).executeUpdate();
				
				session.getTransaction().commit();
			}else {
				System.out.println("\nEmployee with Id: "+id+" NOT found !!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Employee> showAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			employees = session.createQuery("from Employee").getResultList();
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employees;
	}

}
