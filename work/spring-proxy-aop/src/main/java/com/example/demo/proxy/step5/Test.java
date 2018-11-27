package com.example.demo.proxy.step5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
	// 스프링이
	// 1. Hello 객체를 DI 하면 클라이언트는 직접 타겟 메소드를 사용한다.
	// 2. Proxy 객체를 DI 하면 클리이언트는 프록시 메소드를 사용한다.
	// 프록시 대신 타겟 메소드를 호출한다.
	@Autowired
	private Hello h;
	
	public void order() {
		h.say();
	}
	
	public static void main(String[] args) {
		Hello hello = new Hello();

		hello.say();

		System.out.println();

//		Hello proxy = new Proxy();
//		proxy.say();
		
		Advice advice = new MyAdvice(); 
		
		// CGLIB Dynamic Proxy
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(hello);
		factory.addAdvice(advice);
		
		// 프록시객체가 타겟객체와 같은 자료형으로 업캐스팅이 가능해야 빈 컨테이너에 등록해서 받아쓸때 
		// 코드를 수정하지않고 취사선택이 가능해 진다
		Hello proxy = (Hello) factory.getProxy();
		proxy.say();
		
		// 스프링은 전역적으로 프록시 객체를 만들어주는 AOP 서비스를 제공한다.
		// 부가로직을 재사용하여 다수의 클래스를 프록싱하는 객체를 만들어야 하므로
		// 부가로직을 갖고 있는 어드바이스 클래스는 특정 클래스에 종속 되면 안된다.
	}

}
