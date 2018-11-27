package com.example.demo.dao;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpDaoImplTest {

//	@Autowired
	@Resource(name="empDaoImpl")
	private EmpDao dao;
	
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		System.out.println(dao instanceof EmpDaoImpl);
		dao.findAll().forEach(System.out::println);
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSkipLimit() {
		int skip = 10;
		int limit = 10;
		List<Emp> emps = dao.findSkipLimit(skip, limit);
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testFindPageSize() {
		int page = 1;
		int size = 10;
		List<Emp> emps = dao.findPageSize(page, size);
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testFindStartEnd() {
		int start = 21;
		int end = 30;
		List<Emp> emps = dao.findStartEnd(start, end);
		emps.forEach(System.out::println);
	}
	
}
