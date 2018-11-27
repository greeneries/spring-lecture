package com.example.demo.ioc.step4;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
public class OrderManager {
	
	CarMaker maker;
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
	}

	public void order() {
		System.out.println("OrderManager: #order() called");

		Money money = new Money(2000);
		System.out.println("OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager: " + car.getName() + "을/를 얻는다.");
	}

	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}		
}
