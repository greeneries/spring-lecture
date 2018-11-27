package com.example.demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Qualifier("myService")
@Order(1)
@Data
public class Service2 implements TheService {

	@Override
	public void TheService() {
		System.out.println("2번");
	}
}
