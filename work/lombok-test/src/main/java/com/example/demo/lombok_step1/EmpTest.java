package com.example.demo.lombok_step1;

public class EmpTest {
	public static void main(String[] args) {
		Emp emp = new Emp(10, "Jonh", "Developer");
		
		System.out.println(emp.getEname());
		System.out.println(emp.toString());
		System.out.println(emp);
	}
}
