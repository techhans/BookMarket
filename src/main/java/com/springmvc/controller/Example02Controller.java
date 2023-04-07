package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example02Controller {
	
	@GetMapping("/exam02/{category}/publisher/{publisher}")
	public String request(@PathVariable String category, @PathVariable String publisher, Model model) {
		System.out.println("[DEBUG] ���� �о� : "+category);
		System.out.println("[DEUBG] ���ǻ� : "+publisher);
		model.addAttribute("data", "���� �о� : "+category + "<br>"+"���ǻ� : "+publisher);
		return "webpage06";
		
	}
	
	
}
