package com.example.demo.lombok_step1;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor // 생성자 알아서 만들어라, 컴파일하기 직전에
public class User {
	@NonNull int id;
	@NonNull String name;
	String email;
		
//	public User(int id, String name, String email) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//	}
	
//	public User(int id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
}
