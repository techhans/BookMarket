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
//		mav.addObject("data", "ModelAndView �����Դϴ�.");
//		mav.addObject("data2","�� ��û URL�� /home/exam07 �Դϴ�.");
//		mav.setViewName("webpage05");
		System.out.println("[DEBEG] 도서 ID :"+id);		
		model.addAttribute("data", "도서 ID :"+id);

		return "webpage06";
	
//		return mav;
	}
	
	
	
}
