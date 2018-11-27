package com.example.demo.ioc.review.anno;

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
		
		ApplicationContext context = new ClassPathXmlApplicationContext("manager-config-anno.xml");
		
		TeamManager manager1 = (TeamManager) context.getBean("manager1");
		TeamManager manager2 = (TeamManager) context.getBean("manager2");
		
		manager1.order();
		manager2.order();
		
		Test test = context.getBean("test", Test.class);
		
		// @Order() 로 순서를 정할 수 있다.
		test.emps.forEach(System.out::println);
	}
}
