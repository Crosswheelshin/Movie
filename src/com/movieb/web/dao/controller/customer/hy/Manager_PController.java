package com.movieb.web.dao.controller.customer.hy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer/m_plus")
public class Manager_PController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		request.getRequestDispatcher("/WEB-INF/views/customer/m_plus.jsp")
		.forward(request, response);
	}

}
