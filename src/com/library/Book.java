package com.library;

public class Book {
	private int book_id;
	private String title;
	private String author;
	private boolean isAvailable;
	//Constructor for adding books
	public Book(String t,String a,boolean av) {
		title=t;
		author=a;
		isAvailable=av;
	}
	//Constructor for reading books from db
	public Book(int id,String t,String a,boolean av) {
		
		this.book_id=id;
		title=t;
		author=a;
		isAvailable=av;
		
	}
	public int getId() {
		return book_id;
	}
	public void setId(int id) {
		this.book_id=id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	


}
