package com.example.boot_mybatis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot_mybatis.dao.MovieMapper;
import com.example.boot_mybatis.model.Genre;
import com.example.boot_mybatis.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
		@Override
	public List<Movie> getListMovie(String search, String[] genre, int pageNum, Date fromDate, Date toDate,String SortBy) {
		
						
		return movieMapper.getListMovie("%"+search+"%",genre,pageNum,fromDate,toDate,SortBy);
	
	}

		@Override
		public int addMovie(Movie movie) {
			return movieMapper.addMovie(movie);
			
		}

		@Override
		public void addMovieGenre(int movie_id, int genre_id) {
			movieMapper.addMovieGenre(movie_id, genre_id);
			
		}

		@Override
		public Movie getMoviebyId(int id) {
			
			return movieMapper.getMoviebyId(id);
		}

		@Override
		public void updateMovie(Movie movie) {
			movieMapper.updateMovie(movie);
			movieMapper.deleteMovieGenre(movie.getId());
			
			for (Genre genre : movie.getMovieGenre()) {

				movieMapper.addMovieGenre(movie.getId(), genre.getId());

			}
			
			
		}

		@Override
		public void deleteMovie(int id) {
			movieMapper.deleteMovie(id);
			movieMapper.deleteMovieGenre(id);
			
		}

}
