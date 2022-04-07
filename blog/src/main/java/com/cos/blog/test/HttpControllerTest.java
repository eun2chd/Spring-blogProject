package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 인터넷 요청은 get만 가능하다.
// 사용자가 요청 하면 데이터를 응답해준다.
// html파일을 응답하고 싶다면 @Controller 어노테이션을 사용하도록 한다.

@RestController
public class HttpControllerTest {
	// http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get요청 : " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}
	// http://localhost:8080/http/post
	// post 로 데이터를 전달할때는 requestBody 로 전달해야한다.
	@PostMapping("/http/post") // text/plain(평문)
	public String postTest(@RequestBody Member m) {
		return "post 요청 : " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}
	// http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}
	// http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete요청";
	}
	
}
