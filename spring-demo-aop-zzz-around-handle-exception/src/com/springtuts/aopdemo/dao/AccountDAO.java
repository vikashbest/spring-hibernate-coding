package com.springtuts.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springtuts.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	// add a new method: finAccounts()
	public List<Account> findAccounts(boolean tripWire){
		
		// for academic purpose ... simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for you !!");
		}
		List<Account> myAccounts = new ArrayList<Account>();
		
		// create sample accounts
		Account account1 = new Account("John", "Gold");
		Account account2 = new Account("Logan", "Platinum");
		Account account3 = new Account("Abhishek", "Silver");
		
		// add them to our accounts list
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		
		return myAccounts;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT\n");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": doWork()\n");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
