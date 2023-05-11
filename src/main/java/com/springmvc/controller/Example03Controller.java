package com.springmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Member;
import com.springmvc.domain.Person;
import com.springmvc.exception.Example03Exception;
import com.springmvc.validator.PersonValidator;


//@RequestMapping("/home")
@Controller
@RequestMapping("/exam03")
public class Example03Controller {
	
	@Autowired
	private PersonValidator personValidator;
	
	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return "webpage13_03";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "webpage13_03";
		}
		return "webpage13_result";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(personValidator);
	}
	
/*	
	@RequestMapping("/exam03/{bookId}")
	public String requestMethod(@PathVariable String bookId, @MatrixVariable String category, Model model) {
		System.out.println("[DEBUG] 도서 ID : "+bookId);
		System.out.println("[DEBUG] 도서 분야 : " + category);
		model.addAttribute("data","도서 ID:"+bookId+"<br>"+"도서 분야:"+category);
		 
		return "webpage06";
	}
	
//	@GetMapping("/exam03")
//	public String showForm() {
//		return "webpage07_03";
//	}
	
	
	@GetMapping("/exam03")
	public void handleRequest() {
		throw new Example03Exception();
	}
	
	@ExceptionHandler(Example03Exception.class)
	public ModelAndView handleException(Example03Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errorMessage", ex.getErrMsg());
		model.addObject("exception", ex);
		model.setViewName("webpage10_03");
		return model;
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
	*/
}
