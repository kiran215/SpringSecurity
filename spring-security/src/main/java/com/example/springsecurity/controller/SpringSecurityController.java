package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {

	
	@GetMapping("/")
	public String greetings() {
		return "Welcome";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welcome user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome admin";
	}
	
}
