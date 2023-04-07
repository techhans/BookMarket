package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class Example07Controller {
	
	@GetMapping("/exam07")
	public String requestMethod(@RequestParam String id, Model model) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("data", "ModelAndView 예제입니다.");
//		mav.addObject("data2","웹 요청 URL은 /home/exam07 입니다.");
//		mav.setViewName("webpage05");
		model.addAttribute("data", "도서ID :"+id);
		System.out.println("[DEBEG] 도서ID :"+id);
		return "webpage06";
	
//		return mav;
	}
	
	
	
}
