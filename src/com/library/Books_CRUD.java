package com.library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class Books_CRUD {
	public void addBook(Book book) {
		try {
			Connection conn=DBConnection.getConnection();
			
			String sql="INSERT INTO Books (title,author,is_available) VALUES(?,?,?)";
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setString(1, book.getTitle());
			stm.setString(2,book.getAuthor());
			stm.setBoolean(3,book.getIsAvailable());
			//execute the query
			stm.executeUpdate();
			System.out.println("The book was added successfully ✅");
			stm.close();
			conn.close();
			
		}catch(Exception ex) {
			System.out.println("Failed to add the book ❌");
			ex.printStackTrace();
		}
		
	}
	public  List<Book> getAllBooks(){
		List<Book> books=new ArrayList<>();
		try {
			Connection conn=DBConnection.getConnection();
			String sql="SELECT * From Books";
			PreparedStatement stm=conn.prepareStatement(sql);
		    ResultSet rs=stm.executeQuery();
		    while(rs.next()) {
		    	int book_id=rs.getInt("book_id");
		    	String title=rs.getString("title");
		    	String author=rs.getString("author");
		    	boolean isAvailable=rs.getBoolean("is_available");
		    	Book book=new Book(book_id,title,author,isAvailable);
		    	books.add(book);
		    }
		    rs.close();
		    stm.close();
		    conn.close();
		}catch(Exception e) {
			System.out.println("Failed to fetch books ❌");
			e.printStackTrace();
		}
		return books;
		
		
	}
	public void updateBooks(Book book) {
		try {
			Connection conn=DBConnection.getConnection();
			String sql="UPDATE Books SET  title=?,author=?,is_available=? WHERE book_id=?";
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setString(1, book.getTitle());
			stm.setString(2, book.getAuthor());
			stm.setBoolean(3, book.getIsAvailable());
			stm.setInt(4, book.getId());
			stm.executeUpdate();
			stm.close();
			conn.close();
			System.out.println("Book updated successfully ✅");
		}catch(Exception e) {
			System.out.println("Book update failed  ❌");
			e.printStackTrace();
		}
	}
	public void deleteBooks(int id) {
		try {
			Connection conn=DBConnection.getConnection();
			String sql="DELETE FROM Books WHERE book_id=?";
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setInt(1,id);
			try {
				stm.executeUpdate();
				
			    System.out.println("Book deleted successfully :)");
			
			}catch(SQLIntegrityConstraintViolationException e ) {
				System.out.println("You cannot delete a book that exists in transactions!");
				
			}
			stm.close();
			conn.close();
				
		}catch(Exception e) {
			System.out.println("Book deletion failed!");
			e.printStackTrace();
			
		}
	}
}


