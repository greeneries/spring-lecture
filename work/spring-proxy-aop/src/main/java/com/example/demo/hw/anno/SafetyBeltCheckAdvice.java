package com.example.demo.hw.anno;

import java.util.Random;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SafetyBeltCheckAdvice {

	@Pointcut("execution(* start(..)) && bean(luxuryCar)")
	public void pointcut() {
	}

	@Around("pointcut()")
	public void myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (!(SafetyBeltCheckSensor.check())) {
			System.out.println("딩동~! 안전벨트를 착용하세요!");
		} else {
			joinPoint.proceed();
		}			
	}
}

class SafetyBeltCheckSensor {

	static Random rnd = new Random();

	public static boolean check() {
		if (rnd.nextInt(2) == 0) {
			return true;
		}
		return false;
	}
}