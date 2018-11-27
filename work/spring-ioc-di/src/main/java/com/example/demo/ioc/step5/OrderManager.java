package com.example.demo.ioc.step5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.Data;

/*
 * 축구에서 공격수, 수비수, 골키퍼로 나누듯이
 * 웹 프로그램을 컨트롤러, 서비스, 리파지토리로 나누어 관리합니다.
 * 이는 역할에 따라서 구분하면 관리성이 증대되기 때문인데
 * 클래스를 빈 컨테이너에 등록할 때, 역할에 따라 @Component를 상속한
 * @Service 애노테이션을 대신 사용하는 이유가 됩니다.
 */
@Service("manager")
public class OrderManager {
	
	// 컨테이너에서 자료형이 CarMaker인 객체를 직접 변수에 할당하라. 
	@Autowired
	// 후보가 여럿일때 @Qualifier로 제한해 줄 수 있다.
	@Qualifier("kiaMaker")
	CarMaker maker;
	
	// 스프링 프레임워크는 클래스에 디폴트 생성자가 있을때 디폴트 생성자를 우선으로 객체를 생성한다.
	public OrderManager() {
	}
	
	/*
	 * expected single matching bean but found 2: hyundaiMaker, kiaMaker
	 */
		
	public OrderManager(@Qualifier("kiaMaker") CarMaker maker) {
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
	
	public CarMaker getMaker() {
		return maker;
	}

	// 빈 컨테이너에서 id가 hyundaiMaker인 객체를 파라미터로 주입하라.
//	@Resource(name="hyundaiMaker")
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}		
}
