package com.springmvc.exception;

@SuppressWarnings("serial")
public class BookIdException extends RuntimeException{
	private String bookId;
	
	public BookIdException(String bookId) {  // 생성자
		this.bookId = bookId;
	}
	
	public BookIdException() {
		// TODO Auto-generated constructor stub
	}

	public String getBookId() {  // getter method
		return bookId;
	}
}
