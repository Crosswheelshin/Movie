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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");

		ReviewDao reviewDao = new MyBatisReviewDao();
		Review review;

		review = reviewDao.get(code);
		int hitUp = reviewDao.hitUp(code);
		request.setAttribute("n", review);
		request.setAttribute("prev", reviewDao.getPrev(code));
		request.setAttribute("next", reviewDao.getNext(code));

		request.getRequestDispatcher("/WEB-INF/views/customer/review-detail.jsp").forward(request, response);//

	}

}
