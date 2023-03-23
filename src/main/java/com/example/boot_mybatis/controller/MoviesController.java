package com.example.boot_mybatis.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.boot_mybatis.dao.GenreMapper;
import com.example.boot_mybatis.dao.MovieMapper;
import com.example.boot_mybatis.service.GenreService;
import com.example.boot_mybatis.service.MovieService;

@Controller
public class MoviesController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private GenreMapper genreMapper;
	
	@GetMapping("/")
	public String getMovielist(Model model,
	@RequestParam(value = "page", defaultValue = "1", required = false) int pageNum,
	@RequestParam(value="from",defaultValue = "1900-01-01")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fromDate,
	@RequestParam(value="to",defaultValue ="3000-01-01" )@DateTimeFormat(pattern = "yyyy-MM-dd")Date toDate,
	@RequestParam(value="search",defaultValue = "") String Search,
	@RequestParam(value="genre", required = false) String[] Genre,
	@RequestParam(value="sortby", defaultValue = "ASC",required = false) String SortBy) {
		
		
		
		int OffSet = (pageNum-1) *10;
		model.addAttribute("Movielist", movieService.getListMovie(Search,Genre,OffSet,fromDate,toDate,SortBy));
		model.addAttribute("GenreList", genreService.GetAllGenre());
		
		
		return "movie";

	}
	@GetMapping("/test")
	public String getfrag() {
		
		System.out.println(genreMapper.getMoviebyGenre());
		
		return "fragments/sidenav";

	}

}