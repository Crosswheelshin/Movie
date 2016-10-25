package com.movieb.web.dao;

import java.util.List;

import com.movieb.web.entities.Notice;
import com.movieb.web.model.NoticeModel;

public interface NoticeDao {
	Notice get(String code);
	List<NoticeModel> getList(int page, String field, String query);
	List<NoticeModel> getList(int page);
	List<NoticeModel> getList();
	int insert(Notice notice);
	int update(Notice notice);
	int delete(String code);
	int getCount(String field, String query);
}
