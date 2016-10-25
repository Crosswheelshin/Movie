package com.movieb.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.movieb.web.dao.NoticeDao;
import com.movieb.web.entities.Notice;
import com.movieb.web.model.NoticeModel;

public class MyBatisNoticeDao implements NoticeDao {
	
	SqlSessionFactory ssf;
	
	public MyBatisNoticeDao() {
		ssf = NewlecSessionFactoryBuilder.getSqlsessionFactory();
	}
	
	@Override
	public Notice get(String code) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);		
		
		return noticeDao.get(code);
	}

	@Override
	public List<NoticeModel> getList(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);		
		
		return noticeDao.getList(page, field, query);
	}

	@Override
	public List<NoticeModel> getList(int page) {
		
		return getList(page, "TITLE", "");
	}
	
	@Override
	public List<NoticeModel> getList(){
		
		return getList(1, "TITLE", "");
	}

	@Override
	public int insert(Notice notice) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);		
		
		int result = noticeDao.insert(notice);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int update(Notice notice) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);		
		
		int result = noticeDao.update(notice);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);		
		
		int result = noticeDao.delete(code);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);		
		
		int count =  noticeDao.getCount(field, query);
		
		session.close();
		
		return count;				
	}
	
}






