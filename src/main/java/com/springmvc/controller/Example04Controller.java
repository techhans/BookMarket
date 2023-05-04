package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Member;
import com.springmvc.exception.Example03Exception;

//@RequestMapping("/home")
@Controller
@ControllerAdvice(basePackages= {"com.springmvc"})
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
		binder.setAllowedFields("id","password","city","sex");
//		binder.setDisallowedFields("hobby");
	}
	
//	@GetMapping("/login")
//	public String requestMethod(Model model) {
//		return "loginform";
//	}
//	
//	@GetMapping("/admin")
//	public String requestMethod2(Model model) {
//		return "webpage08_04";
//	}
//	
//	@GetMapping("/logout")
//	public String logout(Model model) {
//		return "loginform";
//	}
	
//	@ExceptionHandler(value= {RuntimeException.class})
//	public ModelAndView handleException(Exception ex) {
//		ModelAndView model = new ModelAndView();
//		model.addObject("errorMessage", "Example04Exception 메시지입니다.");
//		model.addObject("exception", ex);
//		model.setViewName("webpage10_03");
//		return model;
//	}
}
