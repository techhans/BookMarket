package com.springmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Member;

@Controller
//@RequestMapping("/home")
@RequestMapping("/exam03")
public class Example03Controller {
	
	@RequestMapping("/exam03/{bookId}")
	public String requestMethod(@PathVariable String bookId, @MatrixVariable String category, Model model) {
		System.out.println("[DEBUG] 도서 ID : "+bookId);
		System.out.println("[DEBUG] 도서 분야 : " + category);
		model.addAttribute("data","도서 ID:"+bookId+"<br>"+"도서 분야:"+category);
		 
		return "webpage06";
	}
	
	@GetMapping("/exam03")
	public String showForm() {
		return "webpage07_03";
	}
	
	@ModelAttribute("title")
	public String setTitle() {
		return "@ModelAttribute 유형";
		
	}
	
	@ModelAttribute
	public void setsubTitle(Model model) {
		model.addAttribute("subtitle", "메소드에 @modelAttribute 애노테이션 적용하기");
	}
	
	@GetMapping("/form")
	public String requestForm(Member member) {
		return "webpage09_02";
	}
	
	@PostMapping("/form")
	public String submitForm(@ModelAttribute("member") Member member, HttpServletRequest request, HttpSession session) {
		String name = member.getName();
		String filename = member.getImageFile().getOriginalFilename();
		try {
			member.getImageFile().transferTo(new File("c:\\upload\\"+name+"_"+filename));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "webpage09_submit";
	}
}
