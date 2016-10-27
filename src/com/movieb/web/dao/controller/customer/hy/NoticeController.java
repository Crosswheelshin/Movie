package com.movieb.web.dao.controller.customer.hy;

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

@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://.../customer/notice 		==> t ? null
		//http://.../customer/notice?t=  	==> t ? ""
		
		String p = request.getParameter("p");
		String t = request.getParameter("t");
		String q = request.getParameter("q");
		
		int page = 1;
		String field = "TITLE";
		String query = "";
		
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);
			
		if(t != null && !t.equals(""))
			field = t;
		
		if(q != null)
			query = q;
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		List<NoticeModel> list = noticeDao.getList(page, field, query);
		int count = noticeDao.getCount(field, query);
				
		request.setAttribute("list", list);
		request.setAttribute("count", count);
			
		// 1. �׳� �θ��� : �װ� ���� ��!
		//response.sendRedirect("notice.jsp");
		
		// 2. �ڿ��� �����ϸ鼭 �θ��� : ���� �̾ �����!
		request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp")
			   .forward(request, response);
	}
}




