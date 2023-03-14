package com.springtuts.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are same
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to same objects: "+result);
		
		System.out.println("\nMemory location for theCoach: "+theCoach);
		
		System.out.println("\nMemory location for alphaCoach: "+alphaCoach);
		
		// close the context
		context.close();
		
	}

}
