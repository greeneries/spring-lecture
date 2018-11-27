package com.example.demo.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import lombok.Data;

@Data
public class Example {
	private Set<Object> set;
	
	// 키:밸류
	private Map<String, Object> map;
	
	private List<Object> list;
	
	// 주로 환경설정들을 (string)키 : (string)밸류 형태로 저장하는 객체
	private Properties prop;
}
