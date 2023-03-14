package com.springtuts.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SpringtutsAopExpressions {
	
	@Pointcut("execution(* com.springtuts.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.springtuts.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.springtuts.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
