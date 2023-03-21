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

import com.example.boot_mybatis.dao.MovieMapper;

@Controller
public class MoviesController {
	
	@Autowired
	private MovieMapper movieMapper;
	
	@GetMapping("/")
	public String getMovielist(Model model,
								@RequestParam(value = "page", defaultValue = "1", required = false) int pageNum,
								@RequestParam(value="fromdate",defaultValue = "1900-01-01")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fromDate,
								@RequestParam(value="todate",defaultValue ="3000-01-01" )@DateTimeFormat(pattern = "yyyy-MM-dd")Date toDate,
								@RequestParam(value="search",defaultValue = "") String Search) {
		
		model.addAttribute("Movielist", movieMapper.getListMovie());
		
		return "movie";

	}

}