package com.example.demo.ioc.step3;

public class OrderManager {
	
	// 비즈니스 환경에서 사용하는 프로그램은 변화의 요구가 극심합니다.
	// 현대자동차에게 주문하던 것을 기아자동차로 변경해야 하는 요구가 발생
//	HyundaiMaker maker = new HyundaiMaker();
//	KiaMaker maker = new KiaMaker();
	
	// 1. 인터페이스 도입 효과: 멤버변수 부분은 변경이 필요없게되었습니다.
	CarMaker maker;
	
	// new 할때는 그 설계도를 지칭해야만한다.
	public OrderManager() {
//		maker = new HyundaiMaker();
//		maker = new KiaMaker();
	}
	
	// OrderManager의 거래처가 변하더라도 OrderManager 클래스 내에 코드의 변경을 막는 방법
	// 1. 인터페이스 도입
	// 2. 객체관리를 클래스내에서 직접하지 않는다
	
	public void order() {
		System.out.println("OrderManager: #order() called");

		Money money = new Money(2000);
		System.out.println("OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager: " + car.getName() + "을/를 얻는다.");
	}

	// 1. 인터페이스 도입 효과: CarMaker 구현체는 뭐든지 받을 수 있다.
	public void setMaker(CarMaker maker) {
		// 2. 객체관리를 클래스내에서 직접하지 않는다.
		// OrderManager 가 사용하는 객체를 스스로 생성하지 않고 외부에서 주는대로 받아서 사용한다.
		this.maker = maker;
	}		
}
