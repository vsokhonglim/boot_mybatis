package com.example.boot_mybatis.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;


public class Movie {
	
	
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	private String title;
	
	private String description;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releasedate;
	
	private List<Genre> movieGenre;
	
	
	public List<Genre> getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(List<Genre> movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", releasedate=" + releasedate
				+ ", movieGenre=" + movieGenre + "]";
	}
	
	
	
	

}
