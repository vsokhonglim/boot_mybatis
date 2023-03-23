package com.example.boot_mybatis.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.boot_mybatis.model.Movie;


@Mapper
public interface MovieMapper {

	
	public List<Movie> getListMovie(@Param("search") String search,
									@Param("genre") String[] genre,
									@Param("offset") int pageNum,
									@Param("fromdate") Date fromDate,
									@Param("todate") Date toDate,
									@Param("sortby") String SortBy);
	
		
}
