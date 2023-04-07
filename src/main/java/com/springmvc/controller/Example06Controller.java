package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example06Controller {
  
	@GetMapping("/exam06/{bookId}/category/{category}")
	public String requestMethod(
			@MatrixVariable MultiValueMap<String, String> matrixVars,
			@MatrixVariable(pathVar="category") MultiValueMap<String, String> matrixVars2,
			Model model) {
		
		System.out.println("[DEBUG]"+matrixVars);
		System.out.println("[DEBUG]"+matrixVars2);
		
		model.addAttribute("data", matrixVars+"<br>"+matrixVars2);
		return "webpage06";
		
//		model.addAttribute("data", "ModelMap �����Դϴ�");
//		model.addAttribute("data2", "�� ��û URL�� /home/exam06 �Դϴ�");
//		System.out.println("[DEBEG] Here are Example06Controller");
//		return "webpage05";
	
		
	}
	
	
	
}
