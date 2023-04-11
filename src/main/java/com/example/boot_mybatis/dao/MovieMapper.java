package com.example.boot_mybatis.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.boot_mybatis.model.Movie;


@Mapper
public interface MovieMapper {

	
	public List<Movie> getListMovie(@Param("search") String search,
									@Param("genre") String[] genre,
									RowBounds pageNum,
									@Param("fromdate") Date fromDate,
									@Param("todate") Date toDate,
									@Param("sortby") String SortBy);

	public int addMovie(@Param("movie") Movie movie);
	
	public void addMovieGenre(@Param("movie_id") int movie_id, @Param("genre_id")int genre_id );

	public Movie getMoviebyId(@Param("id") int id);

	public void updateMovie(@Param("movie") Movie movie);

	public void deleteMovieGenre(@Param("id") int id);

	public void deleteMovie(@Param("id") int id);
	
		
}
