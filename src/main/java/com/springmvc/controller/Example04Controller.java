package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class Example04Controller {
	@GetMapping("/exam04")
	public void requestMethod() {
		System.out.println("[DEBUG] @RequestMapping �����Դϴ�.");
		System.out.println("[DEBUG] �� ��û URL�� /home/exam04 �Դϴ�.");
	}
	
	
}
