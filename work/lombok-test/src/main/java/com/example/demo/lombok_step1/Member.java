package com.example.demo.lombok_step1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/* Equivalent to 
 * 	@Getter 
 * 	@Setter 
 *  @RequiredArgsConstructor 
 *  @ToString 
 *  @EqualsAndHashCode. 
 * -> @Data는 저것들과 동일하다.
*/

@Data // 멤버변수에 private를 붙이면 걔네 게터세터 알아서 만들어라
@NoArgsConstructor // 파라미터를 안받는 생성자
//@RequiredArgsConstructor
@AllArgsConstructor
public class Member {
	@NonNull private int id;
	@NonNull private String name;
	private String email;
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}		
	
}
