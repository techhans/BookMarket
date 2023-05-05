package com.springmvc.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
// @RequestMapping("/home")
@RequestMapping("/exam01")
public class Example01Controller {
	
	
	public static Logger logger = LoggerFactory.getLogger(Example01Controller.class);
/*	
	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "webpage13_01";
	}
*/	
	@GetMapping
	public String showForm(Model model) {

		return "webpage14_01";
	}
/*	
	@PostMapping
	public String submit(@Valid @ModelAttribute Product product, Errors errors) {
		if(errors.hasErrors()) {
			return "webpage13_01";
		}
		return "webpage13_result";
	
	}
*/
	@PostMapping
	public String submit(@RequestBody String param, Model model) {
		model.addAttribute("title", "@RequestBody로 정보 받기");
		model.addAttribute("result", param);		

		return "webpage14_result";
	
	}
	
//	@GetMapping("/exam01")
//	public String requestMethod(Model model) {
//		return "webpage08_01";
//	}
	//@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="요청 실패하였습니다. 하하하")
//	@GetMapping("/exam01")
//	public String requestMethod(Model model) {
//		
//		
//		logger.trace("trace message");
//		logger.debug("debug message");
//		logger.info("info message");
//		logger.warn("warn message");
//		logger.error("error message");
//		
//		
//		//System.out.println("chapter10_01 예제입니다.");
//		model.addAttribute("data", "@log4j 처리 예제입니다.");
//		
//		return "webpage11_01";
//		
//		
//	}
	
	@GetMapping("/exam01")
	public String requestMethod(Model model) {
		return "webpage12_01";
		
	}	
	
	@GetMapping("/admin/main")
	public String requestMethod2(Model model) {
		model.addAttribute("data", "/webpage01/adminPage.jsp");
		return "webpage01/adminPage";
	}
	
	@GetMapping("/manager/main")
	public String requestMethod3(Model model) {
		model.addAttribute("data", "/webpage01/managerPage.jsp");
		return "webpage01/managerPage";
	}
	
	@GetMapping("/member/main")
	public String requestMethod4(Model model) {
		model.addAttribute("data", "/webpage01/memberPage.jsp");
		return "webpage01/managerPage";
	}
	
	@GetMapping("/home/main")
	public String requestMethod5(Model model) {
		model.addAttribute("data", "/webpage01/homePage.jsp");
		return "webpage01/homePage";
	}
	
	
/*	
	@GetMapping("/exam01/{bookId}")
	public String requestMethod(@PathVariable String bookId, Model model) {
		System.out.println("[DEBUG] 도서 ID : "+bookId);
		model.addAttribute("data", "도서 ID : "+bookId);
		return "webpage06";
	}
*/
/*
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
*/	
	@GetMapping("/form")
	public String requestForm() {
		return "webpage09_01";
	}
	
	@PostMapping("/form")
	public String submitForm(@RequestParam("name") String name,@RequestParam("fileImage") MultipartFile file) {
		String filename = file.getOriginalFilename();
		File f = new File("c:\\upload\\" + name + "_" + filename);
		
		try {
			file.transferTo(f);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "webpage09_submit";
	}
}
