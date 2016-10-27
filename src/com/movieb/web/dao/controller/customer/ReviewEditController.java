package com.movieb.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieb.web.dao.ReviewDao;
import com.movieb.web.dao.mybatis.MyBatisReviewDao;
import com.movieb.web.entities.Review;



@WebServlet("/customer/review-edit")
public class ReviewEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String code = request.getParameter("code");
		  String content= request.getParameter("content");
		  String title= request.getParameter("title");
		  String movie_title= request.getParameter("movie_title");
		  
		  ReviewDao reviewDao = new MyBatisReviewDao();
		  Review n = new Review();
		  
		n.setMovie_title(movie_title);
		  n.setTitle(title);
		  n.setCode(code);
		  n.setContent(content);	 
		  
		  reviewDao.update(n);
		  
		  response.sendRedirect("review-detail?code="+code);
	
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _code = request.getParameter("code");

	      ReviewDao reviewDao = new MyBatisReviewDao();
	      Review review;
	      
	      review = reviewDao.get(_code);
	      request.setAttribute("n", review);
	      
	      request.getRequestDispatcher("/WEB-INF/views/customer/review-edit.jsp").forward(request, response);
	}
	

}






