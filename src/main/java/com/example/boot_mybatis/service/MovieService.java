package com.example.boot_mybatis.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.SelectKey;

import com.example.boot_mybatis.model.Movie;


public interface MovieService {
	public List<Movie> getListMovie(String search, String[] genre, int pageNum, Date fromDate, Date toDate,String SortBy);

	@SelectKey(statement="call identity()", keyProperty="nameId", before=false, resultType=int.class)
	public int addMovie(Movie movie);
	
	public void addMovieGenre(int movie_id, int genre_id);

	public Movie getMoviebyId(int id);
}
