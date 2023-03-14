package com.springtuts.springdemo;

public class ExcitedFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Wohoo Today is an exciting day!";
	}

}
