package com.example.boot_mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.boot_mybatis.dao.FooMapper;
import com.example.boot_mybatis.dao.MovieMapper;



@SpringBootApplication

@MapperScan(basePackages = { "com.example.boot_mybatis.dao" }, annotationClass = Mapper.class)
public class BootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisApplication.class, args);
	}
	
	  @Autowired private MovieMapper movieMapper;
	 
	 
	 @Autowired
	    private FooMapper fooMapper;
	@Bean
    CommandLineRunner mappingDemo() {
        return args -> {
			System.out.println("hi cmd");
			System.out.println(fooMapper.now());
			 System.out.println(movieMapper.getListMovie());
        	
        	};
        }

}
