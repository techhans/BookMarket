package com.springmvc.domain;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.springmvc.validator.BookId;

@SuppressWarnings("serial")
public class Book implements Serializable{
//    private static final long serialVersionUID = -7715651009026349175L; 
	@BookId
	//@Pattern(regexp="ISBN[1-9]+" , message="{Pattern.NewBook.bookId}")

	//@NotNull(message="{NotNull.Product.name}")
	@Pattern(regexp="ISBN[1-9]+")
	private String bookId;     // 도서ID
    
	//@Size(min=4, max=50, message="{Size.NewBook.name}")
	
	//@NotNull(message="{NotNull.Product.name}")
	@Size(min=4, max=50)	
	private String name;      // 도서명
    
//	@Min(value=0 , message="{Min.NewBook.unitPrice()}")
//	@Digits(integer=8, fraction=2, message="{Digits.NewBook.unitPrice}")
//	@NotNull(message="{NotNull.NewBook.unitPrice}")
	@Min(value=0)
	@Digits(integer=8, fraction=2)
	@NotNull	
	private int unitPrice;      // 가격
	
    private String author;     // 저자
    private String description; // 설명
    private String publisher;   // 출판사
    private String category;    // 분류
    private long unitsInStock;  // 재고수
    private String releaseDate; // 출판일(월/년)
    private String condition;   // 신규 도서 or 중고 도서 or 전자책
	private MultipartFile bookImage; // 도서 이미지    
    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String  fileName; 
    
    public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}


    
    
    public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String bookId, String name, int unitPrice) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }    
    
}