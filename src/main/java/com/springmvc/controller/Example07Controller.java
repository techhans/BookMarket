package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class Example07Controller {
	
	@GetMapping("/exam07")
	public ModelAndView requestMethod(ModelMap model) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", "ModelAndView �����Դϴ�.");
		mav.addObject("data2","�� ��û URL�� /home/exam07 �Դϴ�.");
		mav.setViewName("webpage05");
		System.out.println("[DEBEG] Here are Example07Controller");
		return mav;
	}
	
	
	
}
