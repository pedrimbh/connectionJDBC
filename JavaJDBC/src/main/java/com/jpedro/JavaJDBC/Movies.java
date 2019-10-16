package com.jpedro.JavaJDBC;

public class Movies {

	private Integer id;
	private String name;
	
	public Movies() {
	}
	
	public Movies(String name) {
		this.name = name;
		
	}
	public Movies(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
