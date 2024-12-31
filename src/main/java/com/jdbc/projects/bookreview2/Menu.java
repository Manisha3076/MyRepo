package com.jdbc.projects.bookreview2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.BookDAO;

import daoimpl.BookDAOImpl;
import model.Book;

public class Menu {
	
	public void displayMenu() throws NumberFormatException, IOException
	{
		
			Scanner scan = new Scanner(System.in);
			System.out.println("Main Menu :");
			System.out.println("1. Book :");
			System.out.println("2. User :");
			System.out.println("3. Review :");
			System.out.println("9. Exit :");

			System.out.println("Please Enter your Choice :");
			int ch = scan.nextInt();

			switch (ch) {
			case 1:
				displayBookMenu();
				break;
			case 2:
				displayUserMenu();
				break;
			case 3:
				displayReviewMenu();
				break;
			case 9:
				System.exit(0);
				break;
			default: {
				System.out.println("Please enter a valid choice :");
				ch = scan.nextInt();
			}
		}

	}

	private void displayReviewMenu() {
		// TODO Auto-generated method stub
		
	}

	private void displayUserMenu() {
		// TODO Auto-generated method stub
		
	}

	private void displayBookMenu() throws NumberFormatException, IOException {
		
		BookDAO bookdao = new BookDAOImpl();
		char choice;
		do {
		System.out.println("Book Menu :");
		System.out.println("1.Insert new Book :");
		System.out.println("2.View Book :");
		System.out.println("3.View All  Books :");
		System.out.println("4.Update Book :");
		System.out.println("5.Delete Book :");
		System.out.println("6.Return to Main Menu :");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter your choice :");
		int ch=Integer.parseInt(br.readLine());
		
		switch(ch)
		{
		   case 1:{
			     System.out.println("Enter Book Id :");
			     int bid=Integer.parseInt(br.readLine());
			     System.out.println("Enter Book Name :");
			     String bname=br.readLine();
			     System.out.println("Enter Book Price :");
			     int price=Integer.parseInt(br.readLine());
			     System.out.println("Enter Book Publisher :");
			     String publisher=br.readLine();
			     
			     Book book=new Book(bid,bname,price,publisher);
			     try {
					boolean res=bookdao.saveBook(book);
					if(res==false)
						System.out.println("Something went wrong while inserting book.");
					else
						System.out.println("Book inseerted successfully.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
			   break;
		   }
		   
		   case 2:{
			   System.out.println("Enter Book Id :");
			    int bid=Integer.parseInt(br.readLine());
			    try {
					Book book=bookdao.viewBookById(bid);
					if(book!=null)
						System.out.println(book);
					else
						System.out.println("Book with this id does not exist.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   break;
		   }
		   case 3:{
			   try {
				List<Book> blist=bookdao.viewAllBooks();
				if(blist!=null)
				{
					for(Book b:blist)
						System.out.println(b);
				}
				else
					System.out.println("No book in the record.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   break;
		   }
		   case 4:{
			   System.out.println("Please Enter Book Id for Update :");
			    int bid=Integer.parseInt(br.readLine());
			   try {
				Book book=bookdao.viewBookById(bid);
				if(book!=null)
				{
					System.out.println("Enter Book Name :");
				    String bname=br.readLine();
				    System.out.println("Enter Book Price :");
				    int price=Integer.parseInt(br.readLine());
				    System.out.println("Enter Book Publisher :");
				    String publisher=br.readLine();
				    book=new Book(bid,bname,price,publisher);
				    boolean res= bookdao.updateBook(book);
				    if(res)
				    	System.out.println("Book updated Successfully.");
				    else
				    	System.out.println("Something went wrong while updating book.");
				}
				else
					System.out.println("Book with this Id does not exist");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   break;
		   }
		   case 5:{
			   System.out.println("Please Enter Book Id for Delete :");
			    int bid=Integer.parseInt(br.readLine());
			    Book book;
				try {
					book = bookdao.viewBookById(bid);
					 if(book==null)
					    	System.out.println("Plese enter valid id:");
					    else
					    {
					    	boolean res=bookdao.deleteBook(bid);
					    	if(res)
					    		System.out.println("Book deleted successfully.");
					    	else
					    		System.out.println("Something went wrong while deleting the book.");
					    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   break;
		   }
		   case 6:{
			     displayMenu();
			   break;
		   }
		   default:{
			   System.out.println("Invalid choice :");
		   }
		   
		}
		System.out.println("Do you want to continue (y/n):");
		choice=br.readLine().toLowerCase().charAt(0);
		
	}while(choice=='y');
				
	}

}
