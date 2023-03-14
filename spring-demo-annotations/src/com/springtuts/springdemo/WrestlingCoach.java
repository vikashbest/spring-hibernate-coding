package com.springtuts.springdemo;

public class WrestlingCoach implements Coach {

	private FortuneService fortuneService;
	
	public WrestlingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice wrestling for 30 mins daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
