package com.example.demo.ioc.review.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * TeamManager use Employee.
 * TeamManager has Employee.
 * TeamManager depends Employee.
 */

@Service("manager2")
public class TeamManager {
//	private Employee worker = new Programmer();
//	private Employee worker = new Designer();

//	@Resource(name="designer")
//	@Autowired
//	@Qualifier("designer")
	private Employee worker;
	
	@Autowired
	public TeamManager(@Qualifier("designer") Employee worker) {
		this.worker = worker;
	}
	
	public TeamManager() {
	}
	
	public void order() {
		System.out.println("TeamManager가 " + worker.getClass().getSimpleName() + "에게 일을 시킨다.");
		worker.work();
	}

	
//	@Resource(name="designer")
	public void setWorker(Employee worker) {
		this.worker = worker;
	}	
	
}
