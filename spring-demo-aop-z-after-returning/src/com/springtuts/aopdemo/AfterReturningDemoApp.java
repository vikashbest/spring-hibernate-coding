package com.springtuts.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springtuts.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = accountDAO.findAccounts();
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp\n-------------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		// close the context
		context.close();
		
	}

}
