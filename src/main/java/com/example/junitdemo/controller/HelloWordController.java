package com.example.junitdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
}
