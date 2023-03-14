package com.springtuts.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeJavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeSportConfig.class);
		
		Coach theCoach = context.getBean("wrestlingCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
	}

}
