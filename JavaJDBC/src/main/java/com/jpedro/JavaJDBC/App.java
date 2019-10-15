package com.jpedro.JavaJDBC;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("--------------Menu-------------");
    	System.out.println("1 - List movies");
    	System.out.println("2 - Create new movie");
    	System.out.println("3 - Update the movie");
    	System.out.println("4 - Delete movie");

    	
    	int choice = scanner.nextInt();
    	
    	switch (choice) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
	
			break;
		case 4:
			
			break;

		default:
			System.out.println("Invalid opition");
			break;
		}
    }
}
