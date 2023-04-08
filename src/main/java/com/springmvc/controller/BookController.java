package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; // add
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

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
	

//	public String requestAllBooks(Model model) {
	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		ModelAndView mav = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		//model.addAttribute("bookList", list);
		mav.addObject("bookList", list);
		mav.setViewName("books");
		System.out.println("[DEBUG] requestBookList RequestMapping all");
		return mav;
		
		
//		return "books";
		
	}
	
// add
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		System.out.println("[DEBUG][BookController]="+booksByCategory);
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
// 	Set<Book> getBookListByFilter(Map<String, List<String>> filter);	
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(
			@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter,
			Model model) {
				Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
				model.addAttribute("bookList", booksByFilter);
				return "books";
	
	}
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
//	@GetMapping("/add")
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String requestAddBookForm(Book book) {
		return "addBook";
	}
	
	
	
}
