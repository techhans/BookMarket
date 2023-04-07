package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example05Controller {
	
	@GetMapping("/exam05/{bookId}")
	public String requestMethod(@MatrixVariable(required=false, defaultValue="���") String q, Model model) {
		System.out.println("[DEBUG] ���ǻ� : "+q);
		model.addAttribute("data", "���ǻ�:"+q);
		return "webpage06";
	}
	
}