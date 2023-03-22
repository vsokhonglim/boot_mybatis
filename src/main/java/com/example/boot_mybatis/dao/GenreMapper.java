package com.example.boot_mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.boot_mybatis.model.Genre;
import com.example.boot_mybatis.model.Movie;

@Mapper
public interface GenreMapper {
	
	public List<Genre> getAllGenres() ;
	
	public List<Movie> getMoviebyGenre();
}
