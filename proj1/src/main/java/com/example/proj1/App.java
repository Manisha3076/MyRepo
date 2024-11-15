package com.example.proj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Root");
			Statement stmt=con.createStatement();
			int i=stmt.executeUpdate("insert into course(cid,cname,duration) values(101,'DANLC',2)");
			System.out.println("Record inserted....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
