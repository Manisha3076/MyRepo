package dao;

import java.sql.SQLException;
import java.util.List;

import model.Book;

public interface BookDAO {
	
	boolean saveBook(Book b) throws SQLException;
	
	List<Book> viewAllBooks() throws SQLException;
	boolean updateBook(Book b) throws SQLException;
	boolean deleteBook(int id) throws SQLException;
	Book viewBookById(int id) throws SQLException;

}
