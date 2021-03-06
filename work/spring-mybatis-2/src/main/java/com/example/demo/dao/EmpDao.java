package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Emp;



public interface EmpDao {
	
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);

	public List<Emp> findAll();
	
	public int count();
	
	public Emp findOne(int empno);
	
	/*
	 * 테이블의 특정 범위의 로우들만을 조회하고 싶다.
	 * 
	 * 전제: 정렬은 이미 되어 있다.
	 * 거의 대부분의 디비는 PK의 오름차순으로 정렬한 상태로 데이터를 유지한다.
	 */
	
	// start: empno의 시작 값, end: empno의 종료 값
	public List<Emp> findStartEnd(int start, int end);
	
	// skip: 앞에서부터 얼마나 스킵할 것인지에 대한 값, limit: 구하는 로우의 개수
	public List<Emp> findSkipLimit(int skip, int limit);
	
	// page: ceil(전체 로우의 수/size) 후 구해지는 페이지 번호, size: 구하는 로우의 개수
	/*
	 * 전체 로우의 개수 = 21
	 * size = 10
	 * ceil(21/10) = 3
	 */
	public List<Emp> findPageSize(int page, int size);
	
	// ename, job, sal 칼럼으로 검색하는 기능의 메소드를 제공하고 싶다.
	// SELECT * FROM EMP where ename like '%길동%'
	// SELECT * FROM EMP where job like '%적%'
	// SELECT * FROM EMP where sal>=800 and sal<=900
	// SELECT * FROM EMP where sal>=800 
	// SELECT * FROM EMP where sal>=800 
	
	public List<Emp> search(Map<String, String> map);
	
	
}
