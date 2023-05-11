package com.springmvc.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	

//	@NotNull
//	@Size(min=1)
	@NotNull
	@Size(min=4, max=10, message="4자에서 10자 이내로 입력해 주세요")	
	private String name;

//	@NotNull
//	@Size(min=1)

	@Min(value=0, message="0 이상의 값을 입력해 주세요")
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
}
