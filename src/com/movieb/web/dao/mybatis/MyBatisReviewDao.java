package com.movieb.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.movieb.web.dao.ReviewDao;
import com.movieb.web.entities.Review;
import com.movieb.web.model.ReviewModel;

public class MyBatisReviewDao implements ReviewDao {
	
	SqlSessionFactory ssf;
	
	public MyBatisReviewDao() {
		ssf = NewlecSessionFactoryBuilder.getSqlsessionFactory();
	}
	
	@Override
	public Review get(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		return reviewDao.get(code);
	}

	@Override
	public List<ReviewModel> getList(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		return reviewDao.getList(page, field, query);
	}

	@Override
	public List<ReviewModel> getList(int page) {
		
		return getList(page, "TITLE", "");
	}
	
	@Override
	public List<ReviewModel> getList(){
		
		return getList(1, "TITLE", "");
	}

	@Override
	public int insert(Review notice) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.insert(notice);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int update(Review notice) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.update(notice);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.delete(code);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int count =  reviewDao.getCount(field, query);
		
		session.close();
		
		return count;				
	}
	
}






