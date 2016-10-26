package com.movieb.web.dao.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieb.web.dao.NoticeDao;
import com.movieb.web.dao.mybatis.MyBatisNoticeDao;
import com.movieb.web.model.NoticeModel;


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

		NoticeDao noticedao;
		List<NoticeModel> list;

		noticedao = new MyBatisNoticeDao();
		list = noticedao.getList(page, field, query);
		int count= noticedao.getCount(field, query);
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		// 1. �׳ɺθ���
		// response.sendRedirect("notice.jsp");
		// 2. �ڿ��� �����ϸ鼭 �θ���: ��������ϰŶ�
		request.getRequestDispatcher("/WEB-INF/views/customer/review.jsp").forward(request, response);//

	}

}


