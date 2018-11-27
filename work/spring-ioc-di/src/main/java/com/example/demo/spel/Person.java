package com.example.demo.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

//@PropertySource 대신 xml에서 쓸때
//<context:property-placeholder location="my.properties"/>

// 이 파일 이름에서 소스를 가져오겠다. 키밸류값으로 가져와서 프로퍼티스 객체로 만들어줌
@PropertySource(value = { "my.properties" })
@Component
@Data
public class Person {
	@Value("#{member.name}")
	private String name;
	
	@Value("#{member.age}")
	private int age;
	
	// #은 빈에서 가져올때, $은 프로퍼티 소스 가져올때 씀
	// 이 키 값을 찾아서 변수에 넣어라 (그 키의 밸류)
	// :null => car.default.name 이 키로 찾았는데 값이 없으면 null을 할당
	@Value("${car.default.name:null}")
	private String carName;
	
	@Value("${car.default.doors:0}")
	private int carDoors;
	
	// Run As > Run Configuration > VM arguments > -Duser.region=KR
	// 실제로 쓸때 : java -jar 빌드결과.jar -Duser.region=KR
	@Value("#{systemProperties['user.region'] == null ? 'US' : systemProperties['user.region']}")
	private String defaultLocale;
}
