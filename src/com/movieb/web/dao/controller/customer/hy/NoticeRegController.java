package com.movieb.web.dao.controller.customer.hy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieb.web.dao.NoticeDao;
import com.movieb.web.dao.mybatis.MyBatisNoticeDao;
import com.movieb.web.entities.Notice;

@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regdate = request.getParameter("regdate");
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		Notice n = new Notice();		
		n.setTitle(title);
		n.setContent(content);
		// ���� �α��� ����� ������ ��� ����
		n.setWriter("newlec");
		
		noticeDao.insert(n);
		
		response.sendRedirect("notice");
	}
}






