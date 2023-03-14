package com.springtuts.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springtuts.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.springtuts.aopdemo.aspect.SpringtutsAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("=====>>> Executing @Before advice on method()");
		
		//display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+methodSign);
		
		// display the method arguments
		
		// get the args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg: args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account)tempArg;
				System.out.println("account name: "+theAccount.getName());
				System.out.println("account level: "+theAccount.getLevel());
			}
		}
		
	}
}
