package com.movieb.web.dao;

import java.util.List;

import com.jeryun.web.entities.Movie;



public interface MovieDao 
{
	Movie get(String code);
	
	List<Movie> getList(int page, String field,String query);
	List<Movie> getList(int page);
	List<Movie> getList();

	int getCount(String field, String sQuery);
}
