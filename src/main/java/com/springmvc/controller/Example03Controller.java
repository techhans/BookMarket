package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Example03Controller {
	
	@RequestMapping("/exam03")
	public void requestMethod() {
		System.out.println("[DEBUG] @RequestMapping 예제입니다");
		System.out.println("[DEBUG] 웹 요청 URL은 /exam03 입니다.");
	}
	
}
