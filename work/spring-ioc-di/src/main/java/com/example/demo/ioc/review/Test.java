package com.example.demo.ioc.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {
	
	@Autowired
	private List<Employee> emps;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("manager-config.xml");
		
		
		TeamManager manager1 = context.getBean("manager1", TeamManager.class);
		
		TeamManager manager2 = context.getBean("manager2", TeamManager.class); 
		
		Test test = context.getBean("test", Test.class); 
		
		manager1.order();
		manager2.order();
		
		test.emps.forEach(System.out::println);
	}
}
