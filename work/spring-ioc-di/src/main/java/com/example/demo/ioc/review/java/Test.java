package com.example.demo.ioc.review.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("car-config-anno2.xml");
//		ApplicationContext context = new ClassPathXmlApplicationContext("manager-config.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);
		
		TeamManager manager1 = (TeamManager) context.getBean("manager1");
		
		TeamManager manager2 = (TeamManager) context.getBean("manager2"); 
		
		manager1.order();
		manager2.order();
	}
}
