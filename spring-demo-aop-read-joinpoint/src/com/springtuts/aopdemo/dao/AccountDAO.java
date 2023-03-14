package com.springtuts.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.springtuts.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

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
