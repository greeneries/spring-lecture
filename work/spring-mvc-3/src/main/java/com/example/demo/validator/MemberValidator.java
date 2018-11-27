package com.example.demo.validator;

import java.lang.reflect.Member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {
	// 데이터를 갖고 있는 객체와
	// 데이터의 유효성을 체크하여 에러정보를 갖고 있는 객체를 연결한다.
	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	// Member member, BindingResult result
	// valid.validate(member, result);
	@Override
	public void validate(
			Object target, // 사용자가 작성한 데이터를 보관하는 객체
			Errors errors) { // 데이터를 검증한 결과(에러정보)를 보관하는 객체
		
		// ValidationUtils.rejectIfEmptyOrWhitespace(
		// errors, "name", "required.name", "이름이 필요합니다.");
		
		// xxx.properties 파일안에 required.address = address 항목이 빈 문자열입니다.. 만들어놓으면 출력됨.
		// 그게 없으면 뒤에 스트링을 출력.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "주소가 필요합니다.");
		// target객체의 address가 EmptyOrWhitespace면 "주소가 필요합니다"를 errors 객체에 추가해라
		
		 Member member = (Member) target;
		// System.out.println("-----------------------");
		// System.out.println(member);
		// System.out.println("=======================");
	}
}
