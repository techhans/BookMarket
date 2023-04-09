package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.domain.Member;

@Controller
//@RequestMapping("/home")
public class Example02Controller {
	
	@GetMapping("/exam02/{category}/publisher/{publisher}")
	public String request(@PathVariable String category, @PathVariable String publisher, Model model) {
		System.out.println("[DEBUG] 도서분야 : "+category);
		System.out.println("[DEUBG] 출판사 : "+publisher);
		model.addAttribute("data","도서분야 : "+category + "<br>"+"출판사 : "+publisher);
		return "webpage06";
		
	}
	
	@PostMapping("/member")
//	public String submitForm(@ModelAttribute Member member ,Model model) {
	public String submitForm(Member group ,Model model) {	
		System.out.println("[DEBUG] @PostMapping-----------------------");
		System.out.println("[DEBUG] 아이디 : "+group.getId());
		System.out.println("[DEBUG] 비밀번호 : "+group.getPassword());
		System.out.println("[DEBUG] 거주지 : "+group.getCity());
		System.out.println("[DEBUG] 성 별 : "+group.getSex());
		System.out.println("[DEBUG] 취 미 : ");
		for(int i=0;i<group.getHobby().length;i++) {
			System.out.println("["+group.getHobby()[i]+"]");
		}
		model.addAttribute("member", group);
		return "webpage07_02";
	}

}
