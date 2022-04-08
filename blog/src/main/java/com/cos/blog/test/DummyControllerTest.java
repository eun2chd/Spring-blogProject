package com.cos.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	
	
	// {id} 주소로 파라메터를 전달 받을 수 있다.
	// http://localhost:8002/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// user/? 를 DB에서 찾고자 할때 못찾게 되면 user가 null 이 된다.
		// return 할때 null 이 return 이 되는데 그럼 프로그램에 문제가 생김
		// Optional로 너의 User 객체를 감싸서 가져올테니 null 인지 아닌지 판단해서 return 해야한다.
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
		
		@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
			}	
		});
		return user;
	}
	

	// http://localhost:8002/blog/dummy/join
	@PostMapping("dummy/join")
	public String join(User user) {
		System.out.println("id : " + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("CreateDate : " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
		
	}
	
}
