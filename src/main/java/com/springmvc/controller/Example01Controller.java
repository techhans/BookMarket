package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.domain.Member;



@Controller
// @RequestMapping("/home")
public class Example01Controller {
/*	
	@GetMapping("/exam01/{bookId}")
	public String requestMethod(@PathVariable String bookId, Model model) {
		System.out.println("[DEBUG] 도서 ID : "+bookId);
		model.addAttribute("data", "도서 ID : "+bookId);
		return "webpage06";
	}
*/
	@GetMapping("/member")
	public String showForm(Model model){
		Member member =new Member();
		System.out.println("[DEBUG] @GetMappping----------------");
		System.out.println("[DEBUG] 아이디 : "+member.getId());
		System.out.println("[DEBUG] 비밀번호 : "+member.getPassword());
		System.out.println("[DEBUG] 거주지 : "+member.getCity());
		System.out.println("[DEBUG] 성 별 : "+member.getSex());
		System.out.println("[DEBUG] 취 미 : "+member.getHobby());
		model.addAttribute("member", member);
	
		return "webpage07_01";
		
	}
	
}
