package com.example.demo.ioc.review.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpConfig {
	@Bean
	public Employee designer() {
		Employee worker = new Designer();
		return worker;
	}

	@Bean
	public Employee programmer() {
		Employee worker = new Programmer();
		return worker;
	}

	@Bean
	public TeamManager manager1() {
		TeamManager manager = new TeamManager();
		manager.setWorker(designer());
		return manager;
	}
	@Bean
	public TeamManager manager2() {
		TeamManager manager = new TeamManager();
		manager.setWorker(programmer());
		return manager;
	}
}
