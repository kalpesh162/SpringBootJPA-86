package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/cool")
	public String sayHello() {
		return "sayHello Again !!!";
	}
	
}
