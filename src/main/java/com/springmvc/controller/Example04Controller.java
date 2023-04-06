package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class Example04Controller {
	@GetMapping("/exam04")
	public void requestMethod() {
		System.out.println("[DEBUG] @RequestMapping 예제입니다.");
		System.out.println("[DEBUG] 웹 요청 URL은 /home/exam04 입니다.");
	}
	
	
}
