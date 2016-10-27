package com.movieb.web.dao;

import java.util.List;

import com.movieb.web.entities.Review;
import com.movieb.web.model.ReviewModel;

public interface ReviewDao {
	Review get(String code);
	List<ReviewModel> getList(int page, String field, String query);
	List<ReviewModel> getList(int page);
	List<ReviewModel> getList();
	int insert(Review notice);
	int update(Review notice);
	int delete(String code);
	int getCount(String field, String query);
}
