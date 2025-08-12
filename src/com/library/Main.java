package com.library;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        Books_CRUD book_crud = new Books_CRUD();
        Users_CRUD user_crud = new Users_CRUD();
        Transactions_CRUD transaction_crud = new Transactions_CRUD();
        
        	while (true) {
                System.out.println("\n=== Library Menu ===");
                System.out.println("1 - Add Book");
                System.out.println("2 - View All Books");
                System.out.println("3 - Update Book");
                System.out.println("4 - Delete Book");
                System.out.println("5 - Add User");
                System.out.println("6 - View All Users");
                System.out.println("7 - Update User");
                System.out.println("8 - Delete User");
                System.out.println("9 - Borrow Book");
                System.out.println("10 - Return Book");
                System.out.println("11- View Transactions");
                System.out.println("0 - Exit");
                System.out.print("Choose option: ");

                int choice = Integer.parseInt(s.nextLine());
                switch (choice) {
                case 1: // Add Book
                    System.out.print("Book title: ");
                    String title = s.nextLine();
                    System.out.print("Book author: ");
                    String author = s.nextLine();
                    book_crud.addBook(new Book(title,author,true));
                    break;
                 case 2:
                	 // View All Books
                	 System.out.println("Here  is the list of all books: ");
                    List<Book> books = book_crud.getAllBooks();
                    for (Book b : books) {
                        System.out.println(b.getId() + " - " + b.getTitle() + " by " + b.getAuthor()
                                + " | Available: " + b.getIsAvailable());
                    }
                    break;
                 case 3: // Update Book
                     System.out.print("Book ID to update: ");
                     int bookIdU = Integer.parseInt(s.nextLine());
                     System.out.print("New title: ");
                     String newTitle = s.nextLine();
                     System.out.print("New author: ");
                     String newAuthor = s.nextLine();
                     book_crud.updateBooks(new Book(bookIdU,newTitle,newAuthor,true));
                     break;
                 case 4: // Delete Book
                     System.out.print("Book ID to delete: ");
                     int bookIdD = Integer.parseInt(s.nextLine());
                     book_crud.deleteBooks(bookIdD);
                     break;
                 case 5: // Add User
                     System.out.print("User name: ");
                     String name = s.nextLine();
                     System.out.print("User email: ");
                     String email = s.nextLine();
                     user_crud.addUser(new User(name,email));
                     break;

                 case 6: // View All Users
                	 System.out.println("Here is the list o fall users: ");
                     List<User> users = user_crud.getAllUsers();
                     for (User u : users) {
                         System.out.println(u.getId() + " - " + u.getName()+ " (" + u.getEmail() + ")");
                     }
                     break;

                 case 7: // Update User
                     System.out.print("User ID to update: ");
                     int userIdU = Integer.parseInt(s.nextLine());
                     System.out.print("New name: ");
                     String newName = s.nextLine();
                     System.out.print("New email: ");
                     String newEmail = s.nextLine();
                     user_crud.updateUser(new User(userIdU,newName,newEmail));
                     break;

                 case 8: // Delete User
                     System.out.print("User ID to delete: ");
                     int userIdD = Integer.parseInt(s.nextLine());
                     user_crud.deleteUser(userIdD);
                     break;
                 case 9: // Borrow Book
                     System.out.print("User ID: ");
                     int borrowUserId = Integer.parseInt(s.nextLine());
                     System.out.print("Book ID: ");
                     int borrowBookId = Integer.parseInt(s.nextLine());
                     transaction_crud.borrowBook(borrowUserId, borrowBookId);
                     break;
                 case 10: // Return Book
                     System.out.print("User ID: ");
                     int returnUserId = Integer.parseInt(s.nextLine());
                     System.out.print("Book ID: ");
                     int returnBookId = Integer.parseInt(s.nextLine());
                     transaction_crud.returnBook(returnUserId, returnBookId);
                     break;
                 case 11:
                	 //View all transactions
                	 System.out.println("Here  is the list of all transactions:");
                	  List<Transactions> transactions=transaction_crud.getAllTransactions();
                	  for(Transactions tr:transactions) {
                		  System.out.println(tr.getTransactionId()+ " Book id: "+tr.getBook_id()+" |User Id: "+tr.getUser_id()+" |Transaction type: "+tr.getAction()+" |Borrow Date: "+tr.getBorrow_date()+"|Return Date: "+tr.getReturn_date());
                	  }
                	  break;
                 case 0:
                     System.out.println("Goodbye!");
                     s.close();
                     return;
                 default:
                     System.out.println("Invalid choice.");
                     
                }
        	}
	}
}
		

	


