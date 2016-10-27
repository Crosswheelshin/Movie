package com.movieb.web.dao.controller.customer.hy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieb.web.dao.NoticeDao;
import com.movieb.web.dao.mybatis.MyBatisNoticeDao;

@WebServlet("/customer/manager-n")
public class Manger_NController extends HttpServlet{

	public class NoticeDelController extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String code = request.getParameter("code");
			
			NoticeDao noticeDao = new MyBatisNoticeDao();
					
			noticeDao.delete(code);
			
			request.getRequestDispatcher("/WEB-INF/views/customer/m_setting.jsp")
			.forward(request, response);
		}
	}
}
