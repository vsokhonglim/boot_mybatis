package com.example.boot_mybatis.model;

import java.util.List;

public class Genre {
	private int id;
	private String genre;
	private List<Movie> movie;
	
	
	public Genre(int id) {
		this.id = id;
	}
	public Genre() {
		
	}
	
	public List<Movie> getMovie() {
		return movie;
	}
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Genre [id=" + id + ", genre=" + genre +"]";
	}
	
	
}
