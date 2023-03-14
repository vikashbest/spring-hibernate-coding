package com.springtuts.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice Spin bowling for 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
