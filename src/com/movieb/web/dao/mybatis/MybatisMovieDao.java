package com.movieb.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.movieb.web.dao.MovieDao;
import com.movieb.web.entities.Movie;



public class MybatisMovieDao implements MovieDao 
{
	SqlSessionFactory ssf;
	
	public MybatisMovieDao()
	{
		ssf = NewlecSessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public Movie get(String code) {
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
				
		return movieDao.get(code);
	}

	@Override
	public List<Movie> getList(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		
		return movieDao.getList(page,field,query);
	}

	@Override
	public List<Movie> getList(int page) {
		return getList(page,"title","");
	}

	@Override
	public List<Movie> getList() {
		return getList(1,"title","");
	}

	@Override
	public int getCount(String field, String sQuery) 
	{
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		
		int count = movieDao.getCount(field, sQuery);
		session.close();
		return count;
	}

}
