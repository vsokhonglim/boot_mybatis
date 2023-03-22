package com.example.boot_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot_mybatis.dao.GenreMapper;
import com.example.boot_mybatis.model.Genre;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreMapper genreMapper;
	
	@Override
	public List<Genre> GetAllGenre() {
		
		return genreMapper.getAllGenres();
	}

}
