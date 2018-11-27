package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Emp;
import com.example.demo.service.EmpService;

//@RequestMapping("/emps")
@RestController
public class EmpRestController {
	
	@Autowired
	private EmpService empService;
	
	/*
	 * JavaScript ~~HTTP~~ Controller
	 * 
	 * HTTP 요청방식
	 * 1. GET ==> Select 쿼리
	 * 2. POST ==> Insert 쿼리
	 * 3. PUT(PATCH) : 로우 전체를 변경하면 PUT, 로우의 일부분을 변경하면 PATCH ==> Update 쿼리
	 * 4. DELETE ==> Delete 쿼리
	 * 5. OPTIONS : 어떤 요청방식을 제공하는가 결정, 환경설정으로 처리
	 */
	
	// 1. GET ==> Select 쿼리
	@RequestMapping(value="/emps", method=RequestMethod.GET)
	public Object getAll() {
		List<Emp> emps = empService.findAll();
		return emps;
	}
	// {id} : URI 문자열 부분은 가변적이어도 연동이 된다.
	@RequestMapping(value="/emps/{id}", method=RequestMethod.GET)
	public Object getOne(@PathVariable("id") int empno) {
		Emp emp = empService.findOne(empno);
		return emp;
	}
	
	// 2. POST ==> Insert 쿼리
	// @RequestBody : 클라이언트가 HTML Form이 아닌 JSON 포멧의 문자열로 데이터를 보낼 때 이를 스프링이 처리하도록 요청한다.
	@RequestMapping(value="/emps", method=RequestMethod.POST)
	public Object postOne(@RequestBody Map<String, Object> map) {
		// 클라이언트가 보내는 파라미터 데이터가 스프링에 의해서 map 객체에 추가된다.
		Emp emp = new Emp();
		emp.setEname((String)map.get("ename"));
		emp.setJob((String)map.get("job"));
		emp.setSal((Integer)map.get("sal"));
		
		int affected = empService.insert(emp);
		return emp;
	}
	
	// 3. PUT ==> Update 쿼리
	@RequestMapping(value="/emps/{id}", method=RequestMethod.PUT)
	public Object putOne(@PathVariable("id") int empno, @RequestBody Map<String, Object> map) {
		// PUT 방식은 해당 로우를 전체적으로 수정하는 것이므로 클라이언트가 수정하지 않는 기존 데이터도 보내주어야 한다.
		Emp emp = new Emp();
		emp.setEmpno(empno);
		emp.setEname((String)map.get("ename"));
		emp.setJob((String)map.get("job"));
		emp.setSal((Integer)map.get("sal"));
		
		int affected = empService.update(emp);
		return emp;
	}
	
	// 4. DELETE ==> Delete 쿼리
	@RequestMapping(value="/emps/{id}", method=RequestMethod.DELETE)
	public Object deleteOne(@PathVariable("id") int empno) {
		int affected = empService.delete(empno);
		
		// 삭제된 로우는 존재하지 않으므로 삭제작업이 성공했다는 의미만 전달한다.
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
