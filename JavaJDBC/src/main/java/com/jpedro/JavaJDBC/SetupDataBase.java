package com.jpedro.JavaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SetupDataBase {
	public static void main(String[] args) throws SQLException {
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
    
    if(connection == null) {
        System.out.println("connected faill");
        return;
    }
   java.sql.Statement statement = connection.createStatement();
   
  String sql = "CREATE TABLE IF NOT EXISTS movie (id INTEGER NOT NULL AUTO_INCREMENT, name  VARCHAR (255) NOT NULL, PRIMARY KEY (id))";
   
  // String sql = "DROP TABLE movie";
   
   statement.executeUpdate(sql);
}
	}

