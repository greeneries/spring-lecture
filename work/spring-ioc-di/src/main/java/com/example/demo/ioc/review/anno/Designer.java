package com.example.demo.ioc.review.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

@Order(1)
@Component
@Data
public class Designer implements Employee {
	@Override
	public void work() {
		System.out.println("디자인한다");
	}
}
