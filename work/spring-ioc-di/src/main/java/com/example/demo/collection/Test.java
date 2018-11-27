package com.example.demo.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/example/demo/collection/collection-config.xml");
		
		// 자료형으로 찾기
		Example example = context.getBean(Example.class);
		example.getList().forEach(System.out::println); // 더블콜론연산자 레퍼런스 메소드
		
		System.out.println();
		
		example.getMap().forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});
		
		System.out.println();
		
		example.getProp().forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});
		
		System.out.println();
		
		example.getSet().forEach(System.out::println);
	}

}
