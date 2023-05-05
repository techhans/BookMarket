package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springmvc.domain.Member;

//@Controller
//@RequestMapping("/home")
@RestController
@RequestMapping("/exam02")
public class Example02Controller {
	
	public Logger logger = LoggerFactory.getLogger(Example02Controller.class);
	
	@GetMapping("/exam02/{category}/publisher/{publisher}")
	public String request(@PathVariable String category, @PathVariable String publisher, Model model) {
		System.out.println("[DEBUG] 도서분야 : "+category);
		System.out.println("[DEUBG] 출판사 : "+publisher);
		model.addAttribute("data","도서분야 : "+category + "<br>"+"출판사 : "+publisher);
		return "webpage06";
		
	}
	
	@PostMapping("/member")
    public String submitForm(@ModelAttribute Member group ,Model model) {
//	public String submitForm(Member group ,Model model) {	
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
	
	@GetMapping("/exam02")
	public String requestMethod(Model model) {
		logger.info("뷰페이지 webpage11_02 호출");
		model.addAttribute("data", "인터셉터 예제입니다.");
		model.addAttribute("data2", "웹 요청 URL은 /exam02 입니다.");
		return "webpage11_02";		
		//return "webpage08_02";
	}
//	@GetMapping("/exam02")
//	public void handleRequest() throws Exception{
//		throw new Exception(new Example02Exception("Example02Exception 메시지입니다"));
//
//
//	}
	
	@GetMapping("/admin/tag")
	public String requestMethod2(Model model) {
		return "webpage08_02";
	}
	
	@GetMapping("/form")
	public String requestForm() {
		return "webpage09_01";
	}
	
	@PostMapping("/form")
	public String submitForm(MultipartHttpServletRequest request) {
		String name = request.getParameter("name");
		MultipartFile file = request.getFile("fileImage");
		String filename = file.getOriginalFilename();
		File f = new File("c:\\upload\\"+name+"_"+filename);
		
		try {
			file.transferTo(f);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "webpage09_submit";
	}
	
//	@GetMapping
//	public String showForm(Model model) {
//		model.addAttribute("member", new Member());
//		return "webpage13_02";
//	}
	
//	@PostMapping
//	public String submit(@Valid @ModelAttribute Member member, Errors errors) {
//		if(errors.hasErrors()) {
//			return "webpage13_02";
//		}
//		return "webpage13_result";
//	}

	@GetMapping("/json")
	public String showForm() {
		return "webpage14_02";
	}
	
	@PostMapping("/test")
	public void submit(@RequestBody HashMap<String, Object> map) {
		System.out.println(map);
	}
	

	
}
