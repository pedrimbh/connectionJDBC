package com.jpedro.JavaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load");
		} catch (ClassNotFoundException e) {
			System.out.println("Falied to load");
			e.printStackTrace();
		}
    
    
    Connection connection = null;
    
    try {
    	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","1301420jp");
    }catch(SQLException e){
    	e.printStackTrace();
    }
    
    if(connection != null) {
    System.out.println("Connected");
    }else {
    System.out.println("connected faill");
    }
}
}
