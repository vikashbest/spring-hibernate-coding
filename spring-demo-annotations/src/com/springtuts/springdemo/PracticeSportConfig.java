package com.springtuts.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {

	@Bean
	public FortuneService excitedFortuneService() {
		return new ExcitedFortuneService();
	}
	
	@Bean
	public Coach wrestlingCoach() {
		return new WrestlingCoach(excitedFortuneService());
	}
	
	
}
