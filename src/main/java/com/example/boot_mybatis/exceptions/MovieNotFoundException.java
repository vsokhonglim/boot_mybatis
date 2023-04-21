package com.example.boot_mybatis.exceptions;

public class MovieNotFoundException extends Exception {

	private static final long serialVersionUID = 2043032231632195908L;
	
	private int id;
	
		private MovieNotFoundException(int id) {
			this.id = id;
		}

	
	
	public static MovieNotFoundException createWith(int id) {
		
		return new MovieNotFoundException(id);
	}
	
	   @Override
	    public String getMessage() {
	        return "Movie id '" + id + "' not found";
	    }

}
