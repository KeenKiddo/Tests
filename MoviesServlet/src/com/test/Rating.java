package com.test;

import java.sql.Date;

public class Rating {

	private int id;
	private int position;
	private Date date;
	private String votes;
	private Movie movie;
	
	public Rating() {

	}
	
	public Rating(int position, Date date, String votes, Movie movie) {
		//this.id = id;
		this.position = position;
		this.date = date;
		this.votes = votes;
		this.movie = movie;
	}
	
	//public String toString() {
		//	return String.format("%d - %s - %s - %s - %s", position, name, year, rating, votes);
		//}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	

}
