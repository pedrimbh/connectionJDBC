package com.jpedro.JavaJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

		private Connection connection = null;
		private PreparedStatement statement =  null;
		
		public MovieDAO() {
			
			connection = new ConnectionFactory().getConnection();
		}
		
	public List<Movies> FindAll() throws SQLException{
		String query = "SELECT * from movie";
		List<Movies> movies = new ArrayList<Movies>();
		
		statement = connection.prepareStatement(query);
		
		ResultSet res = statement.executeQuery();
		
		while(res.next()){
			movies.add(new Movies(res.getInt("id"), res.getString("name")));
			
		}
		return movies;
	}
	
	public void insert(Movies movies) throws SQLException {
		String query = "INSERT INTO movie (name) VALUES (?)";
		
		statement = connection.prepareStatement(query);
		statement.setString(1, movies.getName());
		statement.execute();
	}
	
	public Movies findId(Integer id) throws SQLException {
		String query = "SELECT * FROM movie WHERE id = ?";
		
		statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		
		Movies movies = null;
		
		while(res.next()) {
			movies = new Movies(res.getInt("id"), res.getString("name"));
		}
		return movies;
	}
	
	public void update(Movies moviesOld, Movies moviesNew) throws SQLException {
		String query = "UPDATE movie SET name = ? WHERE id = ?";
		
		statement = connection.prepareStatement(query);
		statement.setString(1, moviesNew.getName());
		statement.setInt(2, moviesNew.getId());
		statement.execute();
		
	}
	public void delete(Movies movies) throws SQLException {
		String query = "DELETE FROM movie WHERE  id = ?";
		
		statement = connection.prepareStatement(query);
		statement.setInt(1, movies.getId());
		statement.execute();
	}
	
}
