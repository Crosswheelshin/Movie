package com.movieb.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieb.web.dao.NoticeDao;
import com.movieb.web.dao.mybatis.MyBatisNoticeDao;
import com.movieb.web.entities.Notice;



@WebServlet("/customer/review-edit")
public class ReviewEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String code = request.getParameter("code");
		  String content= request.getParameter("content");
		  String title= request.getParameter("title");
		  
		  NoticeDao noticeDao = new MyBatisNoticeDao();
		  Notice n = new Notice();
		  
		
		  n.setTitle(title);
		  n.setCode(code);
		  n.setContent(content);	 
		  
		  noticeDao.update(n);
		  
		  response.sendRedirect("review-detail?code="+code);
	
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _code = request.getParameter("code");

	      NoticeDao noticeDao = new MyBatisNoticeDao();
	      Notice notice;
	      
	      notice = noticeDao.get(_code);
	      request.setAttribute("n", notice);
	      
	      request.getRequestDispatcher("/WEB-INF/views/customer/review-edit.jsp").forward(request, response);
	}
	

}






