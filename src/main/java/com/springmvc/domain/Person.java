package com.springmvc.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
	
	@NotNull
	@Size(min=1)
	private String name;

	@NotNull
	@Size(min=1)
	private String age;

	@NotNull
	@Size(min=1)	
	private String email;	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
