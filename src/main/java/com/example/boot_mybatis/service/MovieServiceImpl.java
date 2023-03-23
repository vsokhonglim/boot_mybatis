package com.example.boot_mybatis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot_mybatis.dao.MovieMapper;
import com.example.boot_mybatis.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
		@Override
	public List<Movie> getListMovie(String search, String[] genre, int pageNum, Date fromDate, Date toDate,String SortBy) {
		
						
		return movieMapper.getListMovie("%"+search+"%",genre,pageNum,fromDate,toDate,SortBy);
	
	}

}
