package com.springtuts.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
		
	}

}
