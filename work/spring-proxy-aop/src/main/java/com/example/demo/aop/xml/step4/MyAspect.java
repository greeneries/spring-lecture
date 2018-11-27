package com.example.demo.aop.xml.step4;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

// Aspect :
// 공통적인 부가로직(횡단 관심사)을 어드바이스라고 하고 새로운 애스펙트(물리적으론 클래스)를 열어서 
// 다수의 어드바이스를 갖고 있는 것 
@Component
public class MyAspect 
//	implements MethodInterceptor, MethodBeforeAdvice 
// 인터페이스가 없으면 어떤놈을 언제쓰는지 판단할 수가 없음
{

//	@Override
	public void before(
//			Method method, Object[] args, Object target
			JoinPoint joinPoint
			) throws Throwable {
		System.out.println("-----Before----");
	}

//	@Override
	public Object invoke(
//			MethodInvocation invocation
			ProceedingJoinPoint joinPoint
			) throws Throwable {
		System.out.println("-----Around Before Advice-----");

		Object[] args = joinPoint.getArgs();
		if(args != null && args.length > 0) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Arrays.asList(args).forEach(System.out::println);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
//		Object ret = invocation.proceed();
		// 타겟 메소드의 호출여부를 결정할 수 있다.
		Object ret = joinPoint.proceed();

		System.out.println("=====Around After Advice======");

		// 타겟 메소드가 리턴한 결과를 조작할 수 있다.
		ret = (Integer)ret + 100;
		
		return ret;
	}
	
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.println("*****AfterReturning*****");
	}
	public void myAfterThrowing(JoinPoint joinPoint) {
		System.out.println("*****AfterThrowing*****");
	}
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("*****After*****");
	}
}

