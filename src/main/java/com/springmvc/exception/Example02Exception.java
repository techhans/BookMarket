package com.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="찾을 수 없습니다.")
public class Example02Exception {
	public Example02Exception(String message) {
		super();
		System.out.println(message);
	}
}
