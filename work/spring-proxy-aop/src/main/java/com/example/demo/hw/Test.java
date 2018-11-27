package com.example.demo.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("car-xml.xml");

		/*
		 * 1. XML 도 해보고 2. 애노테이션으로도 해보고
		 */

		// 일반 차는 안전벨트 체크 기능이 없습니다. 즉, 어드바이스를 적용하지 않습니다.
		Car car = context.getBean("car", Car.class);
		car.start();
		car.stop();

		// 고급 차는 안전벨트 체크 기능이 있습니다. 즉, 어드바이스를 적용하세요.
		Car luxuryCar = context.getBean("luxuryCar", Car.class);
		// 안전 벨트를 착용했으면 "Engine is running..."
		// 안전 벨트를 착용하지 않았으면 "딩동~! 안전벨트를 착용하세요!"

		for (int i = 0; i < 3; i++) {
			try {
				luxuryCar.start();
			} catch (Exception e) {
			}
			luxuryCar.stop();
		}
	}

}
