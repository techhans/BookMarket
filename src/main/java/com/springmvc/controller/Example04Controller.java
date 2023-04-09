package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Member;


@Controller
//@RequestMapping("/home")
public class Example04Controller {
	@GetMapping("/exam04/{bookId}/category/{category}")
	public String requestMethod(@MatrixVariable(value="publisher", pathVar="bookId") String q1,
			@MatrixVariable(value="publisher", pathVar="category") String q2, Model model) {
		System.out.println("[DEBUG] 출판사1 : " + q1);
		System.out.println("[DEBUG] 출판사2 : " + q2);
		model.addAttribute("data","출판사1:"+q1+"<br>"+"출판사2:"+q2);
		return "webpage06";
		

	}
	@GetMapping("/exam04")
	public String showForm(Model model) {
		model.addAttribute("member", new Member());
		return "webpage07_01";
	}
	
	@PostMapping("/exam04")
	public String submit(@ModelAttribute Member member, Model model) {
		model.addAttribute("member", member);
		return "webpage07_02";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.setAllowedFields("id","password","city","sex");
		binder.setDisallowedFields("hobby");
	}
	

	
	
	
}
