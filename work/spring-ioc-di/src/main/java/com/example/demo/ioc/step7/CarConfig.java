package com.example.demo.ioc.step7;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// 이 클래스는 빈 설정정보를 갖고 있으니 처리하라고 요청한다.
@Configuration
public class CarConfig {
	
//	CarMaker maker = new KiaMaker();
//	CarMaker maker = new HyundaiMaker();
//	
//	OrderManager manager = new OrderManager();
//	manager.setMaker(maker);
	
	// 위는 개발자가 직접, 밑은 스프링이 대신 하는 것
	
	// 메소드명을 id로 삼고 메소드가 리턴하는 객체를 빈 컨테이너에 등록하라.	
	@Bean
	@Primary
	public CarMaker kiaMaker() {
		CarMaker maker = new KiaMaker();
		return maker;
	}
	@Bean(name="hyundaiMaker") // 생략가능
	public CarMaker hyundaiMaker() {
		CarMaker maker = new HyundaiMaker();
		return maker;
	}
	@Bean
	public OrderManager manager(
//			@Qualifier("hyundaiMaker") 
			CarMaker maker) {
		OrderManager manager = new OrderManager();
		manager.setMaker(maker);
		return manager;
	}
}
