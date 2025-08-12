package com.library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class Transactions_CRUD {
	 public void borrowBook(int userId, int bookId) {
	        try {
	            Connection conn = DBConnection.getConnection();

	            // 1️⃣ Check if book is available
	            String checkSql = "SELECT is_available FROM Books WHERE book_id=?";
	            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
	            checkStmt.setInt(1, bookId);
	            ResultSet rs = checkStmt.executeQuery();
	            if (rs.next()) {
	                boolean available = rs.getBoolean("is_available");
	                if (!available) {
	                    System.out.println("❌ Book is already borrowed!");
	                    rs.close();
	                    checkStmt.close();
	                    conn.close();
	                    return;
	                }
	            } else {
	                System.out.println("❌ Book not found!");
	                rs.close();
	                checkStmt.close();
	                conn.close();
	                return;
	            }
	            rs.close();
	            checkStmt.close();
	            String updateSql = "UPDATE Books SET is_available=false WHERE book_id=?";
	            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
	            updateStmt.setInt(1, bookId);
	            updateStmt.executeUpdate();
	            String insertSql = "INSERT INTO Transactions (user_id, book_id, tr_type,borrow_date) VALUES (?, ?, 'BORROW',CURDATE())";
	            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
	            insertStmt.setInt(1, userId);
	            insertStmt.setInt(2, bookId);
	            
	            insertStmt.executeUpdate();
	            insertStmt.close();
	            conn.close();
	            System.out.println("✅ Book borrowed successfully!");
	        } catch (Exception e) {
	            System.out.println("❌ Failed to borrow book");
	            e.printStackTrace();
	        }
	    }
	 public void returnBook(int userId, int bookId) {
	        try {
	            Connection conn = DBConnection.getConnection();

	            // 1️⃣ Mark book as available
	            String updateSql = "UPDATE Books SET is_available=true WHERE book_id=?";
	            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
	            updateStmt.setInt(1, bookId);
	            updateStmt.executeUpdate();
	            updateStmt.close();
	            String insertSql = "INSERT INTO Transactions (user_id, book_id, tr_type,return_date) VALUES (?, ?, 'RETURN',CURDATE())";
	            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
	            insertStmt.setInt(1, userId);
	            insertStmt.setInt(2, bookId);
	            insertStmt.executeUpdate();
	            insertStmt.close();
	            conn.close();
	            System.out.println("✅ Book returned successfully!");
	        } catch (Exception e) {
	            System.out.println("❌ Failed to return book");
	            e.printStackTrace();
	        }
	    }
	// Get all transactions
	    public List<Transactions> getAllTransactions() {
	        List<Transactions> transactions = new ArrayList<>();
	        try {
	            Connection conn = DBConnection.getConnection();
	            String sql = "SELECT * FROM Transactions";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	            	int tr_id=rs.getInt("transaction_id");
			    	int bk_id=rs.getInt("book_id");
			    	int us_id=rs.getInt("user_id");
			    	String action=rs.getString("tr_type");
			    	Date br_date=rs.getDate("borrow_date");
			    	Date rt_date=rs.getDate("return_date");
			    	Transactions transaction=new Transactions(tr_id,bk_id,us_id,action,br_date,rt_date);
			    	transactions.add(transaction);
			    	
			    }
	            rs.close();
	            stmt.close();
	            conn.close();
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("❌ Failed to fetch transactions");
	            e.printStackTrace();
	        }
	        return transactions;
	    }
}
	              


