package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// 정보를 담은 클래스 파일은 private 으로 변수를 선언한다.
// 다른 곳에서 해당 변수에 바로 접근하는것은 객체지향과 맞지않다.
// 다른곳에서 해당변수에 상태값을 변경할때는 메소드를 구현하고 메소드를 통해서 해당 변수의 상태값을 변경한다.
@Data  //  get,set 메소드 자동생성
// @AllArgsConstructor : 생성자 자동으로 만들어줌
// final 키워드를 사용하는 이유 : DB에서 가져온 값을 변동하지 않을려고
// 만약 값을 바꿔야 한다면 final 키워드를 사용 x
// @RequiredArgsConstructor // final 붙은 애들한테만 생성자 자동생성

@NoArgsConstructor // 빈생성자 생성
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder // 생성자의 순서를 사용자가 지킬필요없어진다.
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}


