package com.cos.blog.test;

// 정보를 담은 클래스 파일은 private 으로 변수를 선언한다.
// 다른 곳에서 해당 변수에 바로 접근하는것은 객체지향과 맞지않다.
// 다른곳에서 해당변수에 상태값을 변경할때는 메소드를 구현하고 메소드를 통해서 해당 변수의 상태값을 변경한다.
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
}


