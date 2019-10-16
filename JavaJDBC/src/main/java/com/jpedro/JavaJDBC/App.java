package com.jpedro.JavaJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
    	MovieDAO dao = new MovieDAO();
    	System.out.println("--------------Menu-------------");
    	System.out.println("1 - List movies");
    	System.out.println("2 - Create new movie");
    	System.out.println("3 - Update the movie");
    	System.out.println("4 - Delete movie");
    	System.out.println("--------------Menu-------------");

    	
    	int choice = scanner.nextInt();
    	
    	switch (choice) {
		case 1:
			ArrayList<Movies> data = (ArrayList<Movies>) dao.FindAll();
			
			for(Movies movies : data) {
				System.out.println("Id: " + movies.getId());
				System.out.println("Name: " + movies.getName());
			}
			break;
		case 2:
			System.out.println("Enter name: ");
			String name = scanner.next();
			dao.insert(new Movies(name));
			break;
		case 3:
			System.out.println("Enter movie id: ");
			Integer id = scanner.nextInt();
			
			Movies movieExist = dao.findId(id);
			
			if(movieExist != null) {
				System.out.println("Insert new name: ");
				String movieName = scanner.next();
				Movies newMovie = new Movies(movieExist.getId(), movieName);
				
				dao.update(movieExist, newMovie);
			}else {
				System.out.println("Id not exist");
			}
			break;
		case 4:
			System.out.println("Enter movie id: ");
			Integer idDelete = scanner.nextInt();
			
			Movies movieDelete = dao.findId(idDelete);
			
			if(movieDelete != null) {
				dao.delete(movieDelete);
			}else {
				System.out.println("Not exist");
			}
			
			break;

		default:
			System.out.println("Invalid opition");
			break;
		}
    }
}
