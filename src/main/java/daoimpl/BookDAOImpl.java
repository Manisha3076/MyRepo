package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDAO;
import model.Book;
import utility.ConnectionProvider;

public class BookDAOImpl implements BookDAO {
   
	private Connection connection=ConnectionProvider.getCOnnection();
	PreparedStatement pstmt=null;
	@Override
	public boolean saveBook(Book b) throws SQLException {
	    pstmt=connection.prepareStatement("insert into book value(?,?,?,?)");
		pstmt.setInt(1, b.getBid());
		pstmt.setString(2, b.getBname());
		pstmt.setInt(3,b.getPrice());
		pstmt.setString(4, b.getPublisher());
		int i=pstmt.executeUpdate();
		if(i>0)
			return true;
		return false;
	}

	@Override
	public Book viewBookById(int id) throws SQLException {
	    pstmt=connection.prepareStatement("select * from book where bid=?");
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
		 Book book=new Book();
		 book.setBid(rs.getInt(1));
		 book.setBname(rs.getString(2));
		 book.setPrice(rs.getInt(3));
		 book.setPublisher(rs.getString(4));
		 return book;
		}
		
	    return null;
	}

	@Override
	public List<Book> viewAllBooks() throws SQLException {
		pstmt=connection.prepareStatement("select * from book ");
		ResultSet rs=pstmt.executeQuery();
		List<Book> blist=new ArrayList<Book>();
		
		while(rs.next())
		{
		   Book book=new Book();
		   book.setBid(rs.getInt(1));
		   book.setBname(rs.getString(2));
		   book.setPrice(rs.getInt(3));
		   book.setPublisher(rs.getString(4));
		   blist.add(book);
		}
		
		if(!blist.isEmpty())
		    return blist;
		
		return null;
	}

	@Override
	public boolean updateBook(Book b) throws SQLException {
		pstmt=connection.prepareStatement("update book set bname=? , price=? , publisher=? where bid=? ");
		pstmt.setInt(4, b.getBid());
		pstmt.setString(1, b.getBname());
		pstmt.setInt(2,b.getPrice());
		pstmt.setString(3, b.getPublisher());
		int i=pstmt.executeUpdate();
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteBook(int id) throws SQLException {
		pstmt=connection.prepareStatement("delete from book where bid=? ");
		pstmt.setInt(1, id);
		int i=pstmt.executeUpdate();
		if(i>0)
			return true;
		return false;
	}

}
