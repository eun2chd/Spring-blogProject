package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	// http://localhost:8002/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temphome()");
		return "/home.html";
	}
	
	@GetMapping("/temp/Img")
	public String tempImg() {
		System.out.println("tempImg()");
		return "/a.jpg";
	}
	
	@GetMapping("/temp/jsp")
	public String tempjsp() {
		System.out.println("tempjsp()");
		return "test";
	}
	
}
