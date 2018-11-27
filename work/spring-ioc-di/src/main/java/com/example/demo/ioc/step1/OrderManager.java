package com.example.demo.ioc.step1;

public class OrderManager {
	
	// 로직(메소드)을 제공하는 클래스는 가능한 한 재 사용하려고 노력한다.
	HyundaiMaker maker = new HyundaiMaker();
	
	public void order() {
		System.out.println("OrderManager: #order()");

		// 상태정보를 취급하는 클래스는 메소드내에 만들어서 사용하고 버린다.
		Money money = new Money(2000);
		System.out.println("OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager: " + car.getName() + "을/를 얻는다.");

	}
}
