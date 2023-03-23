package com.example.boot_mybatis.service;

import java.util.Date;
import java.util.List;

import com.example.boot_mybatis.model.Movie;


public interface MovieService {
	public List<Movie> getListMovie(String search, String[] genre, int pageNum, Date fromDate, Date toDate,String SortBy);
}
