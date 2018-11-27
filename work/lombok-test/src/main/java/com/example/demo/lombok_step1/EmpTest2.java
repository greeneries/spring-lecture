package com.example.demo.lombok_step1;

public class EmpTest2 {
	public static void main(String[] args) {
		Emp emp = new Emp(10, "Jonh", "Developer");
		Emp emp2 = emp;
		
		System.out.println(emp == emp2); // 동일 비교 : true, emp2도 결국 emp객체를 가리키고있다.
		
		Emp emp3 = new Emp(10, "Jonh", "Developer");

		System.out.println(emp == emp3); // 동일 비교 : false, 다른 객체다.
		
		// 객체는 참조가 다르면 다르다고 판단해야 합니다.
		// 하지만, 때때로 객체가 별도로 각각 존재하더라도 객체의 상태값이 같은 경우
		// 같다고 판단해야 할 때가 있습니다.
		
		// 예:
		// 브라우저가 id/pw 정보를 전달합니다.
		// 디비가 id/pw 정보를 전달합니다.
		// 개발자는 로그인 처리를 위해서 두 객체가 가진 정보를 비교하여 같으면 true 로 처리해야 합니다.
		// 두 객체는 참조는 다르지만 값은 같고, 이 경우 true로 판단해야 합니다.
		// 이럴때, 클래스의 equals 메소드를 재정의해서 사용합니다.
		// equals 메소드를 재정의 하지 않으면 기본적으로 == 비교연산자와 동일하게 행동합니다.
		
		System.out.println(emp.equals(emp3));
	}
}
