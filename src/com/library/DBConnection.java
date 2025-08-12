package com.library;
import java.sql.Connection;
import java.sql.DriverManager;




public class DBConnection {
	public static Connection getConnection() throws Exception{
		String url="jdbc:mysql://localhost:3306/library_db";
		String username="root";
		String password="Emnamysql12*";
		return DriverManager.getConnection(url,username,password);
		
   }
	

	
	
	
	
	

public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
	    try {
	    	Connection con=getConnection();
	    	System.out.println("Connection  completed successfully ✅");
	    	con.close();
	    	
	    }catch(Exception e) {
	    	System.out.println("Connection failed ❌");
	    	e.printStackTrace();
	    }
	    
}
}


