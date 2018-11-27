package com.example.demo.qualifier;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Service3 implements TheService {

	@Override
	public void TheService() {
		System.out.println("3번");
	}
}
