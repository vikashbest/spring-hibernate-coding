package com.springtuts.hibernate.practice;

import java.util.List;
import java.util.Scanner;

import com.springtuts.hibernate.practice.entity.Employee;

public class EmployeeApp {
	
	public static Scanner sc = new Scanner(System.in);
	public static final EmployeeService employeeService = new EmployeeServiceImpl();
	
	public static void main(String[] args) {
		
		
		int choice = 0;
		do {
			try {
				displayMenuOptions();
				choice = sc.nextInt();
			}catch(Exception e) {
				System.out.println("Invalid Input !!");
			}
			sc.nextLine();
			switch(choice) {
				case 1: addAnEmployee();
						break;
				case 2: searchEmployeeById();
						break;
				case 3: updateEmployeeById();
						break;
				case 4: searchEmployeesByCompanyName();
						break;
				case 5: deleteAnEmployee();
						break;
				case 6:	showAllEmployees();
						break;
				case 7: System.out.println("============== Thank You ==============");
						break;
				default: System.out.println("Invalid option! Enter a choice from 1 - 7");
			}
		}while(choice != 7);
		
	}

	private static void showAllEmployees() {
		System.out.println("\nList of all Employees: ");
		List<Employee> employees = employeeService.showAllEmployees();
		if(!employees.isEmpty()) {
			for(Employee employee: employees) {
				System.out.println(employee);
			}
		}else {
			System.out.println("\nNo Employee Found !!");
		}
	}

	private static void deleteAnEmployee() {
		
		System.out.print("Enter Employee Id: ");
		int employeeId = sc.nextInt();
		sc.nextLine();
		
		int result = employeeService.deleteAnEmployee(employeeId);
		if(result == 1) {
			System.out.println("\nEmployee deleted with Id: "+employeeId);
		}else {
			System.out.println("\nFailed to delete Employee with id: "+employeeId);
		}
		
	}

	private static void searchEmployeesByCompanyName() {
		System.out.print("Enter Company Name: ");
		String company = sc.nextLine();
		List<Employee> employees = employeeService.searchEmployeesByCompanyName(company);
		if(!employees.isEmpty()) {
			for(Employee employee: employees) {
				System.out.println(employee);
			}
		}else {
			System.out.println("No Employee found from Company: "+company);
		}
	}

	private static void updateEmployeeById() {
		System.out.print("\nEnter Employee Id: ");
		int employeeId = sc.nextInt();
		sc.nextLine();
		
		employeeService.updateEmployeeById(employeeId);
	}

	private static void searchEmployeeById() {
		System.out.print("\nEnter Employee Id: ");
		int employeeId = sc.nextInt();
		sc.nextLine();
		Employee employee = employeeService.searchEmployeeById(employeeId);
		if(null != employee) {
			System.out.println("\nEmployee Found: "+employee);
		}else {
			System.out.println("\nEmployee with Id: "+employeeId+" NOT found !!");
		}
	}

	private static void addAnEmployee() {
		System.out.print("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();
		System.out.print("Enter Company Name: ");
		String company = sc.nextLine();
		Employee employee = new Employee(firstName, lastName, company);
		employeeService.addAnEmployee(employee);
	}

	private static void displayMenuOptions() {

		System.out.println("==================== Employee Management System ====================");
		System.out.println("1. Add an Employee\n2. Search an Employee by Id\n3. Update an Employee by Id\n4. Search Employee by Company Name\n5. Delete an Employee"
							+"\n6. Show all Employees\n7. Exit");
		System.out.print("Select a number from the below options: ");
	}

}
