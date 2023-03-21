package com.example.boot_mybatis.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.boot_mybatis.model.Movie;


@Mapper
public interface MovieMapper {

	public List<Movie> getListMovie() ;
	
	


	
}
