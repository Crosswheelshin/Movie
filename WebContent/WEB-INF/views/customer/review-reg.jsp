<%@page import="com.movieb.web.dao.mybatis.MyBatisReviewDao"%>
<%@page import="com.movieb.web.entities.Review"%>
<%@page import="com.movieb.web.dao.ReviewDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>
		<a href="">리뷰등록</a>
	</h1>
	<ul>
		<li><a href="../index.jsp">home</a>
		<li>
		<li><a href="review">리뷰</a>
		<li>
	</ul>
	<form action="review-reg" method="post">
		<fieldset>
			<legend>
				<table border=1>
					<tbody>
						<tr>
							<td>제목</td>
							<td><input type="text" name="title" value="${n.title}" /></td>
						</tr>
						<tr>
							<td>영화제목</td>
							<td><input type="text" name="movie_title" value="${n.movie_title}" /></td>
						</tr>

						<tr>
							<td colspan="2"><textarea name="content" rows="20" cols="60">${n.content}</textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<input type ="submit" value="등록"/>
					<a href="review">취소</a>
				</div>
			</legend>
		</fieldset>
	</form>
</body>
</html>