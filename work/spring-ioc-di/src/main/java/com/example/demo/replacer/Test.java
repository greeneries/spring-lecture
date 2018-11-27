package com.example.demo.replacer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("method-replace-magic.xml");
		
		// 빈 컨테이너에 자료형이 매지션 인걸 달라
		Magician magician = context.getBean(Magician.class);
		magician.show();
	}
}
