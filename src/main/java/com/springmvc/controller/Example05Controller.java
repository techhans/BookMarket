package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example05Controller {
	
	@GetMapping("/exam05")
	public String requestMethod(Model model) {
		model.addAttribute("data", "Model �����Դϴ�.");
		model.addAttribute("data2", "�� ��û URL�� /home/exam05�Դϴ�");
		return "webpage05";
	}
	
}