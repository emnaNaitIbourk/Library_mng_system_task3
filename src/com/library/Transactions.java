package com.library;
import java.util.Date;

public class Transactions {
	private int transactionId;
	private int book_id;
	private int user_id;
	private String action;
	private Date borrow_date;
	private Date return_date;
	//constructor for reading transactions from db
	public Transactions(int id,int bk_id,int us_id,String action,Date br_dt,Date rt_dt) {
		 transactionId=id;
		 book_id=bk_id;
		 user_id=us_id;
		 this.action=action;
		 borrow_date=br_dt;
		 return_date=rt_dt;
		 
	}
	public Transactions(int us_id,int bk_id,String act,Date br_dt,Date rt_dt) {
		user_id=us_id;
		book_id=bk_id;
		action=act;
		borrow_date=br_dt;
		return_date= rt_dt;
		
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	

}
