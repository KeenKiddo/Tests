package com.test;

public class Movie {
	
	private String name;
	private String year;
	private int id;
	
	public Movie() {

	}
	
	public Movie(int id, String name, String year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}
	
	public String toString() {
		return String.format("%d - %s - %s", id, name, year);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
