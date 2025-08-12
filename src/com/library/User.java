package com.library;

public class User {
	private int user_id;
	private String name;
	private String email; 
	//constructor for adding users
	public User(String n,String em) {
		name=n;
		email=em;
		
		
	}
	public User(int id,String n,String em) {
		this.user_id=id;
		name=n;
		email=em;
		
	}
	public int getId() {
		return user_id;
	}
	public void setId(int id) {
		this.user_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
