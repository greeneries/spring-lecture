package com.example.demo.scope;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

// 자료형이 같은 객체 다수가 빈 컨테이너에 존재할 때, 처리순서를 지정한다. 낮은 숫자가 먼저 처리된다.
@Component("car2")
@Scope("prototype")
@Data
public class Car {
	private String name;
	private String maker;

	public Car() {
//		this.name = "K9";
//		this.maker = "Kia";
	}

	// 객체가 생성된 후 별도의 초기화 작업을 위해 실행하는 메소드를 선언한다.
	@PostConstruct
	public void init() {
		if (name == null || maker == null) {
			this.name = "K9";
			this.maker = "Kia";
		}
	}
}
