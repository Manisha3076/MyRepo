package com.jdbc.projects.bookreview2;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import utility.ConnectionProvider;

/**
 * Hello world!
 *
 */
/*create procedure proc_test(in a int,in b int, out c int,out name varchar(20))
      
       Begin
        
        set c=a+b;
        set name=Manisha’; 
    
       end !
*/
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        System.out.println( "Hello World!" );
        
        Connection connection=ConnectionProvider.getCOnnection();
        
        try {
			CallableStatement cstmt=connection.prepareCall("{call proc_test(?,?,?,?)}");
			cstmt.setInt(1, 10);
			cstmt.setInt(2, 30);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			
			int res=cstmt.getInt(3);
			String name=cstmt.getString(4);
			System.out.println("Result :"+res);
			System.out.println("Name :"+name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
       // Menu menu=new Menu();
        //menu.displayMenu();
    }
}
