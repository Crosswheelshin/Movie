package com.movieb.web.dao.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieb.web.dao.ReviewDao;
import com.movieb.web.dao.mybatis.MyBatisReviewDao;
import com.movieb.web.entities.Review;

@WebServlet("/customer/review-reg")
public class ReviewRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/customer/review-reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String movie_title = request.getParameter("movie_title");

		
		ReviewDao reviewDao = new MyBatisReviewDao();
		
		Review n = new Review();		
		n.setTitle(title);
		n.setContent(content);
		n.setMovie_title(movie_title);
		// 현재 로그인 사용자 정보를 얻는 로직
		n.setWriter("kttank3");
		
		reviewDao.insert(n);
		
		response.sendRedirect("review");
	}
}






