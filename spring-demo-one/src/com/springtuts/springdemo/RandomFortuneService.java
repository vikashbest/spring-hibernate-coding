package com.springtuts.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {"Fortune 1", "Fortune 2", "Fortune 3"};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(fortunes.length);
		return fortunes[index];
	}

}
