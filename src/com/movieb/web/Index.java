package com.movieb.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class Index extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String _cnt = request.getParameter("cnt");

		int cnt = 0;
		
		if(_cnt != null) 
		    cnt = Integer.parseInt(_cnt);
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"greeting\" method=\"get\">");
		out.write("		<fieldset>");
		out.write("			<legend>ȯ���λ� �Է���</legend>");
		out.write("			<div>");
		out.write("				<label>�ݺ�ȸ��:</label>");
		out.write("				<input type=\"text\" name=\"cnt\" />");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<input type=\"submit\" value=\"say hello\" />");
		out.write("			</div>");
		out.write("		</fieldset>");
		out.write("	</form>");
		for(int i=0; i<cnt; i++)		
			out.println((i+1)+": �ȳ� Servlet!!<br />");
		out.write("</body>");
		out.write("</html>");
	}
}
