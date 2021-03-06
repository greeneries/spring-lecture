package com.example.demo.aop.xml.step5;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect // 이 클래스가 AOP 설정정보를 갖고 있다고 알려준다.
public class MyAspect 
{
	@Pointcut("execution(int *(..))")
	public void pointcut() {}
/*
	<aop:config proxy-target-class="true">
		<aop:pointcut expression="execution(int *(..))" id="pointcut" />
	
		<aop:aspect ref="myAspect">
			<aop:before method="myBefore" pointcut-ref="pointcut"/>
			<aop:around method="myAround" pointcut-ref="pointcut"/>
			<aop:after-returning method="myAfterReturning" pointcut-ref="pointcut"/>
			<aop:after-throwing method="myAfterThrowing" pointcut-ref="pointcut"/>
			<aop:after method="myAfter" pointcut-ref="pointcut"/>
		</aop:aspect>
	
	</aop:config>
*/
	
	@Before("pointcut()")
	public void myBefore(JoinPoint joinPoint) throws Throwable {
		System.out.println("-----Before----");
	}

	@Around("pointcut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-----Around Before Advice-----");

		Object[] args = joinPoint.getArgs();
		if(args != null && args.length > 0) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Arrays.asList(args).forEach(System.out::println);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
		Object ret = joinPoint.proceed();

		System.out.println("=====Around After Advice======");

		ret = (Integer)ret + 100;
		
		return ret;
	}
	
	@Pointcut("execution(* two())")
	public void xxx() {}
	
	@AfterReturning("xxx()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.println("*****AfterReturning*****");
	}
	@AfterThrowing("xxx()")
	public void myAfterThrowing(JoinPoint joinPoint) {
		System.out.println("*****AfterThrowing*****");
	}
	@After("execution(* two()) || execution(* one2())")
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("*****After*****");
	}
}

