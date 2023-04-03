package com.springtuts.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springtuts.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		// create employees
		Employee employee1 = new Employee(1, "Rahul", "Sharma", "rahul@hotmail.com");
		Employee employee2 = new Employee(1, "Krishna", "Yadav", "krishna@hotmail.com");
		Employee employee3 = new Employee(1, "Vicky", "Raj", "vicky@hotmail.com");
		Employee employee4 = new Employee(1, "Lakshmi", "Kumari", "lakshmi@gmail.com");
		Employee employee5 = new Employee(1, "Tanya", "Sharma", "tanya@hotmail.com");
		
		// create the list
		theEmployees = new ArrayList<>();
		
		// add to the list
		theEmployees.add(employee1);
		theEmployees.add(employee2);
		theEmployees.add(employee3);
		theEmployees.add(employee4);
		theEmployees.add(employee5);
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
		
	}
	
	
	
}
