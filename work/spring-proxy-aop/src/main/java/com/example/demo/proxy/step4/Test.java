package com.example.demo.proxy.step4;

public class Test {
	// 프록시:
	

	public static void main(String[] args) {
		Hello hello = new Hello();

		// 팬(클라이언트) ==> 가수(타겟)
		hello.say();

		System.out.println();

		Hello proxy = new Proxy();

		// 팬(클라이언트) ==> 매니저(프록시) ==> 가수(타겟)
		proxy.say();
	}

}
