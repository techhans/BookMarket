package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Example03Controller {
	
	@RequestMapping("/exam03")
	public void requestMethod() {
		System.out.println("[DEBUG] @RequestMapping �����Դϴ�");
		System.out.println("[DEBUG] �� ��û URL�� /exam03 �Դϴ�.");
	}
	
}
