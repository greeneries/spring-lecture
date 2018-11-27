package com.example.demo.scope;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {
	@Autowired
	private List<Car> cars;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("scope-test.xml");
		
		Car car = context.getBean("car1", Car.class);
		System.out.println(car);
		
		Car car2 = context.getBean("car2", Car.class);
		System.out.println(car2);

		// Singleton : 컨테이너 안에 해당 객체는 한개만 존재한다.
		System.out.println(car == car2); // true, scope="prototype" 일때 false		
		
		Test test = (Test)context.getBean("test", Test.class);
		System.out.println(test.cars.size());
		test.cars.forEach(System.out::println);
	}
}
