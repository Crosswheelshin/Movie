package com.movieb.web.dao.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieb.web.dao.ReviewDao;
import com.movieb.web.dao.mybatis.MyBatisReviewDao;
import com.movieb.web.model.ReviewModel;


@WebServlet("/customer/review")
public class ReviewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String t = request.getParameter("t");
		String q = request.getParameter("q");
		String p = request.getParameter("p");

		int page = 1;
		String query = "";
		String field = "TITLE";
	
		
		if (p != null && !p.equals('1'))
			page = Integer.parseInt(p);
		if (t != null && !t.equals(""))
			field = t;
		if (q != null)
			query = q;

		ReviewDao reviewDao;
		List<ReviewModel> list;

		reviewDao = new MyBatisReviewDao();
		list = reviewDao.getList(page, field, query);
		int count= reviewDao.getCount(field, query);
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		// 1. 그냥부르기
		// response.sendRedirect("notice.jsp");
		// 2. 자원을 공유하면서 부르기: 일을계속하거라
		request.getRequestDispatcher("/WEB-INF/views/customer/review.jsp").forward(request, response);//

	}

}



