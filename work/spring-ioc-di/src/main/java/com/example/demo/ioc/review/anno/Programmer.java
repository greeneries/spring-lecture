package com.example.demo.ioc.review.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

@Order(3)
@Component
@Data
public class Programmer implements Employee {
	@Override
	public void work() {
		System.out.println("UI화면을 갱신한다.");
	}
}
