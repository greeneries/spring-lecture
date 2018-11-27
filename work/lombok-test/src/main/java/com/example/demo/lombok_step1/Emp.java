package com.example.demo.lombok_step1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@EqualsAndHashCode
//@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	private int empno;
	private String ename;
	private String job;
	
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Emp)) {
//			throw new RuntimeException("use Emp instance");
//		}
//		Emp that = (Emp) obj;
//		if (this.empno == that.empno) {
//			return true;
//		}
//		return false;
//	}
}
