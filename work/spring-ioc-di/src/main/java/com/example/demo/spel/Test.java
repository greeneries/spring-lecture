package com.example.demo.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("etc-config.xml");
		User user = context.getBean("user", User.class);
		System.out.println(user);
		
		Member member = context.getBean("member", Member.class);
		System.out.println(member);
		
		Person person = context.getBean("person", Person.class);
		System.out.println(person);
	}
}