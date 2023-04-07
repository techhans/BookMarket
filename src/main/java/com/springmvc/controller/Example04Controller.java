package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class Example04Controller {
	@GetMapping("/exam04/{bookId}/category/{category}")
	public String requestMethod(@MatrixVariable(value="publisher", pathVar="bookId") String q1,
			@MatrixVariable(value="publisher", pathVar="category") String q2, Model model) {
		System.out.println("[DEBUG] ���ǻ�1 : " + q1);
		System.out.println("[DEBUG] ���ǻ�2 : " + q2);
		model.addAttribute("data","���ǻ�1:"+q1+"<br>"+"���ǻ�2:"+q2);
		return "webpage06";
		

	}
	
	
}