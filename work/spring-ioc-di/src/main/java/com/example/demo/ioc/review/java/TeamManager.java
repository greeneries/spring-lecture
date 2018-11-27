package com.example.demo.ioc.review.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * TeamManager use Employee.
 * TeamManager has Employee.
 * TeamManager depends Employee.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamManager {
//	private Employee worker = new Programmer();
//	private Employee worker = new Designer();

//	@Resource(name="programmer")
	private Employee worker;
	

	public void order() {
		System.out.println("TeamManager가 " + worker.getClass().getSimpleName() + "에게 일을 시킨다.");
		worker.work();
	}

	

}
