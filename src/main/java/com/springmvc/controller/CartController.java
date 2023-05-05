package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Cart;
import com.springmvc.service.CartService;
import com.springmvc.domain.Book;
import com.springmvc.service.BookService;
import com.springmvc.exception.BookIdException;
import com.springmvc.domain.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private BookService bookService;

    @GetMapping  
    public String requestCartId(HttpServletRequest request) {
        String sessionid = request.getSession(true).getId();
        return "redirect:/cart/"+ sessionid;
    }  

    @PostMapping  
    public @ResponseBody Cart create(@RequestBody Cart cart ) {
        return cartService.create(cart);
    }  

    @GetMapping( "/{cartId}") 
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart",cart);
        return "cart";
    } 

    @PutMapping("/{cartId}") 
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    } 
    
    @PutMapping("/add/{bookId}")  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)    // 오류 응답 상태 코드 설정
    public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest request) {
    	// 장바구니 ID인 세션ID 가져오기
        String sessionId = request.getSession(true).getId();  
        Cart cart = cartService.read(sessionId);  // 장바구니에 등록된 모든 정보 얻어 오기  
        if(cart== null)
        	cart = cartService.create(new Cart(sessionId));
        // 경로 변수 bookId에 대한 정보 얻어 오기
        Book book = bookService.getBookById(bookId);  
        if(book == null)
        	throw new IllegalArgumentException(new BookIdException(bookId));
        // bookId에 대한 도서 정보를 장바구니에 등록하기
        cart.addCartItem(new CartItem(book));  
        cartService.update(sessionId, cart);     // 세션 ID에 대한 장바구니 갱신하기
    } 
    
    @PutMapping("/remove/{bookId}")  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartByItem(@PathVariable String bookId, HttpServletRequest request) {
    	// 장바구니 ID인 세션 ID 가져오기
        String sessionId = request.getSession(true).getId();  
        Cart cart = cartService.read(sessionId);    // 장바구니에 등록된 모든 정보 얻어 오기
        if(cart== null)
            cart = cartService.create(new Cart(sessionId));
        	// 경로 변수 bookI에 대한 정보 얻어오기
            Book book = bookService.getBookById(bookId);  
        if(book == null)
            throw new IllegalArgumentException(new BookIdException(bookId));
        // bookId에 대한 도서 정보를 장바구니에서 삭제하기 
        cart.removeCartItem(new CartItem(book));  
        cartService.update(sessionId, cart);     // 세션ID 에 대한 장바구니 갱신하기
    }  
    
    @DeleteMapping("/{cartId}")  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCartList(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }  
}