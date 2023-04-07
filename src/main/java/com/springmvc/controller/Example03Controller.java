package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example03Controller {
	
	@RequestMapping("/exam03/{bookId}")
	public String requestMethod(@PathVariable String bookId, @MatrixVariable String category, Model model) {
		System.out.println("[DEBUG] ���� ID : "+bookId);
		System.out.println("[DEBUG] ���� �о� : " + category);
		model.addAttribute("data","����ID:"+bookId+"<br>"+"�����о�:"+category);
		
		return "webpage06";
	}
	
}
