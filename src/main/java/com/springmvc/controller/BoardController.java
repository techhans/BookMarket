package com.springmvc.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.springmvc.domain.Book;
import com.springmvc.domain.Product;
import com.springmvc.service.BookService;
import com.springmvc.service.BoardService;
import com.springmvc.domain.BoardDto;


import javax.servlet.http.*;
import java.time.*;
import java.util.*;



@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
		
	
//	@GetMapping
//	public String showForm(Model model) {
//		model.addAttribute("product", new Product());
//		return "webpage13_01";
//	}
	@GetMapping // modify
	public String requestBoardList(Model model) {
//		List<Book> list = bookService.getAllBookList();
//		model.addAttribute("product", new Product());		
//		model.addAttribute("bookList", list);
		System.out.println("[DEBUG](BoardController) requestBoardList RequestMapping board");
		return "boardList2";
		
	}

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue ="1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,Model m, HttpServletRequest request) {
    	/*
        if(!loginCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL(); // 로그인을 안했으면 로그인 화면으로 이동

        try {
            int totalCnt = boardService.getCount();
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

            if(page < 0 || page > pageHandler.getTotalPage())
                page = 1;
            if(pageSize < 0 || pageSize > 50)
                pageSize = 10;

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<BoardDto> list = boardService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }
*/
        return "boardList2"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }	
    
    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new");

        return "board";
    }
    
    @PostMapping("/write") // insert니까 delete인 remove하고 동일
    public String write(BoardDto boardDto, RedirectAttributes rattr, Model m, HttpSession session) {
//        String writer = (String)session.getAttribute("id");
        String writer = "admin";    	
        
        boardDto.setWriter(writer);

        try {
            if (boardService.write(boardDto) != 1)
                throw new Exception("Write failed.");

            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("mode", "new"); // 글쓰기 모드로 
            m.addAttribute(boardDto);      // 등록하려던 내용을 보여줘야 함.
            m.addAttribute("msg", "WRT_ERR");
            return "board"; 
        }
    }    
    
    
    
    
	
}