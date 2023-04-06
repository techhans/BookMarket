package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

import org.springframework.web.bind.annotation.GetMapping; // add


@Controller
@RequestMapping("/books")  //add
public class BookController {

	@Autowired
	private BookService bookService;
	
//	@RequestMapping(value="/books", method=RequestMethod.GET)
	@GetMapping // modify
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		System.out.println("[DEBUG] requestBookList RequestMapping books");
		return "books";
		
	}
	
	@GetMapping("/all")
	public String requestAllBooks(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		System.out.println("[DEBUG] requestBookList RequestMapping all");		
		return "books";
		
	}
	
}
