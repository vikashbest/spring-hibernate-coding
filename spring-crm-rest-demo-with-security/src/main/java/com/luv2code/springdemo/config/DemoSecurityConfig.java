package com.luv2code.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("akash").password("abc123").roles("EMPLOYEE"))
			.withUser(users.username("vijay").password("abc123").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("rashmi").password("abc123").roles("EMPLOYEE","ADMIN"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// secure all REST endpoints under "/api/customers"
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/customers").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.GET, "/api/customers/**").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole("ADMIN")
				.and()
				.httpBasic()
				.and().csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Note: The use of ** makes sure to secure endpoints if user enters additional information at the end of the URL.

	}

	
	
	
}
