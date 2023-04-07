package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example01Controller {
	@GetMapping("/exam01/{bookId}")
	public String requestMethod(@PathVariable String bookId, Model model) {
		System.out.println("[DEBUG] ���� ID : "+bookId);
		model.addAttribute("data", "���� ID : "+bookId);
		return "webpage06";
	}
	
	
}
