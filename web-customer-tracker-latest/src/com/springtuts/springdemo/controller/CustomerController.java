package com.springtuts.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springtuts.springdemo.entity.Customer;
import com.springtuts.springdemo.service.CustomerService;
import com.springtuts.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model, @RequestParam(required = false) String sort) {

		// get the customers from the service
		List<Customer> customersList = null;
		
		// check for sort field 
		if(sort != null) {
			int theSortField = Integer.parseInt(sort);
			customersList = customerService.getCustomers(theSortField);
		}else {
			// no sort field provided ... default to sorting by last name
			customersList =  customerService.getCustomers(SortUtils.LAST_NAME);
		}

		// add the customers to the model
		model.addAttribute("customers", customersList);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer using our service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		// delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model model) {

		// search customers from the service
		List<Customer> customers = customerService.searchCustomers(theSearchName);
		
		// add the customers to the model
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
}
