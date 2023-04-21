package com.example.boot_mybatis.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.boot_mybatis.dao.GenreMapper;
import com.example.boot_mybatis.dao.MovieMapper;
import com.example.boot_mybatis.exceptions.MovieNotFoundException;
import com.example.boot_mybatis.formatter.StringToGenre;
import com.example.boot_mybatis.model.Genre;
import com.example.boot_mybatis.model.Movie;
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
	
	
	  @Autowired private StringToGenre stringToGenre;
	 
	
	@GetMapping("/")
	public String getMovielist(Model model,
	@RequestParam(value = "page", defaultValue = "1", required = false) int pageNum,
	@RequestParam(value="from",defaultValue = "0001-01-01")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fromDate,
	@RequestParam(value="to",defaultValue ="3000-01-01" )@DateTimeFormat(pattern = "yyyy-MM-dd")Date toDate,
	@RequestParam(value="search",defaultValue = "") String Search,
	@RequestParam(value="genre",required = false) String[] Genre,
	@RequestParam(value="sortby", defaultValue = "ASC",required = false) String SortBy) {
		
		
		int rowCount = movieService.getMovieRowCount(Search,Genre,fromDate,toDate);
		int limit = 10;
		int offset = (pageNum-1) * limit;
		int pageCount = (int) Math.ceil((double)rowCount/ (double)limit);
				
		RowBounds rowBounds = new RowBounds(offset,limit);
		model.addAttribute("Movielist", movieService.getListMovie(Search,Genre,rowBounds,fromDate,toDate,SortBy));
		model.addAttribute("GenreList", genreService.GetAllGenre());
		model.addAttribute("limit",limit);
		model.addAttribute("rowCount",rowCount);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageCount",pageCount);
		
		
		return "movie";

	}
	
	@GetMapping("/error")
	public String error() {
		
	
		
		return "error";

	}
	
	@GetMapping("/test")
	public String getfrag() {
		
		System.out.println(genreMapper.getMoviebyGenre());
		
		return "fragments/sidenav";

	}
	
	@GetMapping("/addnew")
	public String addmovie(Model model, Movie movie) {
		
		movie = new Movie();
		model.addAttribute("movie", movie);
		model.addAttribute("GenreList", genreService.GetAllGenre());
		
		return "add-movie";

	}
	
	@PostMapping("/movie/save")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		System.out.println(movie.getId());
	
		if(movie.getId() == 0) {
			int newMovieId= movieService.addMovie(movie);
						
			for(Genre genre : movie.getMovieGenre()) {
				
				movieService.addMovieGenre(movie.getId(),genre.getId());
				
			}
		}
		else {
			movieService.updateMovie(movie);
		}
		
		return "redirect:/";

	}
	
	@GetMapping("/movie/update/{id}")
	public String updateMovie(@PathVariable(value = "id") int id, Model model) throws MovieNotFoundException{
		
		Movie movie = movieService.getMoviebyId(id);
		
		if(movie == null) {
			throw MovieNotFoundException.createWith(id);
			
		}
		
		System.out.println(movie);
		model.addAttribute("movie",movie);
		
		
		model.addAttribute("GenreList", genreService.GetAllGenre());
		
		return "add-movie";
	
		
	}
	
	
	@GetMapping("/movie/delete/{id}")
	public String deleteMovie(@PathVariable(value = "id") int id){
		
		movieService.deleteMovie(id);
		return "redirect:/";
		
	}
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Genre.class, stringToGenre);
	}
	 

}