package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example06Controller {
  
	@GetMapping("/exam06")
	public String requestMethod(ModelMap model) {
		model.addAttribute("data", "ModelMap 예제입니다");
		model.addAttribute("data2", "웹 요청 URL은 /home/exam06 입니다");
		System.out.println("[DEBEG] Here are Example06Controller");
		return "webpage05";
		 
		   
		
		
	}
	
	
	
}
