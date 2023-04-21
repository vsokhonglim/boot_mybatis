package com.example.boot_mybatis.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {
	
	/*
	 * @ExceptionHandler(value = {MovieNotFoundException.class}) public
	 * ResponseEntity<Object> handleNoMovieException(MovieNotFoundException mnfe){
	 * 
	 * MovieException movieException = new MovieException(mnfe.getMessage(),
	 * HttpStatus.BAD_REQUEST, ZonedDateTime.now());
	 * 
	 * return new ResponseEntity<>(movieException,HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */
		@ExceptionHandler(value = {MovieNotFoundException.class})
		public String handleNoMovieException(MovieNotFoundException mnfe, Model model){
			
			
			model.addAttribute("message",mnfe.getMessage());
			return "notfound";
			
		}
		
	
}
