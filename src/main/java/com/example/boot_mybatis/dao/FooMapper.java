package com.example.boot_mybatis.dao;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FooMapper {
	LocalDateTime now();
}
