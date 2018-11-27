package com.example.demo.hw;

import java.lang.reflect.Method;
import java.util.Random;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class SafetyBeltCheckAdvice implements MethodBeforeAdvice{
	// 자동차에 start 메소드가 호출되면 안전벨트 착용여부를 확인하여
	// 착용했으면 엔진을 기동시키고 착용하지 않았으면 경고음을 들려줍니다.
	
	
	// 인터셉트해서 체크메소드로 판단하자
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if(!(SafetyBeltCheckSensor.check())) {
			System.out.println("딩동~! 안전벨트를 착용하세요!");
			throw new Throwable();			
		}
	}
}

class SafetyBeltCheckSensor {
	
	static Random rnd = new Random();
	
	public static boolean check() {
		// 파라미터가 범위임 => 0, 1)
		if(rnd.nextInt(2) == 0) {
			return true;
		}
		return false;
	}
}