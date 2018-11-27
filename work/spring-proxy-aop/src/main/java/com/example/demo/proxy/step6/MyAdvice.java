package com.example.demo.proxy.step6;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 다수의 메소드도 알아서 처리해줌 
		
		System.out.println("----Around Before Advice----");

		Object ret = invocation.proceed(); // Delegation	

		System.out.println("====Around After  Advice====");
		
		return null;
	}
}
