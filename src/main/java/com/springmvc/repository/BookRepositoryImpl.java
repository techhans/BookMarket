package com.springmvc.repository;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

	private List<Book> listOfBooks = new ArrayList<Book>();
	
	public BookRepositoryImpl() {
		Book book1 = new Book("ISBN1234", "C# ������","30000");
		book1.setAuthor("�ڿ���");
		book1.setDescription("C# �������� ���� ù ���α׷� ���� C#�� �����ϴ� ���ڸ� ������� �Ѵ�. Ư�� ���� ���α׷��Ӹ� ���� C# �Թ�����, C#�� ����Ͽ� ����(����Ƽ), ��, �����, IOT���� ������ �� �ʿ��� C# ���� ������ ������ �⺻�⸦ źź�ϰ� ������ ���� �����̴�");

		book1.setPublisher("���");
		book1.setCategory("IT������");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2020/05/29");
		
		Book book2 = new Book("ISBN1235", "Node.js ������","36000");
		book2.setAuthor("�ڿ���");
		book2.setDescription("Node.js �������� ���� ù ���α׷� ���� C#�� �����ϴ� ���ڸ� ������� �Ѵ�. Ư�� ���� ���α׷��Ӹ� ���� C# �Թ�����, C#�� ����Ͽ� ����(����Ƽ), ��, �����, IOT���� ������ �� �ʿ��� C# ���� ������ ������ �⺻�⸦ źź�ϰ� ������ ���� �����̴�");

		book2.setPublisher("���");
		book2.setCategory("IT������");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2020/07/25");
		
		Book book3 = new Book("ISBN1236", "��� CC 2020","25000");
		book3.setAuthor("�ڿ���");
		book3.setDescription("��� CC 2020�� ���� ù ���α׷� ���� C#�� �����ϴ� ���ڸ� ������� �Ѵ�. Ư�� ���� ���α׷��Ӹ� ���� C# �Թ�����, C#�� ����Ͽ� ����(����Ƽ), ��, �����, IOT���� ������ �� �ʿ��� C# ���� ������ ������ �⺻�⸦ źź�ϰ� ������ ���� �����̴�");

		book3.setPublisher("���");
		book3.setCategory("ITȰ�뼭");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2020/05/29");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);

		
	}
	
	
	
	
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return listOfBooks;
	}




	@Override
	public List<Book> getBookListByCategory(String category) {
		// TODO Auto-generated method stub
		System.out.println("[DEBUG][BookRepositoryImpl]category="+category);
		List<Book> booksByCategory = new ArrayList<Book>();
		for(int i=0;i<listOfBooks.size();i++) {
			Book book = listOfBooks.get(i);

			if(category.equalsIgnoreCase(book.getCategory())) {
				System.out.println("[DEBUG][BookRepositoryImpl]book.getName()="+book.getName());
				booksByCategory.add(book);
			}
		}
		return booksByCategory;
	}




	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		// TODO Auto-generated method stub
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();
		
		Set<String> booksByFilter = filter.keySet();
		
		
		System.out.println("[DEBUG]filter="+filter);
		System.out.println("[DEBUG]filter.keySet()="+filter.keySet());
		System.out.println("[DEBUG]booksByFilter="+booksByFilter);
		System.out.println("[DEBUG]booksByFilter.toString()="+booksByFilter.toString());
		System.out.println("[DEBUG]booksByFilter.toArray()="+booksByFilter.toArray());
		
//		if(booksByFilter.contains("publisher")) {
		if(filter.keySet().contains("publisher")) {
			for(int j=0;j<filter.get("publisher").size();j++) {
				String publisherName = filter.get("publisher").get(j);
				for(int i=0;i<listOfBooks.size();i++) {
					Book book = listOfBooks.get(i);
					
					if(publisherName.equalsIgnoreCase(book.getPublisher())) {
						booksByPublisher.add(book);
					}
				}
				
			}
			
		}
		
		if(filter.keySet().contains("category")) {
			for(int i=0;i<filter.get("category").size();i++) {
				String category = filter.get("category").get(i);
				List<Book> list = getBookListByCategory(category);
				booksByCategory.addAll(list);
				
			}
	
		}
	
		booksByCategory.retainAll(booksByPublisher);
		return booksByCategory;
		

	}




	@Override
	public Book getBookById(String bookId) {
		// TODO Auto-generated method stub
		Book bookInfo = null;
		for(int i=0;i<listOfBooks.size();i++) {
			Book book = listOfBooks.get(i);
			if(book != null && book.getBookId() != null && book.getBookId().equals(bookId)) {
				bookInfo = book;
				break;
			}
	
		}
		
		if(bookInfo == null) {
			throw new IllegalArgumentException("����ID�� "+bookId+"�� �ش絵���� ã�� �� �����ϴ�.");

		}
		
		return bookInfo;	

	}

}
