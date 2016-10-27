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


@WebServlet("/customer/review-detail")
public class ReviewDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	   String _code = request.getParameter("code");

		
		ReviewDao reviewDao;
		Review review;
		reviewDao= new MyBatisReviewDao();
		review = reviewDao.get(_code);
		request.setAttribute("n", review);

		// --->${n.�÷�} or ${n["�÷�"]}

		// 1. �׳ɺθ���
		// response.sendRedirect("notice.jsp");
		// 2. �ڿ��� �����ϸ鼭 �θ���: ��������ϰŶ�
		request.getRequestDispatcher("/WEB-INF/views/customer/review-detail.jsp").forward(request, response);//

	}
	


}
