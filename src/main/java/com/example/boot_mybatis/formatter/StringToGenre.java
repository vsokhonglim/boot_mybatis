package com.example.boot_mybatis.formatter;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Component;

import com.example.boot_mybatis.model.Genre;

@Component
public class StringToGenre extends PropertiesEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Genre genre = new Genre(Integer.parseInt(text));
		setValue(genre);
	}

	

}
