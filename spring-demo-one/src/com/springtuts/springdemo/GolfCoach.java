package com.springtuts.springdemo;

public class GolfCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Practice 2 hours Golf daily";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
